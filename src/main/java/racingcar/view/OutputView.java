package racingcar.view;

public class OutputView {
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public void printCarsResult(String carsPositionFormat) {
        System.out.println(carsPositionFormat + "\n");
    }

    public void printWinnerCars(String winnerCarsFormat) {
        System.out.println(String.format(WINNER_MESSAGE, winnerCarsFormat));
    }
}
