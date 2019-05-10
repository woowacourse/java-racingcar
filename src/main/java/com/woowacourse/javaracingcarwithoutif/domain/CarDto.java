package com.woowacourse.javaracingcarwithoutif.domain;

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
        return (o instanceof CarDto) && // Car 타입이면서
            name.equals(((CarDto) o).name) && // 이름이 같고
            position == ((CarDto) o).position; // 위치가 같아야 함
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
