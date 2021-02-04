package racingcar;

public class CarName {
    private String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        checkCarNameLength(carName);
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException("1~5 사이의 값을 입력해주세요.");
        }
    }
}
