package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printAskCarNameInputMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }
    public void printAskRoundNumberMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public void showGameResult(List<Car> winners) {
        // car -> "이름, "
        String winnerNames = winners.stream().map(car -> car.getName()).collect(Collectors.joining(","));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void showCurrentStatus(List<Car> cars) {
        cars.stream().forEach(car -> car.printPosition());
        System.out.println();
    }
}
