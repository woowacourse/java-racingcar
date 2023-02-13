package racingcar.dto;

import java.util.List;
import java.util.Map;

public class RoundResultResponseDTO {
    private final List<Map.Entry<String, Integer>> roundResult;

    public RoundResultResponseDTO(List<Map.Entry<String, Integer>> roundResult) {
        this.roundResult = roundResult;
    }

    public List<Map.Entry<String, Integer>> getRoundResult() {
        return roundResult;
    }
}
