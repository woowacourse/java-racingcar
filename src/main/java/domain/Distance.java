package domain;

public class Distance {

    private int distance;

    public Distance(final int distance) {
        this.distance = distance;
    }

    public void increase() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }
}
