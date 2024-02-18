package model;

public enum MoveStatus {
    FORWARD("-"),
    STOP("");

    private final String output;

    MoveStatus(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
