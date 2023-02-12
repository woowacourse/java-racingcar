package model;

public class Location {
    private static final int CAR_MOVE_LENGTH = 1;

    private int location;

    public Location(int location) {
        this.location = location;
    }

    public void moveCarLocation() {
        location += CAR_MOVE_LENGTH;
    }

    public boolean checkEqual(Location comparator) {
        return this.location == comparator.location;
    }

    public int getLocation() {
        return this.location;
    }
}
