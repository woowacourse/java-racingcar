package model;

import java.util.List;

public enum MoveStatus {
    FORWARD("-"),
    STOP("");

    private final String output;

    MoveStatus(String output) {
        this.output = output;
    }

    public static String join(String delimiter, List<MoveStatus> moveStatuses) {
        return String.join(delimiter, moveStatuses.stream().map(MoveStatus::getOutput).toList());
    }

    public String getOutput() {
        return output;
    }
}
