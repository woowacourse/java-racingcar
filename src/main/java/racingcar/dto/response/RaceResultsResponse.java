package racingcar.dto.response;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.Car;

public record RaceResultsResponse(List<Map<String, Integer>> raceResults) {
    public static RaceResultsResponse from(final List<Map<Car, Integer>> raceResults) {
        final List<Map<String, Integer>> raceResultsResponse = new ArrayList<>();

        for (final Map<Car, Integer> raceResult : raceResults) {
            final Map<String, Integer> raceResultResponse = createRaceResultResponse(raceResult);
            raceResultsResponse.add(raceResultResponse);
        }

        return new RaceResultsResponse(raceResultsResponse);
    }

    private static Map<String, Integer> createRaceResultResponse(final Map<Car, Integer> raceResult) {
        final Map<String, Integer> raceResultMap = new LinkedHashMap<>();
        for (final Map.Entry<Car, Integer> entry : raceResult.entrySet()) {
            raceResultMap.put(entry.getKey().getName(), entry.getValue());
        }
        return raceResultMap;
    }
}
