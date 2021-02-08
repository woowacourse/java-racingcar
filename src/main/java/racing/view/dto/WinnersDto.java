package racing.view.dto;

import java.util.List;

public class WinnersDto {
    private final List<String> winnersName;

    public WinnersDto(final List<String> winnersName) {
        this.winnersName = winnersName;
    }

    public List<String> getWinnersName() {
        return winnersName;
    }
}
