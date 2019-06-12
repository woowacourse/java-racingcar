package domain;

import com.google.common.base.Strings;
import exception.CarNameLenExceedException;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LEN = 5;

    private final String name;

    private CarName(String name) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("이름이 null 혹은 빈문자열입니다");
        }

        checkNameLen(name);

        this.name = name;
    }

    private void checkNameLen(String name) {
        if (MAX_NAME_LEN < name.length()) {
            throw new CarNameLenExceedException(
                    String.format("이름은 %d 자 이하여야 합니다.", MAX_NAME_LEN));
        }
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
