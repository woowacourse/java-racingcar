package domain;

public class Car implements Comparable<Car> {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_ADD_DISTANCE_POWER = 4;
    private static final String nameLengthErrorMessage = "이름은 1이상 5이하입니다.";
    private final String name;
    // TODO : 생성자에서 같이 초기화 하는거랑 무슨 차이인지 화긴
    private int distance = 0;

    public Car(String name) {
        String removedBlankName = eliminateBeforeAndAfterBlank(name);
        validateNameLength(removedBlankName);
        this.name = removedBlankName;
    }

    private String eliminateBeforeAndAfterBlank(String name) {
        return name.trim();
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(nameLengthErrorMessage);
        }
    }

    public void addDistance(int power) {
        if (power >= MINIMUM_ADD_DISTANCE_POWER) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Car car) {
        return (this.distance > car.distance) ? 1 : -1;
    }

    @Override
    public boolean equals(Object ob) {
        Car car = (Car)ob;
        return this.name.equals(car.name);
    }

}
