package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void carMoveTest() {
        //Given
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(new ArrayList<>(List.of(3,4,5)));
        Cars cars = new Cars(new ArrayList<>(List.of(new Car("pobi"))));
        RacingGame racingGame = new RacingGame(testNumberGenerator, cars);

        //When
        racingGame.playRound();
        racingGame.playRound();
        racingGame.playRound();

        //Then
        assertThat(racingGame.getCars().getCars().get(0).getPosition()).isEqualTo(2);
    }

    static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> numbers;

        public TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}