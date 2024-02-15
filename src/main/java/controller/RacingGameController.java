package controller;

import domain.Car;
import domain.Cars;
import domain.MoveCount;
import util.StringParser;
import view.InputView;

import java.util.List;

public class RacingGameController {
    private InputView inputView;

    public void run() {

        Cars cars = prepareCars();

        MoveCount moveCount = prepareMoveCount();

        executeRace(cars, moveCount);

    }

    private void executeRace(Cars cars, MoveCount moveCount) {
        while (!moveCount.isCountZero()) {
            cars.tryMoveAll();
            moveCount.consume();
            //TODO: 자동차들의 위치를 출력
        }
    }

    private Cars prepareCars() {
        try {
            String name = inputView.requestCarName();
            List<String> carNames = StringParser.split(name, ",");
            return Cars.from(carNames.stream()
                    .map(carName -> Car.of(carName, 0))
                    .toList());
        } catch (IllegalArgumentException e) {
            prepareCars();
        }
        throw new RuntimeException();
    }

    private MoveCount prepareMoveCount() {
        try {
            Integer count = StringParser.parseToInt(inputView.requestMoveCount());
            return MoveCount.from(count);
        } catch (IllegalArgumentException e){
            prepareMoveCount();
        }
        throw new RuntimeException();
    }


}
