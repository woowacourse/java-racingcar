package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;

public class RacingCarDto {

    private final String name;
    private final int position;

    private RacingCarDto(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static List<RacingCarDto> from(final List<RacingCar> racingCars) {
        return racingCars.stream()
            .map(RacingCarDto::from)
            .collect(Collectors.toList());
    }

    public static RacingCarDto from(final RacingCar racingCar) {
        return new RacingCarDto(racingCar.getName(), racingCar.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
