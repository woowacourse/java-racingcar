package racing.domain.dto;

import java.util.List;

public class WinnersDto {
    private final List<String> winnersName;

    public WinnersDto(List<String> winnersName) {
        this.winnersName = winnersName;
    }
}
