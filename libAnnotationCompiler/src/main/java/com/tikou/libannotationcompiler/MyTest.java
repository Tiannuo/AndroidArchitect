package com.tikou.libannotationcompiler;

import com.squareup.javapoet.MethodSpec;
import com.tikou.libannotation.IBindView;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * @Author Administrator
 * @Date 2022/6/15-10:39
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
public class MyTest extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        for (Class<? extends Annotation> annotation : getSupportedAnnotations()) {
            types.add(annotation.getCanonicalName());
        }
        return types;
    }

    /**
     * 参考了 ButterKnife 的写法
     *
     * @return
     */
    private Set<Class<? extends Annotation>> getSupportedAnnotations() {
        Set<Class<? extends Annotation>> annotations = new LinkedHashSet<>();
        annotations.add(IBindView.class);
        return annotations;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Map<Element, List<Element>> elementListMap = new LinkedHashMap<>();
        MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder();

        constructorBuilder.addStatement("target.$L = $T.findViewById(target,$L)",
                "filedName", "utilClassName", "codeBlock");
        return false;
    }
}
