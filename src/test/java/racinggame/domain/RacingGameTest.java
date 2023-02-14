package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.utils.NumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {
    static List<Car> cars;
    TestNumberGenerator testNumberGenerator;

    @DisplayName("우승자 목록 잘 출력하는지 테스트")
    @Test
    void getWinner() {
        cars = Arrays.asList(new Car("jena"), new Car("jerry"), new Car("poby"));
        int[] powers = {4, 3, 3, 4, 3, 3, 4, 3, 3};
        testNumberGenerator = new TestNumberGenerator(Arrays.stream(powers)
                .boxed()
                .collect(Collectors.toList()));
        RacingGame racingGame = new RacingGame(cars, 3, testNumberGenerator);
        racingGame.run();
        assertThat(racingGame.getWinner().getWinnerNames()).isEqualTo(List.of("jena"));
    }

    @DisplayName("우승자가 여러명일때 잘 출력하는지 테스트")
    @Test
    void getSeveralWinners() {
        cars = Arrays.asList(new Car("jena"), new Car("jerry"), new Car("poby"));
        int[] severalWinnerPowers = {5, 0, 1, 0, 8, 2, 1, 1, 1};
        testNumberGenerator = new TestNumberGenerator(Arrays.stream(severalWinnerPowers)
                .boxed()
                .collect(Collectors.toList()));
        RacingGame racingGame = new RacingGame(cars, 3, testNumberGenerator);
        racingGame.run();
        assertThat(racingGame.getWinner().getWinnerNames()).isEqualTo(List.of("jena", "jerry"));
    }

    class TestNumberGenerator implements NumberGenerator {
        private List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generateNumber() {
            return numbers.remove(0).intValue();
        }
    }
}
