package com.tikou.libannotation;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

import javax.lang.model.element.Modifier;

/**
 * @Author Administrator
 * @Date 2022/6/14-23:05
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
public final class AnnotationTest {
    public static void test(String[] args) throws IOException {
        System.out.println("Hello,AnnotationTest!");
        annotationMain();
    }

    private static void annotationMain() throws IOException {
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.tikou.libannotation", helloWorld)
                .build();

        javaFile.writeTo(System.out);//能够看出，addModifiers对方法的修饰约束，addParameter添加方法参数 ，addStatement方法体，returns返回值，最后写入java文件中
    }
}
