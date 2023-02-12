package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

class RacingGameTest {

    private final List<String> carNames = List.of("박스터", "포르쉐", "소나타");

    @Test
    @DisplayName("play 메소드를 호출하면 모든 자동차의 position이 1 증가한다.")
    void play_with_always_move() {
        int tryCount = 1;

        RacingGame game = new RacingGame(new AlwaysMoveGenerator(), new Cars(carNames), tryCount);
        game.play();

        List<Car> result = game.decideResult();

        List<Integer> positions = result.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        Assertions.assertThat(positions).containsOnly(tryCount);
    }

    @Test
    @DisplayName("play 메소드를 호출하면 모든 자동차의 position이 1 증가하지 않는다.")
    void play_with_always_stop() {
        int tryCount = 1;

        RacingGame game = new RacingGame(new NeverMoveGenerator(), new Cars(carNames), tryCount);
        game.play();

        List<Car> result = game.decideResult();

        List<Integer> positions = result.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        Assertions.assertThat(positions).containsOnly(0);
    }

    private static class AlwaysMoveGenerator implements RandomNumberGenerator {

        @Override
        public int generate() {
            return 4;
        }
    }

    private static class NeverMoveGenerator implements RandomNumberGenerator {

        @Override
        public int generate() {
            return 3;
        }
    }

}