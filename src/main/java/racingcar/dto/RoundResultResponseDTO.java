package racingcar.dto;

import java.util.Map;

public class RoundResultResponseDTO {
    private final Map<String, Integer> roundResult;

    public RoundResultResponseDTO(Map<String, Integer> roundResult) {
        this.roundResult = roundResult;
    }

    public Map<String, Integer> getRoundResult() {
        return roundResult;
    }
}
