package racing.view.dto;

import java.util.List;

public class WinnersStatusDto {
    private final List<String> winnersName;

    public WinnersStatusDto(final List<String> winnersName) {
        this.winnersName = winnersName;
    }

    public List<String> getWinnersName() {
        return winnersName;
    }
}
