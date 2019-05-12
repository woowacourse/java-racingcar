package model;

public class CarName {
    private final String name;
    private static final String regexCarName = "^([a-zA-Z]{1,5})$";

    public CarName(String name) {
        if (!name.matches(regexCarName)) {
            throw new IllegalArgumentException("자동차 이름은 영어로 구성되고 길이는 1~5입니다.");
        }
        this.name = name;
    }

    String getName() {
        return name;
    }
}
