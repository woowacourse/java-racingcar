package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Winners 는")
class WinnersTest {

    @Nested
    @DisplayName("성공 테스트")
    class SuccessTest {

        @ParameterizedTest(name = "생성 시 자동차들 중 가장 멀리 간 자동차를 우승자로 가진다")
        @MethodSource("racingcar.domain.car.CarsTest#carsAndWinnerCars")
        void 생성_시_자동차들_중_가장_멀리_간_자동차를_우승자로_가진다(final Cars cars, final List<Car> actualWinnerCars) {
            // when
            Winners winners = new Winners(cars.getCars());

            // then
            assertThat(winners.winners())
                    .containsExactlyInAnyOrderElementsOf(actualWinnerCars);
        }
    }
}
