package racingcar.dto;

import java.util.List;

public class WinnersDto {
    private List<String> names;
    private int position;

    public WinnersDto(List<String> names, int position) {
        this.names = names;
        this.position = position;
    }

    public List<String> getNames() {
        return names;
    }

    public int getPosition() {
        return position;
    }
}
