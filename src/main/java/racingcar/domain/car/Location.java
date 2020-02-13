package racingcar.domain.car;

public class Location {
    private static final String MARK = "-";

    private int location;

    Location() {
        this.location = 0;
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
}
