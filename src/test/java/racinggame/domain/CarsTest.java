package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("경주에 참여하는 자동차의 수는 최소 2대이다.")
    @Test
    void checkCarsSize() {
        assertThatThrownBy(() -> new Cars(List.of(new Car("이상")), moveCondition()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복을 확인한다.")
    @Test
    void checkDistinct() {
        assertThatThrownBy(() -> new Cars(
            List.of(
                new Car("이상"),
                new Car("이상")), moveCondition()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("우승자를 선정한다.")
    @Test
    void findWinner() {
        List<Car> movedCars = createMovedCars(1, 2);
        Cars cars = new Cars(movedCars, moveCondition());

        List<String> result = cars.findWinnersName();

        assertThat(result).containsExactly("이상");
        assertThat(result.size()).isEqualTo(1);
    }

    @DisplayName("공동 우승자를 선정한다.")
    @Test
    void findWinners() {
        Cars cars = new Cars(createCars(), moveCondition());

        List<String> result = cars.findWinnersName();

        assertThat(result).containsExactly("아톰", "이상");
        assertThat(result.size()).isEqualTo(2);
    }

    @DisplayName("모든 자동차를 움직일 수 있다.")
    @Test
    void moveAll() {
        Cars cars = new Cars(createCars(), moveCondition());

        cars.moveAll();

        assertThat(cars.buildRoundResult().carInfos()).containsExactly(
            new CarInfo("아톰", 1),
            new CarInfo("이상", 1)
        );
    }

    private List<Car> createCars() {
        return List.of(
            new Car("아톰"),
            new Car("이상")
        );
    }

    private List<Car> createMovedCars(int position1, int position2) {
        return List.of(
            new Car("아톰", position1),
            new Car("이상", position2)
        );
    }

    private MoveCondition moveCondition() {
        return () -> true;
    }
}
