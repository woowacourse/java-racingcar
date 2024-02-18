package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> new RacingGame(createCars(), moveCondition()))
            .doesNotThrowAnyException();
    }

    @DisplayName("라운드 수 만큼 경주를 진행할 수 있다.")
    @Test
    void race() {
        RacingGame game = new RacingGame(createCars(), moveCondition());

        List<RoundResult> result = game.race(new Round(3));

        assertThat(result.size()).isEqualTo(3);
    }

    private List<Car> createCars() {
        return List.of(
            new Car("아톰"),
            new Car("이상")
        );
    }

    private MoveCondition moveCondition() {
        return () -> true;
    }
}
