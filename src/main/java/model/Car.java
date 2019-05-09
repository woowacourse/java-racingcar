package model;

import util.Validation;

public class Car {
    private final String name;
    private int position;

    Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차 이름 길이 오류");
        }
        name.toUpperCase();
        for (int i = 0; i < name.length(); i++) {
            Validation.isAlpha(name.charAt(i));
        }
        this.name = name;
    }

    Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차 이름 길이 오류");
        }
        name.toUpperCase();
        for (int i = 0; i < name.length(); i++) {
            Validation.isAlpha(name.charAt(i));
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
