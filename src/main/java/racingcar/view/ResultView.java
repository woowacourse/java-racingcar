package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printHyphen(car));
        }

        System.out.println();
    }

    public String printWinner(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.join(",", winners));
        stringBuilder.append("가 최종 우승 했습니다.");

        return stringBuilder.toString();
    }

    private String printHyphen(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName());
        stringBuilder.append(" : ");

        for (int k = 0; k < car.getPosition(); k++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }

}
