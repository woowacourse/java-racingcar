package domain;

import constants.ErrorMessages;

public class CarLocation {
    private static final int MINIMUM_LOCATION_VALUE = 0;

    private int location;

    public CarLocation(int location) {
        validate(location);
        this.location = location;
    }

    private void validate(int location) {
        if (location < MINIMUM_LOCATION_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_LOCATION.getMessage());
        }
    }

    public void increase() {
        location++;
    }

    public int getLocation() {
        return location;
    }
}
