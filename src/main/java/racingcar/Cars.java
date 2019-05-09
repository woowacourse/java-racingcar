package racingcar;

import java.util.*;

public class Cars {
    List<Car> carList = new ArrayList<>();

    Cars(List<String> carNames){
        isMakeCar(carNames);
    }

    public boolean isMakeCar(List<String> carNames){
        boolean result = false;
        for(int i=0; i<carNames.size(); i++){
            result = true;
            this.carList.add(new Car(carNames.get(i)));
        }
        return result;
    }

}
