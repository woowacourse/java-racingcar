package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @DisplayName("공동 우승자 확인")
    @Test
    void findWinners() {
        Cars cars = Cars.from("aa,bb,cc");
        cars.go(() -> 5);

        List<Car> winner = cars.findWinners();

        assertThat(winner).hasSize(3);
    }

    @DisplayName("단독 우승자 확인")
    @Test
    void findWinner() {
        Car winner = Car.from("a");
        Car loser1 = Car.from("b");
        Car loser2 = Car.from("c");

        winner.go(new AlwaysMoveNumberGenerator());
        loser1.go(new NoMoveNumberGenerator());
        loser2.go(new NoMoveNumberGenerator());

        Cars cars = new Cars(winner, loser1, loser2);

        List<Car> winners = cars.findWinners();

        assertThat(winners).hasSize(1).extracting("name").isEqualTo(List.of("a"));
    }

    @DisplayName("올바르지 않은 구분자")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,,", ",akd,ll", "a,,b", ","})
    void invalidSeparator(String value) {
        assertThatThrownBy(() -> Cars.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }


    static class AlwaysMoveNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 4;
        }
    }

    static class NoMoveNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 0;
        }
    }

    @DisplayName("자동차 이름이 중복시 예외 발생")
    @Test
    void duplicatedName() {
        assertThatThrownBy(() -> Cars.from("aa,aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getter로 가져온 List는 수정이 불가")
    @Test
    void add() {
        Cars cars = Cars.from("a,b,c");

        List<Car> unmodifiedCars = cars.getCars();

        assertThatThrownBy(() -> unmodifiedCars.add(Car.from("새로운차")))
                .isInstanceOf(UnsupportedOperationException.class);
    }


    @DisplayName("getter로 얻은 자동차의 상태를 변경할 수 없다.")
    @Test
    void invalidChangeState() {
        // given
        Cars cars = Cars.from("a,b,c");
        List<Car> unmodifiedCars = cars.getCars();
        Car unmodifyCar = unmodifiedCars.get(0);
        unmodifyCar.go(new AlwaysMoveNumberGenerator());

        // when
        List<Car> originCars = cars.getCars();
        Car originCar = originCars.get(0);

        // then
        assertThat(originCar.getPosition()).isNotEqualTo(unmodifyCar.getPosition());
    }
}
