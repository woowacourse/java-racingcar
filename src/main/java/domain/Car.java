package domain;

public class Car {
    public final int MAX_BOUND = 5;
    public final String name;
    public int location;
    public boolean isWinner = false;

    public Car(String name) {
        validateCarName(name);
        this.name = removeSpace(name);
        location = 0;
    }

    private void validateCarName(String name) {
        validateSize(name);
        validateBlankName(name);
    }

    private void validateSize(String name) {
        if (name.length() > MAX_BOUND) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하여야 합니다");
        }
    }

    private void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름은 공백일 수 없습니다");
        }
    }

    private String removeSpace(String name) {
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

    public boolean isSamePosition(int maxPosition) {
        return location == maxPosition;
    }

    public void setWinner() {
        isWinner = true;
    }

    public boolean getResult() {
        return isWinner;
    }
}
