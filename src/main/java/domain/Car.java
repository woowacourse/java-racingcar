package domain;

public class Car implements Comparable<Car> {

    private static final int MIN_MOVE_NUMBER = 4;
    private static final String REGEX = "^[a-zA-Z가-힣]{1,5}$";

    private final String name;
    private int location = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (!name.matches(REGEX)) {
            throw new IllegalArgumentException("이름은 알파벳 소문자와 대문자, 한글로 1~5 글자로 가능합니다");
        }
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MIN_MOVE_NUMBER) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }

    @Override
    public int compareTo(Car car) {
        return this.location - car.getLocation();
    }
}
