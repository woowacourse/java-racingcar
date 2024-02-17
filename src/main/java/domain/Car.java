package domain;

import java.util.Set;

public class Car {
    public final int MAX_BOUND = 5;
    public String name;
    public int location;

    public Car(String name) {
        validator(name);
        this.name = removeBlank(name);
        location = 0;
    }

    private void validator(String name) {
        if (!validateSize(name)) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하여야 합니다");
        }
    }

    private boolean validateSize(String name) {
        return name.length() <= MAX_BOUND;
    }

    private String removeBlank(String name) {
        return name.replaceAll(" ", "");
    }

    public void incLocation() {
        location += 1;
    }

    public String getCarName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public boolean isBlank() {
        return name.isBlank();
    }

    public boolean isMaxPosition(int maxPosition) {
        return location == maxPosition;
    }
}
