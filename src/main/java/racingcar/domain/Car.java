package racingcar.domain;

public class Car {
    private final String name;
    private int count;

    public Car(final String name) {
        this.name = name;
        this.count = 0;
    }

    public void move(final int randomNumber) {
        if (randomNumber > 3 ) {
            this.count += 1;
        }
    }

    public boolean isSameCount(final Car car) {
        return this.count == car.count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
