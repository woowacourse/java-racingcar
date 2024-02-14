package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> RacingGame.of(createCars(), moveCondition()))
            .doesNotThrowAnyException();
    }

    @DisplayName("모든 자동차를 움직일 수 있다.")
    @Test
    void moveAll() {
        RacingGame game = RacingGame.of(createCars(), moveCondition());

        game.moveAll();

        assertThat(game.getCars()).isEqualTo(createMovedCars());
    }

    @DisplayName("경주에 참여하는 자동차의 수는 최소 2대이다.")
    @Test
    void checkCarsSize() {
        assertThatThrownBy(() -> RacingGame.of(List.of(Car.from("이상")), moveCondition()))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("중복을 확인한다.")
    @Test
    void checkDistinct() {
        assertThatThrownBy(() -> RacingGame.of(List.of(Car.from("이상"), Car.from("이상")), moveCondition()))
            .isInstanceOf(RuntimeException.class);
    }

    private List<Car> createCars() {
        return List.of(
            Car.from("아톰"),
            Car.from("이상")
        );
    }

    private List<Car> createMovedCars() {
        return List.of(
            Car.of("아톰", 1),
            Car.of("이상", 1)
        );
    }

    private MoveCondition moveCondition() {
        return () -> true;
    }
}
