package dto;

import java.util.List;

public class GameResultDto {

    private final List<RoundResultDto> roundResults;
    private final List<CarDto> winners;

    public GameResultDto(List<RoundResultDto> roundResults, List<CarDto> winners) {
        this.roundResults = roundResults;
        this.winners = winners;
    }

    public List<RoundResultDto> getRoundResults() {
        return roundResults;
    }

    public List<CarDto> getWinners() {
        return winners;
    }
}
