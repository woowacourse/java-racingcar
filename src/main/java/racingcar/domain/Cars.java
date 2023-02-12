package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.dto.RoundResultResponseDTO;
import racingcar.dto.WinnersResponseDTO;

public class Cars {

    private final List<Car> cars;
    private int turnCount;

    public Cars() {
        cars = new ArrayList<>();
        turnCount = 0;
    }

    public void setUpCars(List<String> carNames) {
        for (String name : carNames) {
            add(new Car(name));
        }
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void playRound(ValueGenerator valueGenerator) {
        for (Car car : cars) {
            car.move(car.isMovable(valueGenerator.generate()));
        }
        turnCount++;
    }

    public RoundResultResponseDTO getRoundResult() {
        Map<String, Integer> currentRoundResult = new LinkedHashMap<>();
        for (Car car : cars) {
            currentRoundResult.put(car.getName(), car.getPosition());
        }
        return new RoundResultResponseDTO(currentRoundResult);
    }

    public int getTurnCount() {
        return turnCount;
    }

    public WinnersResponseDTO getWinners() {
        Car winner = Collections.max(cars, Comparator.comparingInt(Car::getPosition));

        return new WinnersResponseDTO(cars.stream()
            .filter(car -> car.getPosition() == winner.getPosition())
            .map(Car::getName)
            .collect(Collectors.toList()));
    }

}
