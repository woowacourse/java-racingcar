package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public void printResult(List<Car> carList) {

        for (int j = 0; j < carList.size(); j++) {
            StringBuilder sb = new StringBuilder();
            sb.append(carList.get(j).getName());
            sb.append(" : ");
            for (int k = 0; k < carList.get(j).getPosition(); k++) {
                sb.append("-");
            }
            System.out.println(sb.toString());
        }
        System.out.println();

    }

    public void printWinner(List<String> winner) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", winner));
        sb.append("가 최종 우승 했습니다.");
        System.out.println(sb.toString());
    }

}
