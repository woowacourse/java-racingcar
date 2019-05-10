package com.woowacourse.javaracingcar.domain;

/**
 * 객체 사이에서 데이터만 실어 나르는 DTO 클래스
 */
public class CarDto {
    private final String name;
    private final int position;

    public CarDto(final String name, final int position) {
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
