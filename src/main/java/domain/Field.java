package domain;

import utils.NumberGenerator;

import java.util.List;

public class Field {
    private final NumberGenerator numberGenerator;

    public Field(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void moveCars(CarGroup carGroup) {
        List<Car> cars = carGroup.getAllCars();
        for (Car car : cars) {
            int randomNumber = numberGenerator.getNumber();
            car.move(randomNumber);
        }
    }
}
