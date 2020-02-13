package racingGame.utils;

import racingGame.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    private static final String DELIMITER = ",";
    private static final String POSITION_CHARACTER = "-";

    public static String[] splitCarName(final String inputCarName) {
        return inputCarName.split(DELIMITER);
    }

    public static String convertPositionToString(final int position) {
        StringBuilder convertedPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            convertedPosition.append(POSITION_CHARACTER);
        }
        return convertedPosition.toString();
    }

    public static List<String> extractWinnersName(final List<Car> winners) {
        List<String> names = new ArrayList<>();

        winners.forEach(winner -> names.add(winner.toStringOnlyName()));
        return names;
    }
}
