package racingcar.domain;

import racingcar.dto.RacingCarDto;

public class RacingCar implements Comparable<RacingCar> {
    private static final Integer DEFAULT_POINT = 0;
    private final String name;
    private Integer position;

    public RacingCar(String name) {
        this.name = name;
        this.position = DEFAULT_POINT;
    }

    private void plusPoint() {
        position++;
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
                "-".repeat(position);
        return description;
    }

    @Override
    public int compareTo(RacingCar o) {
        return o.position - this.position;
    }

    public RacingCarDto toDto() {
        return new RacingCarDto(name, position);
    }
}
