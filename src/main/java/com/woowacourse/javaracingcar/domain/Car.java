package com.woowacourse.javaracingcar.domain;

public class Car implements Comparable<Car> {
    private static final int STARTING_POSITION = 0;

    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        this.position = STARTING_POSITION;
    }

    /**
     * 인자로 명시된 position 만큼 기존의 position을 변경한다.
     * 메서드명에 대해, 음수 인자도 처리할 수 있기 때문에 moveForward 보다는 move가 적당한 것 같다.
     *
     * @param position 위치 변화량
     */
    public CarDto move(final int position) {
        this.position += position;
        return new CarDto(name, this.position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("Car { name: \"%s\", position: %d }", name, position);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Car) && // Car 타입이면서
            name.equals(((Car) o).name) && // 이름이 같고
            position == ((Car) o).position; // 위치가 같아야 함
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(position, o.position);
    }
}
