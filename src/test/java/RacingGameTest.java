import static org.assertj.core.api.Assertions.*;

import domain.Car;
import domain.Cars;
import domain.Count;
import domain.RaceResult;
import domain.RacingGame;
import domain.RandomMovementGenerator;
import dto.TurnResult;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingGameTest {


    @Test
    @DisplayName("횟수가 잘 저장 되는지 확인한다")
    void saveCount() {
        Cars cars = Cars.from(List.of("a", "b", "c"));
        Count count = new Count(1);
        RacingGame racingGame = RacingGame.of(count, cars, new RandomMovementGenerator((a, b) -> 5));
        assertThat(racingGame).extracting("count").isEqualTo(Count.from(1));
    }
}
