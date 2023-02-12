package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.domain.vo.CarStatus;
import racingcar.util.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class CarsTest {

    private Cars cars;
    private List<String> carNames;
    private NumberGenerator numberGenerator;

    @BeforeEach
    void beforeEach() {
        //given
        cars = Cars.of(List.of(Car.of("준팍"), Car.of("져니"), Car.of("소니")));
        numberGenerator = new TestNumberGenerator(List.of(0, 4, 9));

        //when
        cars.move(numberGenerator);
    }

    @DisplayName("getRoundResult 메서드 사용시")
    @Nested
    class GetRoundResultTest {
        @DisplayName("자동차의 이름을 확인한다.")
        @Test
        void getNameTest() {
            //then
            assertThat(cars.getRoundResults().stream()
                    .map(CarStatus::getPosition)
                    .collect(Collectors.toList()))
                    .isEqualTo(List.of(1, 2, 2));
        }

        @DisplayName("자동차의 포지션을 확인한다.")
        @Test
        void getPositionTest() {
            //then
            assertThat(cars.getRoundResults().stream()
                    .map(CarStatus::getName)
                    .collect(Collectors.toList()))
                    .isEqualTo(List.of("준팍", "져니", "소니"));
        }
    }


    @DisplayName("pickWinner 메서드 사용 시 우승자를 리턴한다.")
    @Test
    void pickWinnerTest() {
        //then
        assertThat(cars.pickWinners().stream()
                .map(Car::getCarStatus)
                .map(CarStatus::getName)
                .collect(Collectors.toList()))
                .isEqualTo(List.of("져니", "소니"));
    }
}