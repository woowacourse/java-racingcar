package racingcar;

import java.util.Objects;

public class CarName {
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "1~5 사이의 값을 입력해주세요.";

    private String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }

    private void validateCarName(String carName) {
        checkCarNameLength(carName);
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
