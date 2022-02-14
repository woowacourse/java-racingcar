package racingcar.controller;

import racingcar.domain.RacingCar;

public class RacingCarDto {

    private final String name;
    private final int position;

    private RacingCarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static RacingCarDto from(RacingCar racingCar) {
        return new RacingCarDto(racingCar.getName(), racingCar.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
