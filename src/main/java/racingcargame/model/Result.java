package racingcargame.model;

import racinginterface.ResultInterface;

import java.util.ArrayList;
import java.util.List;

public class Result implements ResultInterface {
    private List<Car> carList = new ArrayList<>();

    public Result(String[] names) {
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    @Override
    public List<Car> roundResult() {
        carList.forEach(Car::move);
        return carList;
    }

    @Override
    public List<String> gameResult() {
        return null;
    }
}