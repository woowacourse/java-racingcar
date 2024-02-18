package domain;

public class Car {
    public final int MAX_BOUND = 5;
    public String name;
    public int location;

    public Car(String name) {
        validateCarName(name);
        this.name = removeBlank(name);
        location = 0;
    }

    private void validateCarName(String name) {
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

    public boolean isSamePosition(int maxPosition) {
        return location == maxPosition;
    }
}
