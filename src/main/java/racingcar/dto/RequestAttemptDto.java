package racingcar.dto;

import racingcar.domain.vo.Attempt;

public class RequestAttemptDto {

    private Attempt attempt;

    public RequestAttemptDto(Attempt attempt) {
        this.attempt = attempt;
    }

    public Attempt getAttempt() {
        return attempt;
    }
}
