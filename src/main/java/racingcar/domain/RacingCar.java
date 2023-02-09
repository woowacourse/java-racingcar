package racingcar.domain;

import racingcar.dto.RacingCarDto;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RacingCar implements Comparable<RacingCar>{
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
        StringBuilder description = new StringBuilder();
        description.append(name);
        String delimiter = " : ";
        description.append(delimiter);
        description.append("-".repeat(point));
        return description.toString();
    }

    @Override
    public int compareTo(RacingCar o) {
        return o.point - this.point;
    }

    public RacingCarDto toDto(){
        return new RacingCarDto(name, point);
    }
}
