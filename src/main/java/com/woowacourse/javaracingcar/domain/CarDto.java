package com.woowacourse.javaracingcar.domain;

public class CarDto {
    private final String name;
    private final int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
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
        if (!(o instanceof CarDto)) {
            return false;
        }

        if (name.equals(((CarDto) o).name) &&
            (position == ((CarDto) o).position)) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
