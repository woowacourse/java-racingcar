package model;

public enum CarStatus {
    FORWARD("-"),
    STOP("");

    private final String output;

    CarStatus(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public static CarStatus decide(int num){
        if(num >= 4){
            return FORWARD;
        }
        return STOP;
    }
}
