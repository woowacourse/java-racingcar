package service;

import domain.Cars;
import domain.MoveCount;
import dto.CarDto;
import dto.GameResultDto;
import dto.RoundResultDto;
import java.util.ArrayList;
import java.util.List;

public class RaceGameService {

    public GameResultDto runRaceGame(Cars cars, MoveCount moveCount) {
        List<RoundResultDto> roundResults = new ArrayList<>();

        while (!moveCount.isCountZero()) {
            RoundResultDto roundResultDto = executeRound(cars);
            roundResults.add(roundResultDto);
        }
        List<CarDto> winners = selectWinner(cars);

        return new GameResultDto(roundResults, winners);
    }

    public RoundResultDto executeRound(Cars cars) {
        cars.tryMoveAll();
        return RoundResultDto.from(cars);
    }

    private List<CarDto> selectWinner(Cars cars) {
        return cars.chooseWinners().stream()
                .map(CarDto::from)
                .toList();
    }
}
