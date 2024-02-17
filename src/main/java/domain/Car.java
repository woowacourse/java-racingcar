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
        validateSize(name);
        validateBlankName(name);
    }

    private void validateSize(String name) {
        if (!(name.length() <= 5)) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하여야 합니다");
        }
    }

    private void validateBlankName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 이름은 사용할 수 없습니다.");
        }
    }

    private String removeBlank(String name) {
        return name.replaceAll("\\s+", "");
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
