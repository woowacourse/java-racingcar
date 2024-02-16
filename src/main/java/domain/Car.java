package domain;

public class Car implements Comparable<Car> {
    private static final String NAME_CONVENTION = "^[a-zA-Z가-힣]{1,5}$";
    private static final int STANDARD = 4;
    private final String name;
    private int location = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (!name.matches(NAME_CONVENTION)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 영어, 한글만 가능합니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= STANDARD) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public int compareTo(Car car) {
        return this.location - car.getLocation();
    }
}
