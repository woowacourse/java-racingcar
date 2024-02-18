package domain;

public class Distance implements Comparable<Distance> {
    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public int getValue() {
        return distance;
    }

    public static Distance from(int distance) {
        return new Distance(distance);
    }

    public boolean isSameDistance(Distance maxDistance) {
        return this.distance == maxDistance.distance;
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
