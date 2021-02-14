package racingCar.domain.car;

import java.util.Objects;
import racingCar.exception.InvalidCarNameException;
import racingCar.utils.ValidateUtils;

public class Name {

    public static final String ERROR_MESSAGE_CAR_NAME_LENGTH = "자동차 이름은 1자 이상 5자 이하여야 합니다.";

    private final String name;

    public Name(final String name) {
        if (!ValidateUtils.isProperName(name)) {
            throw new InvalidCarNameException(ERROR_MESSAGE_CAR_NAME_LENGTH);
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
