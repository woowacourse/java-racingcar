package com.woowacourse.javaracingcarwithoutif.domain;

public class Car implements Comparable<Car> {

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
