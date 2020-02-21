package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

import racingcargame.domain.car.CarDto;

public class EachRaceResult {
    List<CarDto> carDtos = new ArrayList<>();

    public List<CarDto> getCar() {
        return carDtos;
    }

    void addCarDto(CarDto carDto) {
        carDtos.add(carDto);
    }
}
