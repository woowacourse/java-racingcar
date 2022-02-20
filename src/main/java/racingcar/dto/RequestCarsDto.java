package racingcar.dto;

import racingcar.domain.fcc.Cars;

public class RequestCarsDto {
    private Cars cars;

    public RequestCarsDto(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return cars;
    }
}
