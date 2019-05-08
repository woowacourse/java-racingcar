package com.woowacourse.javaracingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward(int position) {
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
        sb.append(name + " : ");
        for (int i = 0; i < position; i++) {
            sb.append('-');
        }

        return sb.toString();
    }
}
