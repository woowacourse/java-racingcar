package racingcar.dto.response;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.Car;

public record RaceResultsResponse(List<Map<String, Integer>> raceResults) {
    public static RaceResultsResponse from(final List<List<Car>> raceResults) {
        final List<Map<String, Integer>> raceResultResponse = new ArrayList<>();

        for (final List<Car> cars : raceResults) {
            final Map<String, Integer> raceResult = createRaceResult(cars);
            raceResultResponse.add(raceResult);
        }

        return new RaceResultsResponse(raceResultResponse);
    }

    private static Map<String, Integer> createRaceResult(List<Car> cars) {
        final Map<String, Integer> raceResult = new LinkedHashMap<>();
        for (final Car car : cars) {
            raceResult.put(car.getName(), car.getPosition());
        }
        return raceResult;
    }
}
