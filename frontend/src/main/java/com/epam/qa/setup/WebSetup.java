package com.epam.qa.setup;

import com.epam.qa.annotations.Section;
import com.epam.qa.annotations.WebPage;
import com.epam.qa.website.WebSite;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Stream.concat;

public class WebSetup {

    public static <T extends WebSite> void init(Class<T> webSiteClass) {
        init(getInstance(webSiteClass), WebPage.class);
    }

    private static <T> void init(T instance, Class annotationClass) {
        Stream<Field> fieldsStream = concat(stream(instance.getClass().getSuperclass().getDeclaredFields()),
                stream(instance.getClass().getDeclaredFields()))
                .filter(field -> field.isAnnotationPresent(annotationClass));
        fieldsStream.forEach(field -> {
            try {
                Object section = getInstance(field.getType());
                field.setAccessible(true);
                field.set(instance, section);
                init(section, Section.class);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        });
    }

    private static <T> T getInstance(Class<T> type) {
        T instance = null;
        try {
            Constructor<T> constructor = type.getConstructor();
            instance = constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
