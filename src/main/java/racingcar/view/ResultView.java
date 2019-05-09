package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public String printResult(List<Car> carList) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < carList.size(); j++) {
            sb.append(carList.get(j).getName());
            sb.append(" : ");
            for (int k = 0; k < carList.get(j).getPosition(); k++) {
                sb.append("-");
            }
//            System.out.println(sb.toString());
        }
//        System.out.println();
        return sb.toString();
    }

    public void printWinner(List<String> winner) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", winner));
        sb.append("가 최종 우승 했습니다.");
        System.out.println(sb.toString());
    }

}
