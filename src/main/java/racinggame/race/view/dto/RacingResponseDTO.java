package racinggame.race.view.dto;

import racinggame.race.car.Car;
import racinggame.race.car.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResponseDTO {
    private static final char BAR = '-';

    private final String name;
    private final String distance;

    public RacingResponseDTO(Car car) {
        this.name = car.getName();
        this.distance = makeDistanceBar(car.getDistance());
    }

    public static List<RacingResponseDTO> listFrom(Cars cars) {
        return cars.getCars().stream()
                .map(RacingResponseDTO::new)
                .collect(Collectors.toList());
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
