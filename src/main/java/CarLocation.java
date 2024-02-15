public class CarLocation {
    private int location;

    public CarLocation(int location) {
        validate(location);
        this.location = location;
    }

    private void validate(int location) {
        if (location < 0) {
            throw new IllegalArgumentException("[ERROR] 음수 위치");
        }
    }

    public CarLocation() {
        this(0);
    }

    public void increaseLocation() {
        location++;
    }

    public int getLocation() {
        return location;
    }
}
