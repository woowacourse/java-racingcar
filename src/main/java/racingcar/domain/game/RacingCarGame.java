package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class RacingCarGame {

    private final NumberGenerator numberGenerator;
    private final WinnerJudge winnerJudge;
    private final Cars cars;
    private final Lap lap;

    private RacingCarGame(final NumberGenerator numberGenerator,
                          final WinnerJudge winnerJudge,
                          final Cars cars,
                          final Lap lap) {
        this.numberGenerator = numberGenerator;
        this.winnerJudge = winnerJudge;
        this.cars = cars;
        this.lap = lap;
    }

    public static RacingCarGame init(final NumberGenerator numberGenerator,
                                     final WinnerJudge winnerJudge,
                                     final Cars cars,
                                     final Lap lap) {
        return new RacingCarGame(numberGenerator, winnerJudge, cars, lap);
    }

    public boolean hasMoreLap() {
        return lap.hasNext();
    }

    /**
     * Cars.move()의 결과로 MovedResult 를 반환할지,
     * 혹은 이곳에서 반환할 지 고민중입니다.
     * <p>
     * Cars 에서는 자동차들과 관련된 책임을 담당하는 것이 좋다고 생각하는데, 차들의 이동 결과 역시 Cars 에서 담당하는 것이 좋다고 생각합니다.
     * 그러나 매 Lap 마다 결과를 보여준다는 것은 게임에서 필요로 하는 비즈니스 로직이라 생각하여, 이곳에서 구현하였습니다.
     * 카일님은 이에 대해 어떻게 생각하시나요?
     */
    public MovedResult race() {
        if (!hasMoreLap()) {
            throw new IllegalStateException("이미 모든 바퀴를 진행했습니다.");
        }
        cars.move(numberGenerator);
        lap.next();
        return new MovedResult(cars);
    }

    public GameResult gameResult() {
        if (hasMoreLap()) {
            throw new IllegalStateException("아직 게임이 종료되지 않았습니다.");
        }
        List<Car> winners = winnerJudge.judge(cars);
        return new GameResult(winners);
    }
}
