package com.tikou.libannotationcompiler

import com.google.auto.service.AutoService
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import com.tikou.libannotation.IBindView
import java.lang.reflect.Method
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements
import javax.tools.Diagnostic

/**

 * @Author Administrator
 * @Date 2022/6/15-10:34
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
@AutoService(Processor::class)
class IButterKnifeProcessor : AbstractProcessor() {

    private lateinit var msg: Messager
    private var mFiler: Filer? = null
    private var elementsUtils: Elements? = null
    override fun init(processingEnv: ProcessingEnvironment?) {
        super.init(processingEnv)
        msg = processingEnv!!.messager
        mFiler = processingEnv.filer
        elementsUtils = processingEnv.elementUtils;
    }

    /**
     * 指定支持的资源版本
     * @return SourceVersion
     */
    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    /**
     * 获取处理注解
     * @return MutableSet<String>
     */
    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        val types: MutableSet<String> = LinkedHashSet()
        for (ann in supportedAnnotations) {
            types.add(ann.canonicalName)
        }
        return types
    }


    private val supportedAnnotations: Set<Class<out Annotation?>>
        get() {
            val annotations: MutableSet<Class<out Annotation?>> = LinkedHashSet()
            annotations.add(IBindView::class.java)
            return annotations
        }


    /**
     * rebuild 后在Build栏目 > Task :app:kaptDebugKotlin需要用   processingEnv!!.messager.printMessage()会打印，而普通的println是不打印的
     * @param p0 MutableSet<out TypeElement>
     * @param p1 RoundEnvironment
     * @return Boolean
     */
    override fun process(p0: MutableSet<out TypeElement>?, p1: RoundEnvironment?): Boolean {
        msg.printMessage(Diagnostic.Kind.NOTE, "process")
        val elements: Set<Element> =
            p1?.getElementsAnnotatedWith(IBindView::class.java) ?: mutableSetOf()
        val elementsMap: LinkedHashMap<Element, MutableList<Element>> = LinkedHashMap()
        for (element in elements) {
            msg.printMessage(
                Diagnostic.Kind.NOTE,
                element.simpleName.toString() + ":" + element.enclosingElement.toString()
            )
            val enclosingElement = element.enclosingElement
            var viewBindElements: MutableList<Element>? = elementsMap[enclosingElement]
            if (elementsMap[enclosingElement] == null) {
                viewBindElements = mutableListOf()
                elementsMap[enclosingElement] = viewBindElements
            }
            viewBindElements!!.add(element)

        }

        for (entry in elementsMap.entries) {
            val enclosingElement = entry.key;
            val viewBindElement = entry.value
            val activityClassNameString = enclosingElement.simpleName.toString()
            val packageName: String =
                elementsUtils!!.getPackageOf(enclosingElement).qualifiedName.toString()
            val unBinderClassName = ClassName.get("com.tikou.moduleibuttterknife", "UnBinder")
            val callSuperName: ClassName = ClassName.get("androidx.annotation", "CallSuper")
            val activityClassName:ClassName =ClassName.bestGuess(activityClassNameString)
            val unBindMethodBuilder: MethodSpec.Builder = MethodSpec.methodBuilder("unBind")
                .addAnnotation(Override::class.java)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addAnnotation(callSuperName)

            val constructorMethodBuilder = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(activityClassName,"target")
                .addStatement("this.target = target")

            val classBuilder: TypeSpec.Builder =
                TypeSpec.classBuilder("${activityClassNameString}_viewBinding")
                    .addModifiers(Modifier.FINAL, Modifier.PUBLIC)
                    .addSuperinterface(unBinderClassName)
                    .addField(activityClassName,"target",Modifier.PRIVATE)
            for(element in viewBindElement){
                val filedName = element.simpleName.toString()
                val utilsClassName = ClassName.get("com.tikou.moduleibuttterknife","Utils")
                val resId = element.getAnnotation(IBindView::class.java).value
                //constructorMethodBuilder.addStatement("target.${filedName}=${utilsClassName}.findViewById(activity,${resId})")
                //constructorMethodBuilder.addStatement("target.\$L = \$T.Companion.findViewById(target,\$L)",filedName,utilsClassName,resId)
                constructorMethodBuilder.addStatement("target.${element} = " +
                        "target.findViewById(${element.getAnnotation(IBindView::class.java).value})")
            }

            classBuilder.addMethod(unBindMethodBuilder.build())
            classBuilder.addMethod(constructorMethodBuilder.build())

            JavaFile.builder(packageName, classBuilder.build())
                .addFileComment("IBindView 自动生成")
                .build().writeTo(mFiler)


        }
        return false
    }
}