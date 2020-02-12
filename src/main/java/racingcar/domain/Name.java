package racingcar.domain;

public class Name {
    private String name;

    Name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
