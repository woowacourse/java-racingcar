package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.vo.Name;

public class RacingResult {
    private List<String> winners;

    public RacingResult(List<Name> winners) {
        this.winners = convertNames(winners);
    }

    private List<String> convertNames(List<Name> winners) {
        return winners.stream()
            .map(Name::value)
            .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        return winners;
    }
}
