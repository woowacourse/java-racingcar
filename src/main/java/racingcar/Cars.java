package racingcar;

import java.util.*;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    Cars(List<String> carNames){
        for(int i=0; i<carNames.size(); i++){
            this.carList.add(new Car(carNames.get(i)));
        }
    }

    public void printTheProcess(int totalTurns) {
        System.out.println("실행 결과");
        for (int currentTurn = 0; currentTurn<totalTurns; currentTurn++) {
            printMovement();
            System.out.println();
        }
    }

    public void printMovement() {
        for (int i=0, n=carList.size(); i<n; i++) {
            carList.get(i).moveCar();
            carList.get(i).printPosition();
        }
    }

    public int decideMaxPosition() {
        int max = 0;
        for (int i=0, n=this.carList.size(); i<n; i++) {
            max = carList.get(i).findMax(max);
        }
        return max;
    }

    public List<String> decideWinners(int maxPosition) {
        List<String> winnersName = new ArrayList<>();
        for(int i=0; i<carList.size(); i++){
            carList.get(i).findScoreSameAsMax(maxPosition, winnersName);
        }
        return winnersName;
    }

    public void setPosition(List<Integer> inputPosition){
        for(int i=0; i<carList.size(); i++){
            carList.get(i).setPosition(inputPosition.get(i));
        }
    }
}
