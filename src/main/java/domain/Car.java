package domain;

import vo.Name;

public class Car {
    private final Name name;
    private Long position = 0L;

    public Car(Name name) {
        validateName(name);
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public Long getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber > 3) {
            position++;
        }
    }

    private void validateName(Name name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5글자 까지만 가능합니다.");
        }
    }

    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" : ");
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return name.getValue() + stringBuilder;
    }
}
