package com.woowacourse.javaracingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int position) {
        this.position += position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append('-');
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car)) {
            return false;
        }

        if (name.equals(((Car) o).name) &&
            (position == ((Car) o).position)) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
