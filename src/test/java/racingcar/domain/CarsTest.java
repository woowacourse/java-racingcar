package racingcar.domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private static final int TEST_GAME_ROUND = 3;

    private Car pobi;
    private Car neo;
    private Car hiiro;
    private Cars cars;

    @BeforeEach
    void beforeTest() {
        pobi = new Car("pobi", new TestNumberGenerator(new ArrayList<>(List.of(3, 4, 5))));
        neo = new Car("neo", new TestNumberGenerator(new ArrayList<>(List.of(4, 3, 5))));
        hiiro = new Car("hiiro", new TestNumberGenerator(new ArrayList<>(List.of(1, 4, 2))));

        cars = new Cars(new ArrayList<>(List.of(pobi, neo, hiiro)));
    }

    @Test
    @DisplayName("자동차 이름이 없어서 빈 리스트가 넘어오면 오류가 발생한다.")
    void carsGenerateTest() {
        //Given
        List<Car> testCase = new ArrayList<>();

        //When
        Throwable result = catchThrowable(() -> {
            new Cars(testCase);
        });

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승한 자동차를 제공한다.")
    void decideWinnerTest() {
        //todo : cars 객체를 생성하는 코드를 beforeEach로 분리하기 (공통된 car 객체 삽입 부분)

        //Given
        for (int i = 0; i < TEST_GAME_ROUND; i++) {
            cars.moveEachCar();
        }

        //When
        List<Car> result = cars.findAllWinner();

        //Then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("모든 자동차들이 전진을 1회 시도한다.")
    void eachCarMoveTest() {

        //When
        List<Car> result = cars.moveEachCar();

        //Then
        assertThat(result.get(0).getPosition()).isEqualTo(0);
        assertThat(result.get(1).getPosition()).isEqualTo(1);
        assertThat(result.get(2).getPosition()).isEqualTo(0);
    }

}
