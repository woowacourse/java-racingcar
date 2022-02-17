package racingcar.dto;

import racingcar.domain.round.Round;

public class RoundDto {

    private final int count;

    public RoundDto(Round round) {
        this.count = round.getCount();
    }

    public int getCount() {
        return this.count;
    }

}
