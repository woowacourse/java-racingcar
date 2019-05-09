package racingcar;

import java.util.*;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    Cars(List<String> carNames){
        for(int i=0; i<carNames.size(); i++){
            this.carList.add(new Car(carNames.get(i)));
        }
    }

    public void printPosition(int totalTurns) {
        for (int currentTurn = 0; currentTurn<totalTurns; currentTurn++) {
            resultPrintCar();
        }
    }

    public void resultPrintCar() {
        for (int i=0, n=carList.size(); i<n; i++) {
            carList.get(i).moveCar();
            carList.get(i).printPosition();
        }
    }



}
