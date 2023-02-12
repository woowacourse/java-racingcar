package racingcar.dto;

import java.util.List;

public class WinnersResponseDTO {
    private final List<String> winners;

    public WinnersResponseDTO(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
