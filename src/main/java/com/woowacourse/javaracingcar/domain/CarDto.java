package com.woowacourse.javaracingcar.domain;

/**
 * 객체 사이에서 데이터만 실어 나르는 DTO 클래스
 */
public class CarDto implements Comparable<CarDto> {
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
        return String.format("CarDto { name: \"%s\", position: %d }", name, position);
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


    @Override
    public int compareTo(CarDto o) {
        return Integer.compare(position, o.position);
    }
}
