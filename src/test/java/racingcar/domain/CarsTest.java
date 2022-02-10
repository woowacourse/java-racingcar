package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("Cars 생성자의 정상 로직을 테스트한다.")
    @Test
    void constructor_정상() {
        // given
        String[] names = new String[] {"pobi", "crong", "honux"};
        MovingPolicy movingPolicy = new RandomMovingPolicy();

        // when & then
        assertThatCode(() -> {
            new Cars(names, movingPolicy);
        }).doesNotThrowAnyException();
    }

    @DisplayName("중복된 차 이름이 존재하는 경우 예외를 던진다.")
    @Test
    void constructor_차이름_중복() {
        // given
        String[] names = new String[] {"pobi", "pobi", "pobi"};
        MovingPolicy movingPolicy = new RandomMovingPolicy();

        // when & then
        assertThatThrownBy(() -> {
            new Cars(names, movingPolicy);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("isMove가 true이면 position이 일괄적으로 증가한다.")
    @Test
    void move_전진() {
        // given
        String[] names = new String[] {"pobi", "crong", "honux"};
        MovingPolicy movingPolicy = () -> true;
        Cars cars = new Cars(names, movingPolicy);

        // when
        cars.move();

        // then
        assertThat(cars.getWinners().size()).isEqualTo(3);
    }

    @DisplayName("isMove가 false이면 position이 일괄적으로 정지한다.")
    @Test
    void move_정지() {
        // given
        String[] names = new String[] {"pobi", "crong", "honux"};
        MovingPolicy movingPolicy = () -> false;
        Cars cars = new Cars(names, movingPolicy);

        // when
        cars.move();

        // then
        assertThat(cars.getWinners().size()).isEqualTo(3);
    }

    @DisplayName("최소 한 명 이상의 우승자가 존재한다.")
    @Test
    void getWinners() {
        // given
        String[] names = new String[] {"pobi", "crong", "honux"};
        MovingPolicy movingPolicy = new RandomMovingPolicy();
        Cars cars = new Cars(names, movingPolicy);

        // when
        cars.move();
        cars.move();
        cars.move();

        // then
        System.out.println(cars.getWinners());
        assertThat(cars.getWinners().size()).isGreaterThanOrEqualTo(1);
    }
}