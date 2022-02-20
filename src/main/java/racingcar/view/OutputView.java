package racingcar.view;

import racingcar.dto.CarsDto;
import racingcar.dto.WinnerCarsDto;

import java.util.List;

public class OutputView {
    private static final String GAME_RESULT_TITLE = "\n실행 결과";
    private static final String RESULT_FORMAT = "%s : %s\n";
    private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
    private static final String POSITION_CHARACTER = "-";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public static void printGameResultTitle() {
        System.out.println(GAME_RESULT_TITLE);
    }

    public static void printCarStatus(CarsDto carsDto) {
        List<String> carNames = carsDto.getCarNames();
        List<Integer> carPositions = carsDto.getCarPositions();

        for (int i = 0; i < carNames.size(); i++) {
            System.out.printf(RESULT_FORMAT, carNames.get(i),buildStringPosition(carPositions.get(i)));
        }
    }

    private static String buildStringPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_CHARACTER);
        }
        return stringBuilder.toString();
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printWinner(WinnerCarsDto winnerCarDto) {
        List<String> winnerCarNames = winnerCarDto.getWinnerCarNames();
        String winnerNames = String.join(WINNER_NAME_DELIMITER, winnerCarNames);
        System.out.printf(WINNER_FORMAT, winnerNames);
    }
}
