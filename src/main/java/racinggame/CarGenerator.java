package racinggame;

import racinggame.view.UserInput;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    public List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        String[] carsName = createCarsName();

        for (String carName : carsName) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private String[] createCarsName() {
        String[] carsName;

        do {
            carsName = splitByComma(UserInput.inputCarsName());
        } while (!checkCarsNameLength(carsName));

        return carsName;
    }

    private String removeBlank(String carsName) {
        return carsName.replace(" ", "").replace(",,", ",");
    }

    private String[] splitByComma(String carsName) {
        String carName = removeBlank(carsName);
        return carName.split(",");
    }

    private boolean checkCarsNameLength(String[] carsName) {
        boolean allNamesAreRightLength = true;

        for (String carName : carsName) {
            allNamesAreRightLength = checkEachCarNameLength(allNamesAreRightLength, carName);
        }

        return allNamesAreRightLength;
    }

    private boolean checkEachCarNameLength(boolean allNamesAreRightLength, String carName) {
        boolean eachIsRightLength;

        eachIsRightLength = carName.length() <= MAX_NAME_LENGTH
                && carName.length() >= MIN_NAME_LENGTH
                && allNamesAreRightLength;
        return eachIsRightLength;
    }
}