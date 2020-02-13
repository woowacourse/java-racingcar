package racingcar.domain.car;

public class Location implements Comparable<Location> {
    private static final String MARK = "-";

    private int location;

    public Location() {
        this.location = 0;
    }

    public Location(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void moveForward() {
        location++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < location; i++) {
            result.append(MARK);
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Location) {
            return location == ((Location) o).location;
        }
        return false;
    }

    @Override
    public int compareTo(Location anotherLocation) {
        return Integer.compare(this.location, anotherLocation.location);
    }
}
