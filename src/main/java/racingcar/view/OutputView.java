package racingcar.view;

import racingcar.domain.GameResult;
import racingcar.domain.GameWinner;

public class OutputView {
    public static void printRequestCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printRequestTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printGameResult(GameResult result, GameWinner winner) {
        System.out.println("\n실행 결과");
        result.getGameResult();
        System.out.println("%s가 최종 우승했습니다.".formatted(winner.showWinner()));
    }
}
