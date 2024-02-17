package domain;

public class Distance implements Comparable<Distance> {
    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public static Distance init() {
        return new Distance(0);
    }

    public static Distance from(int distance) {
        return new Distance(distance);
    }

    public void increase() {
        this.distance++;
    }

    public boolean isSameDistance(Distance maxDistance) {
        return this.distance == maxDistance.distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Distance other) {
        return this.distance - other.distance;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
