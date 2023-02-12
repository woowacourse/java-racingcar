package controller;

public enum RaceState {

    INPUT_CARS_NAME,
    INPUT_RACE_ROUND,
    RACE,
    CALCULATE_WINNERS,
    APPLICATION_EXIT;

    public boolean isRacing() {
        return this != APPLICATION_EXIT;
    }
}
