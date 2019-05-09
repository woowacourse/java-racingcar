package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(printHyphen(car));
        }
        System.out.println();
    }

    private String printHyphen(Car car){
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(" : ");

        for (int k = 0; k < car.getPosition(); k++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public void printWinner(List<String> winner) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", winner));
        sb.append("가 최종 우승 했습니다.");
        System.out.println(sb.toString());
    }

}
