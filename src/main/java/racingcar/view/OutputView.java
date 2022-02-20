package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ASK_CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_ROUND_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String DECLARE_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public void printAskCarNameInputMessage() {
        System.out.println(ASK_CAR_NAME_INPUT_MESSAGE);
    }

    public void printAskRoundNumberMessage() {
        System.out.println(ASK_ROUND_NUMBER_INPUT_MESSAGE);
    }

    public void showGameResult(List<Car> winners) {
        String winnerNames = winners.stream().map(car -> car.getName()).collect(Collectors.joining(","));
        System.out.println(winnerNames + DECLARE_WINNER_MESSAGE);
    }

    public void showCurrentStatus(List<Car> cars) {
        cars.stream().forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public void printExecutionResultMessage(){
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }
}
