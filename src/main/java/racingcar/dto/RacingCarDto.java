package racingcar.dto;

public class RacingCarDto {
    private final String name;
    private final Integer position;

    public RacingCarDto(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return position;
    }
}
