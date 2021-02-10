package racingcar.domain;

public class Name {
    final private String value;

    public Name(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public int length() {
        return this.value.length();
    }
}
