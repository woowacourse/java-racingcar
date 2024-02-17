package racingcar.view;

import java.util.List;
import racingcar.domain.result.CarResult;
import racingcar.domain.result.RoundResult;

public class OutputView {

    public void printRoundResults(final List<RoundResult> roundResults) {
        roundResults.forEach(this::printRoundResult);
    }

    private void printRoundResult(final RoundResult roundResult) {
        final List<CarResult> carResults = roundResult.getCarResult();
        carResults.forEach(this::printCarResult);
        System.out.println();
    }

    private void printCarResult(final CarResult carResult) {
        System.out.printf("%s : %s%n", carResult.getCarName(), "-".repeat(carResult.getPosition()));
    }

    public void printWinners(final List<String> winners) {
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", winners));
    }

    public void printError(final String message) {
        System.out.println(message);
    }
}
