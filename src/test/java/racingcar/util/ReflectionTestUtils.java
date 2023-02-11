package racingcar.util;

import java.lang.reflect.Field;

public class ReflectionTestUtils {

    public static <T, F> F getDeclaredField(final T object, final String name, Class<F> fieldType) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return fieldType.cast(field.get(object));
    }

    public static <T, F> void setDeclaredField(final T object, final String name, F value) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(object, value);
    }
}
