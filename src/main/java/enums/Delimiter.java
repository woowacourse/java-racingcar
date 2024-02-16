package enums;

public enum Delimiter {
    COMMA(",", "^[a-zA-Z가-힣\\d]+(,[a-zA-Z가-힣\\d]+)*$", "쉼표");

    private final String value;
    private final String regex;
    private final String korName;
    private final String errorMessage;

    Delimiter(String value, String regex, String korName) {
        this.value = value;
        this.regex = regex;
        this.korName = korName;
        this.errorMessage = String.format("%s(%s)를 기준으로 구분해야 합니다.", this.korName, this.value);
    }

    public String getValue() {
        return this.value;
    }

    public String getRegex() {
        return this.regex;
    }

    public String getKorName() {
        return this.korName;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
