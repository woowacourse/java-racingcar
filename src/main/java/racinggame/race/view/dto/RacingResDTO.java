package racinggame.race.view.dto;

import racinggame.race.car.Car;

public class RacingResDTO {
    private static final String BAR = "-";

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
        StringBuilder bars = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            bars.append(BAR);
        }
        return bars.toString();
    }

    public String getName() {
        return this.name;
    }

    public String getDistance() {
        return distance;
    }
}
