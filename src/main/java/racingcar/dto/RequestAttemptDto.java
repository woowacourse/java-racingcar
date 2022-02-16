package racingcar.dto;

import racingcar.vo.Attempt;

public class RequestAttemptDto {

    private Attempt attempt;

    public RequestAttemptDto(Attempt attempt) {
        this.attempt = attempt;
    }

    public Attempt getAttempt() {
        return attempt;
    }
}
