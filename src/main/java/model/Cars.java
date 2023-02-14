package model;

import dto.RacingCarStateDto;
import dto.RacingRoundStateDto;
import dto.WinnerCarDto;
import exception.EmptyCarsException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.wrapper.Round;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<RacingRoundStateDto> race(Round round) {
        List<RacingRoundStateDto> racingResult = new ArrayList<>();

        while (round.isRacing()) {
            racingResult.add(race());
        }
        return racingResult;
    }

    private RacingRoundStateDto race() {
        List<RacingCarStateDto> racingCarsStateDto = cars.stream()
                .map(Car::race)
                .collect(Collectors.toUnmodifiableList());
        return new RacingRoundStateDto(racingCarsStateDto);
    }

    public List<WinnerCarDto> calculateWinners() {
        Car winner = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(EmptyCarsException::new);

        return addSamePositionCars(winner);
    }

    private List<WinnerCarDto> addSamePositionCars(Car winner) {
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::mapToWinnerCarDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
