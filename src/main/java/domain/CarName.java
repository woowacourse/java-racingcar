package domain;

public class CarName {

    private static final int CAR_NAME_LENGTH_MAX = 5;

    private final String name;

    public CarName(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("자동차를 한 대 이상 작성해주세요.");
        }

        if (carName.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
        }
    }

    public String getName() {
        return name;
    }
}
