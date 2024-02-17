package domain;

public class Car {
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
        return name.length() <= 5;
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
}
