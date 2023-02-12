package domain;

public class Distance {

    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public void addDistance() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }
}
