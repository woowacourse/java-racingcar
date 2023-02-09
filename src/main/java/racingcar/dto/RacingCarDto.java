package racingcar.dto;

public class RacingCarDto {
    private final String name;
    private final Integer point;

    public RacingCarDto(String name, Integer point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPoint() {
        return point;
    }
}
