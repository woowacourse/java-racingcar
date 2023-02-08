package racingcar.domain;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RacingCar {
    private static final Integer defaultPoint = 0;
    private String name;
    private Integer point;

    public RacingCar(String name) {
        this.name = name;
        this.point = defaultPoint;
    }

    private void plusPoint() {
        point++;
    }

    public void advance(Boolean judgementResult) {
        if (judgementResult) {
            plusPoint();
        }
    }
}
