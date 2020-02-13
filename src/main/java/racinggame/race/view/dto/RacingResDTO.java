package racinggame.race.view.dto;

import racinggame.race.car.Car;

import java.util.Arrays;

public class RacingResDTO {
    private static final char BAR = '-';

    private final String name;
    private final String distance;

    private RacingResDTO(String name, int distance) {
        this.name = name;
        this.distance = makeDistanceBar(distance);
    }

    public static RacingResDTO from(Car car) {
        return new RacingResDTO(car.getName(), car.getDistance());
    }

    private String makeDistanceBar(int distance) {
        char[] bars = new char[distance];
        Arrays.fill(bars, BAR);
        return String.valueOf(bars);
    }

    public String getName() {
        return this.name;
    }

    public String getDistance() {
        return distance;
    }
}
