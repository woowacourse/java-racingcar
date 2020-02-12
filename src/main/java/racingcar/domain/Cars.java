package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int createRandomValue(){
        return (int)(Math.random() * 10);
    }

    public void moveCars(){
        for (Car car : cars){
            car.movePosition(createRandomValue());
        }
    }

    public String getCurrentResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars){
            stringBuilder.append(car.currntPositon());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}