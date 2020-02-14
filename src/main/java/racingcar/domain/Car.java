package racingcar.domain;

public class Car implements Comparable<Car> {
    public static final int INIT_POSITION = 0;

    private final Name name;
    private int position;

    public Car(Name name) {
        if (RaceResult.EMPTY.equals(name.toString())) {
            throw new IllegalArgumentException("입력이 없는 이름이 있습니다.");
        }

        this.name = name;
        this.position = INIT_POSITION;
    }

    Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(Car winner) {
        return winner.getPosition() == position;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.position, car.getPosition());
    }
}