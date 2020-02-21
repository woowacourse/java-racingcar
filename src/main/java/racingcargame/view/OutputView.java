package racingcargame.view;

import java.util.ArrayList;
import java.util.List;

import racingcargame.domain.EachRaceResult;
import racingcargame.domain.GameLog;
import racingcargame.domain.car.Car;
import racingcargame.domain.car.CarDto;

public class OutputView {
    private static final String MARK = "-";
    public static final String DELIMITER = ", ";
    public static final String COLON = " : ";

    public static void nameInputInstruction() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void repeatInputInstruction() {
        System.out.println("시도할 수는 몇회인가요?");
    }

    public static void printPlayResult() {
        System.out.println("실행 결과");
    }

    public static void printWinnerResult(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println(String.join(DELIMITER, winnerNames) + "가 최종 우승했습니다.");
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    private static void printEachRaceResultDto(EachRaceResult eachRaceResult) {
        for (CarDto carDto : eachRaceResult.getCar()) {
            OutputView.printCarNameAndPosition(carDto);
        }
        System.out.println();
    }

    public static void printGameLog(GameLog gameLog) {
        for (EachRaceResult eachRaceResult : gameLog.getGameLog()) {
            OutputView.printEachRaceResultDto(eachRaceResult);
        }

    }

    private static void printCarNameAndPosition(CarDto car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(COLON);
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(MARK);
        }
        System.out.println(sb);
    }
}
