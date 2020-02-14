package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceResult {
    private static final String GAGE = "-";
    private static final String COLON = " : ";
    private static final String LINE_BREAK = "\n";
    static final String COMMA = ", ";
    static final String EMPTY = "";

    public String getEachRaceResult(List<Car> cars) {
        String eachRaceResult = EMPTY;

        for (Car car : cars) {
            eachRaceResult = String.join(EMPTY, eachRaceResult, car.toString());

            String raceResultOfCar = Stream.generate(() -> GAGE)
                    .limit(car.getPosition())
                    .collect(Collectors.joining(EMPTY));

            eachRaceResult = String.join(COLON, eachRaceResult, raceResultOfCar + LINE_BREAK);
        }

        return eachRaceResult;
    }

    public String getWinnerNames(List<String> winners) {
        return String.join(COMMA, winners);
    }
}
