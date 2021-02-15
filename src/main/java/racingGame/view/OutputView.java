package racingGame.view;

import racingGame.domain.racingCar.Name;
import racingGame.domain.racingCar.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String WINNER_NAME_SEPARATOR = ",";

    private OutputView() {
    }

    public static void println(final String msg) {
        System.out.println(msg);
    }

    public static void printResults(final List<CarDto> raceResults) {
        raceResults.stream()
                .map(OutputView::makeResultLine)
                .forEach(OutputView::println);
        printLineBreak();
    }

    private static String makeResultLine(CarDto result) {
        return result.getName() + " : " + makePositionBar(result.getPosition());
    }

    private static String makePositionBar(int position) {
        StringBuilder sb = new StringBuilder();
        while (position-- > 0) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printWinners(final List<Name> winnerNames) {
        String names = winnerNames.stream()
                .map(Name::toString)
                .collect(Collectors.joining(WINNER_NAME_SEPARATOR));

        String winningMsg = names + "가 최종 우승했습니다.";
        println(winningMsg);
    }

    private static void printLineBreak() {
        System.out.println();
    }
}
