package racingcar.domain;

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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < location; i++) {
            stringBuilder.append(MARK);
        }
        return String.valueOf(stringBuilder);
    }
}
