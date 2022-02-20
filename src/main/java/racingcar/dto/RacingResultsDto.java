package racingcar.dto;

import java.util.Map;

public class RacingResultsDto {
    private Map<String, Integer> result;

    public RacingResultsDto(Map<String, Integer> result) {
        this.result = result;
    }

    public Map<String, Integer> getResults() {
        return result;
    }
}
