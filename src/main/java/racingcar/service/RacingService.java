package racingcar.service;

import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.GameStatusChecker;
import racingcar.domain.RandomValueGenerator;
import racingcar.domain.ValueGenerator;
import racingcar.dto.CarNamesRequestDTO;
import racingcar.dto.NumberOfRoundsRequestDTO;
import racingcar.dto.RoundResultResponseDTO;
import racingcar.dto.WinnersResponseDTO;

public class RacingService {

    private final Cars cars;
    private final ValueGenerator valueGenerator;
    private GameStatusChecker gameStatusChecker;

    public RacingService() {
        this.cars = new Cars();
        this.valueGenerator = new RandomValueGenerator();
    }

    public void makeCars(CarNamesRequestDTO carNamesRequestDTO) {
        cars.setUpCars(new CarNames(carNamesRequestDTO).getNames());
    }

    public void setNumberOfRounds(NumberOfRoundsRequestDTO numberOfRoundsRequestDTO) {
        gameStatusChecker = new GameStatusChecker(numberOfRoundsRequestDTO);
    }

    public boolean isOngoing() {
        return gameStatusChecker.isOngoing(cars.getTurnCount());
    }

    public void playRound() {
        cars.playRound(valueGenerator);
    }

    public RoundResultResponseDTO getCurrentRoundResult() {
        return cars.getRoundResult();
    }

    public WinnersResponseDTO getWinners() {
        return cars.getWinners();
    }
}

