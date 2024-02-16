package ui;

import static enums.Delimiter.COMMA;

import java.util.List;
import model.RacingGame;

public class OutputView {
    public void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCarNameAndPosition(RacingGame racingGame) {
        racingGame.getCars()
                .forEach(car -> System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition())));
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(COMMA.getValue() + " ", winners) + "가 최종 우승했습니다.");
    }
}
