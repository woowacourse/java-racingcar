package model;

import exception.model.CarLocationException;

public class CarLocation {
    private int location;

    public CarLocation(int location) {
        validate(location);
        this.location = location;
    }

    private void validate(int location) {
        if (location < 0) {
            throw new IllegalArgumentException(CarLocationException.NOT_NEGATIVE.getExceptionMessage());
        }
    }

    public void increaseLocation() {
        location++;
    }

    public int getLocation() {
        return location;
    }
}
