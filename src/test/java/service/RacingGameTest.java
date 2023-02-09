package service;

import domain.Car;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    @Test
    void 이름들로_자동차들_생성_테스트() {
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator());
        List<String> carNames = Arrays.asList("aaa", "bbb", "ccc");
        racingGame.generateCars(carNames);

        assertThat(racingGame.getCars().size()).isEqualTo(carNames.size());
    }

    @Test
    void 자동차_이름_중복_예외_테스트() {
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator());
        assertThatThrownBy(()->racingGame.generateCars(Arrays.asList("bb", "bb", "cc")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_개수_1개_일_때_예외_테스트() {
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator());
        assertThatThrownBy(()->racingGame.generateCars(Arrays.asList("bb")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 값에_따른_자동차_진행_테스트() {
        RacingGame racingGame = new RacingGame(new TestNumberGenerator());
        List<String> carNames = new ArrayList<>(List.of("aaa", "bbb", "ccc"));
        racingGame.generateCars(carNames);

        racingGame.processAllCars();
        List<Car> resultCars = racingGame.getCars();

        assertThat(resultCars.get(0).getPosition()).isEqualTo(0);
        assertThat(resultCars.get(1).getPosition()).isEqualTo(0);
        assertThat(resultCars.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 게임_승자_테스트() {
        RacingGame racingGame = new RacingGame(new TestNumberGenerator());
        List<String> carNames = new ArrayList<>(List.of("aaa", "bbb", "ccc"));
        racingGame.generateCars(carNames);

        racingGame.processAllCars();
        List<Car> resultCars = racingGame.getCars();

        assertThat(resultCars.get(0).getPosition()).isEqualTo(0);
        assertThat(resultCars.get(1).getPosition()).isEqualTo(0);
        assertThat(resultCars.get(2).getPosition()).isEqualTo(1);

        assertThat(racingGame.decisionWinners()).containsOnly("ccc");
    }

    private static class TestNumberGenerator implements NumberGenerator {
        Queue<Integer> numbers = new LinkedList<>(List.of(0, 3, 4));

        @Override
        public int generate(int startInclusive, int endInclusive) {
            return numbers.poll();
        }
    }
}