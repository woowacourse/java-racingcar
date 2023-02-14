package model.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRegisterer {

    private final List<String> carNames;

    public CarRegisterer() {
        this.carNames = new ArrayList<>();
    }

    public void registerCar(String carName){
        carNames.add(carName);
    }

    public Cars prepareCars(){
        return new Cars(carNames.stream().map(carName -> new Car(carName)).collect(Collectors.toUnmodifiableList()));
    }

}
