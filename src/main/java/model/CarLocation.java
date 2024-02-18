package model;

public class CarLocation {
    private int location;

    public CarLocation(int location) {
        validate(location);
        this.location = location;
    }

    private void validate(int location) {
        if (location < 0) {
            throw new IllegalArgumentException("[ERROR] 위치에는 음수가 입력될 수 없습니다.");
        }
    }

    public void increaseLocation() {
        location++;
    }

    public int getLocation() {
        return location;
    }
}
