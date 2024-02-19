package domain;

public class CarName {

    public static final String ERROR_OF_LENGTH = "[ERROR] 자동차 이름의 길이는 5를 넘을 수 없습니다.";
    public static final int LIMIT_LENGTH = 5;

    private final String carName;

    private CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    public static CarName from(String carName) {
        return new CarName(carName);
    }

    private void validate(String carName) {
        if (carName.length() > LIMIT_LENGTH || carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_OF_LENGTH);
        }
    }

    public String getCarName() {
        return carName;
    }
}
