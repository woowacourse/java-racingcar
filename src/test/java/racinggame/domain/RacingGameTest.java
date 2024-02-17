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
        assertThatCode(() -> RacingGame.of(createCars(), moveCondition()))
            .doesNotThrowAnyException();
    }

    @DisplayName("라운드 수 만큼 경주를 진행할 수 있다.")
    @Test
    void race() {
        RacingGame game = RacingGame.of(createCars(), moveCondition());

        game.race(Round.from(3));

        List<RoundResult> result = game.getResult();
        assertThat(result.size()).isEqualTo(3);
    }

    private List<Car> createCars() {
        return List.of(
            Car.createDefault("아톰"),
            Car.createDefault("이상")
        );
    }

    private MoveCondition moveCondition() {
        return () -> true;
    }
}
