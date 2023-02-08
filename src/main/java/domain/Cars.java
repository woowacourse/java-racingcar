package domain;

import util.RandomNumberMaker;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(String userInput) {
        validateNotNull(userInput);
        validateHasComma(userInput);
        addCar(userInput);
    }


    private void validateNotNull(String userInput) {
        if (userInput == null || "".equals(userInput)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    private void validateHasComma(String userInput) {
        if (userInput.indexOf(',') == -1) {
            throw new IllegalArgumentException("두 대 이상 입력해주세요");
        }
    }

    private void addCar(String userInput) {
        String[] userInputSplit = userInput.split(",");

        for(String inputSplit :userInputSplit){
            cars.add(new Car(inputSplit));
        }
    }

    public int getCarsSize() {
        return cars.size();
    }

    public void addDistance() {
        for (Car car : cars){
            car.addDistance(new RandomNumberMaker().makeNumber());
        }
    }

    public Car getCar (int i){
        return this.cars.get(i);
    }
}
