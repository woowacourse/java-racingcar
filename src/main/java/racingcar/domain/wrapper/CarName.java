package racingcar.domain.wrapper;

import java.util.Objects;

import static racingcar.domain.constant.CarConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.enumType.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.enumType.ExceptionMessage.LENGTH_MESSAGE;

public class CarName {

    private final String name;

    private CarName(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name.trim();
    }

    public static CarName create(final String carName) {
        return new CarName(carName);
    }

    private void validateNameBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "이름"));
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(String.format(LENGTH_MESSAGE.getValue(), CAR_NAME_MAX_LENGTH.getValue()));
        }
    }

    @Override
    public boolean equals(Object diffCarName) {
        if (this == diffCarName) return true;
        if (diffCarName == null || getClass() != diffCarName.getClass()) return false;
        CarName carName = (CarName) diffCarName;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
