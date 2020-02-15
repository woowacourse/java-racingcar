package racingcar.domain;

public class CarData {
    private Name name;
    private int distance;

    public CarData (Name name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public Name getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
