package type;

public enum CarInformation {
    NAME_MIN(1),
    NAME_MAX(5);
    private final int value;

    CarInformation(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
