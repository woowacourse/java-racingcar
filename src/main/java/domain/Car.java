package domain;

import java.util.regex.Pattern;

public class Car {
    private final String name;
    private int distance = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public Car(final String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 자동차 이름입니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 잘못된 자동차 이름입니다.");
        }
        Pattern pattern = Pattern.compile("[ !@#$%^&*().?\":{}|<>]");
        if (pattern.matcher(name).find()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 자동차 이름입니다.");
        }
    }

    public void moveForward() {
        distance++;
    }

    public String getCarName() {
        return this.name;
    }

    public Integer getDistance() {
        return this.distance;
    }
}
