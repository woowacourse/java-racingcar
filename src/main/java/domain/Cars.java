package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();
    private final static String ERROR_NAME = "두 대 이상의 자동차 이름을 입력해주세요";
    private final static String ERROR_DUPLICATION = "중복되지 않은 자동차를 입력해주세요";
    private final static String COMMA = ",";

    public Cars(String userInput) {
        validateNotNull(userInput);
        validateHasComma(userInput);
        addCar(userInput);
    }

    private void validateNotNull(String userInput) {
        if (userInput == null || "".equals(userInput)) {
            throw new IllegalArgumentException(ERROR_NAME);
        }
    }

    private void validateHasComma(String userInput) {
        if (!userInput.contains(COMMA)) {
            throw new IllegalArgumentException(ERROR_NAME);
        }
    }

    private void addCar(String userInput) {
        String[] userInputSplit = userInput.split(COMMA);
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
        /*for (Car car : cars) {
            // car.addDistance(new RandomNumberMaker().makeNumber());

        }*/
    }

    public Car getCar(int i) {
        return this.cars.get(i);
    }

    public List<Car> getCars() {
        return cars;
    }
}
