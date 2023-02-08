package domain;

public class Car {
    private final String name;
    private Long status = 0L;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {
        if (randomNumber > 3) {
            status++;
        }
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5글자 까지만 가능합니다.");
        }
    }

    public Long getStatus() {
        return status;
    }
}
