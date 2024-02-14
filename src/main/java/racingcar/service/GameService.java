package racingcar.service;

import racingcar.model.Cars;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Round;

public class GameService {

    public void play(Round round, Cars cars) {

        RandomNumberGenerator generator = new RandomNumberGenerator();

        while (!round.isEnd()) {
            cars.go(generator);
            round.progress();
        }
    }
}
