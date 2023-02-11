package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final static String ERROR_NAME = "두 대 이상의 자동차 이름을 입력해주세요";
    private final static String ERROR_DUPLICATION = "중복되지 않은 자동차를 입력해주세요";
    private final static String DELIMITER = ",";
    List<Car> cars = new ArrayList<>();

    public Cars(String userInput) {
        validateNotEmpty(userInput);
        validateMoreThanOneCar(userInput);
        addCar(userInput);
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NAME);
        }
    }

    private void validateMoreThanOneCar(String userInput) {
        if (!userInput.contains(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_NAME);
        }
    }

    private void addCar(String userInput) {
        String[] userInputSplit = userInput.split(DELIMITER);
        for (String inputSplit : userInputSplit) {
            validateDuplication(inputSplit);
            cars.add(new Car(inputSplit));
        }
    }

    private void validateDuplication(String inputSplit) {
        if (cars.contains(inputSplit)) {
            throw new IllegalArgumentException(ERROR_DUPLICATION);
        }
    }

    public int getCarsSize() {
        return cars.size();
    }

    public void addDistance(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).addDistance(randomNumbers.get(i));
        }
    }

    public Car getCar(int i) {
        return this.cars.get(i);
    }

    public List<Car> getCars() {
        return cars;
    }
}
