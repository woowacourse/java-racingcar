package model;

import util.Validation;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차 이름 길이 오류");
        }
        for (int i = 0; i < name.length(); i++) {
            Validation.isAlpha(Character.toUpperCase(name.charAt(i)));
        }
        this.name = name;
    }

    Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차 이름 길이 오류");
        }

        for (int i = 0; i < name.length(); i++) {
            Validation.isAlpha(Character.toUpperCase(name.charAt(i)));
        }
        this.name = name;
        this.position = position;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}
