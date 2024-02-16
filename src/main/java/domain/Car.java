package domain;

public class Car implements Comparable<Car> {

    private static final int MIN_MOVE_NUMBER = 4;
    private static final String REGEX = "^[a-zA-Z가-힣]{1,5}$";

    private final String name;
    private int location;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.location = 0;
    }

    private void validateCarName(String name) {
        if (!name.matches(REGEX)) {
            throw new IllegalArgumentException("이름은 알파벳 소문자와 대문자, 한글로 1~5 글자로 가능합니다");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MIN_MOVE_NUMBER) {
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
