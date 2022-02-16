package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.vo.RoundResult;

public class ResponseRoundResultDto {

    private List<RoundResult> results = new ArrayList<>();

    public ResponseRoundResultDto(List<RoundResult> results) {
        this.results = results;
    }

    public List<RoundResult> getResults() {
        return results;
    }
}
