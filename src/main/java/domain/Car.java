package domain;

public class Car implements Comparable<Car> {
    private final static String ONE_TO_FIVE = "이름은 1이상 5이하입니다.";
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
            throw new IllegalArgumentException(ONE_TO_FIVE);
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

    @Override
    public int compareTo(Car car) {
        return (this.distance > car.distance) ? 1 : -1;
    }

    @Override
    public boolean equals(Object ob){
        String carName = (String) ob;
        return this.carName.equals(carName);
    }

}
