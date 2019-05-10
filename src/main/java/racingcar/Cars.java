package racingcar;

import java.util.*;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    Cars(List<String> carNames){
        Car.instantiateCar(carNames, cars);
    }

    Cars(List<String> carNames, List<Integer> positions) {
        Car.instantiateCar(carNames, cars, positions);
    }

    public void printTheProcess(int totalTurns) {
        System.out.println("실행 결과");
        for (int currentTurn = 0; currentTurn<totalTurns; currentTurn++) {
            printMovement();
            System.out.println();
        }
    }

    public void printMovement() {
        for (int i=0, n=cars.size(); i<n; i++) {
            cars.get(i).moveCar();
            cars.get(i).printPosition();
        }
    }

    public int decideMaxPosition() {
        int max = 0;
        for (int i=0, n=this.cars.size(); i<n; i++) {
            max = cars.get(i).findMax(max);
        }
        return max;
    }

    public List<String> decideWinners(int maxPosition) {
        List<String> winnersName = new ArrayList<>();
        for(int i=0; i<cars.size(); i++){
            cars.get(i).findScoreSameAsMax(maxPosition, winnersName);
        }
        return winnersName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
