package racingcar.dto;

import racingcar.domain.Name;
import racingcar.domain.Position;

public class RacingCarStatusResponse {
    private final String name;
    private final int position;

    public RacingCarStatusResponse(Name name, Position position) {
        this.name = name.getName();
        this.position = position.getValue();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(position));
    }
}
