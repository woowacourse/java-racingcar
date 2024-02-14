public class CarLocation {
    private int location;

    public CarLocation() {
        location = 0;
    }

    public void increaseLocation(int randomNumber) {
        if (randomNumber >= 4) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
