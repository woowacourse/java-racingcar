package racingcar.io;

import java.util.List;
import racingcar.dto.RacingResult;
import racingcar.dto.RacingStatus;

public class Output {
    private static final String NAME_DELIMITER = ", ";
    private static final String CAR_ADVANCE_EXPRESSION = "-";

    public void printCurrentPosition(List<RacingStatus> cars) {
        cars.forEach(this::printRacingProgress);
        System.out.println();
    }

    public void printWinner(RacingResult racingResult) {
        List<String> winners = racingResult.getWinners();
        System.out.printf("%s가 최종 우승했습니다.", String.join(NAME_DELIMITER, winners));
    }

    private void printRacingProgress(RacingStatus car) {
        System.out.printf("%s : %s%n", car.getName(), getPositionString(car.getPosition()));
    }

    private String getPositionString(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(CAR_ADVANCE_EXPRESSION);
        }
        return builder.toString();
    }
}
