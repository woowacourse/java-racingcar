package domain;

public class Car {
    private final String name;

    private int position;
    private final CarAccelerator accelerator;

    private static final int MIN_MOVABLE_POWER = 4;

    public Car(String name, CarAccelerator accelerator) {
        validate(name);
        this.name = name;
        this.position = 0;
        this.accelerator = accelerator;
    }

    private void validate(String name) {
        validateName(name);
        validateNameLength(name);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 null이나 빈 문자열이 될 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름의 길이는 1 이상 5 이하여야 합니다.");
        }
    }

    public int pushAccelerator() {
        return accelerator.push();
    }

    public void moveForward(int power) {
        if (power >= MIN_MOVABLE_POWER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
