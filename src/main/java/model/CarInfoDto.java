package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingResultByRoundDto {

    private final List<Map<String,Integer>> resultByRound;

    private RacingResultByRoundDto(List<Map<String,Integer>> resultByRound) {
        this.resultByRound = resultByRound;
    }

    public static RacingResultByRoundDto from(final List<Car> resultByRound) {
        List<Map<String, Integer>> carsInfoByRound = new ArrayList<>();
        for (Car carInfo : resultByRound) {
            carsInfoByRound.add(new );
        }

        return new RacingResultByRoundDto();
    }



    public List<Car> getRacingResultByRound() {
        return this.resultByRound;
    }
}
