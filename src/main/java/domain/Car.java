package domain;

public class Car {
    private final String carName;
    private int distance = 0;

    public Car(String inputCar) {
        String trimInput = eliminateBlank(inputCar);
        validateNameLength(trimInput);
        this.carName = trimInput;
    }

    private String eliminateBlank(String inputCar) {
        return inputCar.trim();
    }

    private void validateNameLength(String inputCar) {
        if (inputCar.length() < 1 || inputCar.length() > 5) {
            throw new IllegalArgumentException("이름은 1이상 5이하입니다.");
        }
    }

    public void addDistance(int makeNumber) {
        if (makeNumber >= 4) distance++;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
