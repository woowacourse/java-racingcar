package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성 테스트")
    void createCarsTest() {
        Cars cars = new Cars("pobi,crong,honux");

        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Cars 객체 생성 시 중복으로 인한 예외 발생 테스트")
    void createCarsExceptionTest() {
        assertThatThrownBy(() -> {
            new Cars("pobi,pobi,pobi");
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("단일 우승자인 경우 결과 테스트")
    void getWinnerTest() {
        String names = "ocean,jamie";
        Cars cars = new Cars(names);

        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(9, 0, 6, 7));
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(randomNumbers);

        for (int i = 0; i < 2; i++)
            cars.moveForRound(testNumberGenerator);

        assertThat(cars.getWinners()).isEqualTo("ocean");
    }

    @Test
    @DisplayName("다중 우승자인 경우 결과 테스트")
    void getWinnersTest() {
        String names = "ocean,jamie";
        Cars cars = new Cars(names);

        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(9, 9, 6, 6));
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(randomNumbers);

        for (int i = 0; i < 2; i++)
            cars.moveForRound(testNumberGenerator);

        assertThat(cars.getWinners()).isEqualTo("ocean, jamie");
    }

    static class TestNumberGenerator implements NumberGenerator {
        private final List<Integer> numbers;

        public TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generateNumber() {
            return numbers.remove(0);
        }
    }
}
