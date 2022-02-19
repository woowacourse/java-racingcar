package racingcar.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import racingcar.InputNameHandler;
import racingcar.domain.vo.Trial;
import racingcar.util.RandomUtil;
import racingcar.domain.vo.MovingNumber;

public class RacingGame {
    private static final int RANDOM_NUMBER_RANGE = 9 + 1;

    private final Cars cars;
    private final Trial trial;

    public RacingGame(String carNames, int trial) {
        this.cars = new Cars(InputNameHandler.inputToNames(carNames));
        this.trial = new Trial(trial);
    }

    public void race() {
        cars.move(createMovingNumbers(cars.size()));
        trial.minus();
    }

    public boolean isEnd() {
        return !trial.isExists();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public Winners getWinners() {
        return cars.pickMoreWinners();
    }

    private Queue<MovingNumber> createMovingNumbers(int size) {
        return RandomUtil.getRandomNumbers(size, RANDOM_NUMBER_RANGE).stream()
            .map(MovingNumber::new)
            .collect(Collectors.toCollection(LinkedList::new));
    }
}
