package racingcar.domain;

public class RaceResultDTO {
    final Name name;
    final int position;

    public RaceResultDTO(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }
}
