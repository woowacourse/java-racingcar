package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    Cars cars;
    Round round;

    @BeforeEach
    void generateCarsAndRound() {
        List<Car> racingCar = new ArrayList<>();
        Car pobi = new Car("pobi", new TestNumberGenerator(new ArrayList<>(List.of(3,4,1))));
        Car ako = new Car("ako", new TestNumberGenerator(new ArrayList<>(List.of(4,5,3))));
        racingCar.add(pobi);
        racingCar.add(ako);

        cars = new Cars(racingCar);
        round = new Round("3");
    }

    @Test
    @DisplayName("시도횟수가 3회이면 결과값을 저장하는 리스트의 길이는 3이 된다.")
    void playGameTest() {
        //Given
        RacingGame racingGame = new RacingGame(cars, round);

        //When
        racingGame.playGame();

        //Then
        assertThat(racingGame.getResult().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임의 우승자는 이름으로 전달 된다.")
    void getWinnersTest() {
        //TODO : 게임의 우승자를 반환하는 기능 테스트하기
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
