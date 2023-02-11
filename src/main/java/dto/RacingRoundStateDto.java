package dto;

import java.util.List;

public class RacingRoundStateDto {

    private final List<RacingCarStateDto> racingCarStateDtos;

    public RacingRoundStateDto(List<RacingCarStateDto> racingCarStateDtos) {
        this.racingCarStateDtos = racingCarStateDtos;
    }

    public List<RacingCarStateDto> getRacingCarStateDtos() {
        return racingCarStateDtos;
    }
}
