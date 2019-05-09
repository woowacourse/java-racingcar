package game;

import game.output.resultOutput;

import java.util.ArrayList;
import java.util.List;

public class Game {

    String removeBlank(String carNames) {
        return carNames.replace(" ", "");
    }

    String[] splitWithComma(String carNames) {
        String carName = removeBlank(carNames);
        return carName.split(",");
    }

    boolean checkCarNamesLength(String[] carNames) {
        boolean isRightLength = true;

        for (String carName : carNames) {
            isRightLength = checkCarNameLength(isRightLength, carName);
        }

        return isRightLength;
    }

    boolean checkCarNameLength(boolean isRightLength, String carName) {
        return carName.length() <= 5 && isRightLength;
    }


    List<Car> createCarObject(String[] carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }


    int randomValueGenerator() {
        return (int) (Math.random() * 9);
    }

    void oneGame(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomValueGenerator());
            resultOutput.result(car);
        }
        resultOutput.printNewLine();
    }
}
