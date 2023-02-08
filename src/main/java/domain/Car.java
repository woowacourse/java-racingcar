package domain;

public class Car {
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("5글자 까지만 가능합니다.");
        }
    }
}
