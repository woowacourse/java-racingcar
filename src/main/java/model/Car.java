package model;

import util.Validation;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차 이름 길이 오류");
        }
        for (int i = 0; i < name.length(); i++) {
            Validation.isAlpha(Character.toUpperCase(name.charAt(i)));
        }
        this.name = name;
    }

    public Car(String name, int position) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" : ");
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
