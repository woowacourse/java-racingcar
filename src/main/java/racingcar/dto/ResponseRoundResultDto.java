package racingcar.dto;

import java.util.List;
import racingcar.domain.vo.RoundResult;

public class ResponseRoundResultDto {

    private List<RoundResult> results;

    public ResponseRoundResultDto(List<RoundResult> results) {
        this.results = results;
    }

    public List<RoundResult> getResults() {
        return results;
    }
}
