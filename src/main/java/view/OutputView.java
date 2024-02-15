package view;

import model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void writeResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }
    public void writeRoundResult(Cars cars) {
        System.out.println(cars);
    }

    public void writeWinners(List<String> names) {
        String winners = names.stream().collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}