package domain;

public class Car {

    private final int MAX_NAME_LENGTH = 5;
    private final int MIN_FORWARD_NUMBER = 4;
    private final String MAX_NAME_EXCEPTION = "[ERROR] 이름은 5글자를 초과할 수 없습니다.";
    private final String NAME_FORMAT_EXCEPTION = "[ERROR] 이름에 공백을 포함할 수 없습니다.";

    private final String name;
    private int forward;

    public Car(String name) {
        validateCarNameLength(name);
        validateNameFormat(name);

        this.name = name;
        this.forward = 0;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_EXCEPTION);
        }
    }

    private void validateNameFormat(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(NAME_FORMAT_EXCEPTION);
        }
    }

    public void drive(int randomNumber) {
        if (checkCanDrive(randomNumber)) {
            forward += 1;
        }
    }

    private boolean checkCanDrive(int randomNumber) {
        return randomNumber >= MIN_FORWARD_NUMBER;
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

}
