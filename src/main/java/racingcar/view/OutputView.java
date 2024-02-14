package racingcar.view;

import java.util.List;
import racingcar.domain.CarStatus;

public class OutputView {


    public void printResultMessage() {
        System.out.println("실행 결과");
    }


    public void printResults(List<CarStatus> raceResults) {
        for (CarStatus carStatus : raceResults) {
            System.out.println(carStatus.name() + " : " + "-".repeat(carStatus.position()));
        }
        System.out.println();
    }


    public void printWinners(List<CarStatus> winners) {
        String joinedWinnerNames = String.join(", ", winners.stream()
                .map(CarStatus::name)
                .toList());
        System.out.println(joinedWinnerNames + "가 최종 우승했습니다.");
    }
}
