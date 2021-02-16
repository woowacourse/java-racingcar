package racingCar;

public class Distance {
    int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public void move(int number) {
        if (number >= 4) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public boolean isMaxDistance(int max) {
        return distance == max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distance)) return false;

        Distance distance1 = (Distance) o;

        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return distance;
    }
}
