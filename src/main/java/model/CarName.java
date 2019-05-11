package model;

public class CarName {
    private static final String regexCarName = "^([a-zA-Z]{1,5})$";
    private final String name;

    public CarName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름이 null 입니다.");
        }

        if (!name.matches(regexCarName)) {
            throw new IllegalArgumentException("자동차 이름은 영어로 구성되고 길이는 1~5입니다.");
        }

        this.name = name;
    }

    String getName() {
        return name;
    }
}
