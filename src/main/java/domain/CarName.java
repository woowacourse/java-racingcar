package domain;

public class CarName {
    private static final Integer MIN_LENGTH = 1;
    private static final Integer MAX_LENGTH = 5;
    private final String carName;

    public CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    private void validate(String carName) {
        validateNonNull(carName);
        validateLength(carName);
    }

    private void validateNonNull(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("[ERROR] 이름은 null일 수 없습니다");
        }
    }
    
    private void validateLength(String carName) {
        if (carName.length() < MIN_LENGTH || carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 자동차 이름의 길이는 %d 이상 %d 이하여야 합니다", MIN_LENGTH, MAX_LENGTH));
        }
    }

    public String getCarName() {
        return carName;
    }
}
