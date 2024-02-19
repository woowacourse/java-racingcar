package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.GameResult;

public class OutputView {
    public static void printRequestCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printRequestTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printCarStatus(Cars cars) {
        System.out.println(cars);
        System.out.println();
    }

    public static void printGameResult(GameResult result) {
        System.out.println("\n실행 결과");
        result.getGameStatus().stream().forEach(gameStatus -> System.out.println(gameStatus + "\n"));

        // TODO: 디미터의 원칙 위반! 리펙터링 필요
        System.out.println("%s가 최종 우승했습니다.".formatted(result.getWinners().showWinner()));
    }
}
