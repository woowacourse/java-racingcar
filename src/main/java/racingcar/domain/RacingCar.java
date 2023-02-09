package racingcar.domain;

import racingcar.dto.RacingCarDto;

public class RacingCar implements Comparable<RacingCar> {
    private static final Integer DEFAULT_POINT = 1;
    private final String name;
    private Integer point;

    public RacingCar(String name) {
        this.name = name;
        this.point = DEFAULT_POINT;
    }

    private void plusPoint() {
        point++;
    }

    public void advance(Boolean judgementResult) {
        if (judgementResult) {
            plusPoint();
        }
    }

    public String getDesc() {
        String delimiter = " : ";
        String description = name +
                delimiter +
                "-".repeat(point);
        return description;
    }

    @Override
    public int compareTo(RacingCar o) {
        return o.point - this.point;
    }

    public RacingCarDto toDto() {
        return new RacingCarDto(name, point);
    }
}
