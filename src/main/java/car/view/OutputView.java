package car.view;

import java.util.ArrayList;
import java.util.List;

import car.domain.Car;

public class OutputView {

    public void noticeResult() {
        System.out.println("실행 결과");
    }

    public void printCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void changeLine() {
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        String joinedNames = String.join(", ", winnerNames);
        System.out.println(joinedNames + "가 최종 우승했습니다.");
    }

}
