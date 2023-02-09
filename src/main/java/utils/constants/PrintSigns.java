package utils.constants;

public enum PrintSigns {
    SEPARATOR(" : "),
    POSITION("-");

    private final String sign;

    PrintSigns(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
