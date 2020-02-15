package racingcar.domain;

public class Car {
    private final Name name;
    private int distance;

    public Car(CarData cardata) {
        this.name = cardata.getName();
        this.distance = cardata.getDistance();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.distance++;
        }
    }

    public boolean isWinner(int maxDistance) {
        return maxDistance == this.distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name.getValue();
    }

    public CarData getCarData() {
        return new CarData(this.name, this.distance);
    }
}
