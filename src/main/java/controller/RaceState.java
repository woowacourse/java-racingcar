package controller;

public enum RaceState {

    INPUT_CARS_NAME,
    INPUT_RACE_ROUND,
    RACE,
    CALCULATE_WINNERS,
    APPLICATION_EXIT,
    APPLICATION_EXCEPTION;

    public boolean canRacing() {
        return this != APPLICATION_EXIT && this != APPLICATION_EXCEPTION;
    }
}
