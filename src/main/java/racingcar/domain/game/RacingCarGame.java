package racingcar.domain.game;

import racingcar.domain.car.Cars;

import java.util.stream.IntStream;

public class RacingCarGame {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private final Lap totalLap;
    private Lap currentLap;

    private RacingCarGame(final NumberGenerator numberGenerator,
                          final Cars cars,
                          final Lap totalLap) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
        this.totalLap = totalLap;
        this.currentLap = Lap.init();
    }

    public static RacingCarGame init(final NumberGenerator numberGenerator,
                                     final Cars cars,
                                     final Lap lap) {
        return new RacingCarGame(numberGenerator, cars, lap);
    }

    public Cars cars() {
        return cars;
    }

    /**
     * 조금 더 고민해 본 결과,Cars의 내부 상태를 숨기기 위해(getter 를 public 으로 공개하지 않도록)
     * Cars에서 반환하는 것이 더 좋겠다 판단하였어요!
     * 이에 대한 카일의 의견이 궁금해요!
     */
    public void race() {
        if (!hasMoreLap()) {
            throw new IllegalStateException("이미 모든 바퀴를 진행했습니다.");
        }
        currentLap = currentLap.increase();
        cars.move(generateNumbers());
    }

    private int[] generateNumbers() {
        return IntStream.range(0, cars.cars().size())
                .map(it -> numberGenerator.generate(MIN_NUMBER, MAX_NUMBER))
                .toArray();
    }

    public boolean hasMoreLap() {
        return !totalLap.equals(currentLap);
    }

    public Winners winner() {
        if (hasMoreLap()) {
            throw new IllegalStateException("아직 게임이 종료되지 않았습니다.");
        }
        return new Winners(cars.cars());
    }
}
