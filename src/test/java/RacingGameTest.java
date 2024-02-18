import static org.assertj.core.api.Assertions.*;

import domain.Car;
import domain.Cars;
import domain.Count;
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

    Cars cars;
    Count count;

    @BeforeEach
    void setUp() {
        cars = Cars.from(List.of("a", "b", "c"));
        count = new Count(1);
    }

    @Test
    @DisplayName("횟수가 잘 저장 되는지 확인한다")
    void saveCount() {
        RacingGame racingGame = RacingGame.of(count, cars, new RandomMovementGenerator((a, b) -> 5));
        assertThat(racingGame).extracting("count").isEqualTo(Count.from(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"5,1", "0,0", "4,1", "2,0", "9,1"})
    @DisplayName("자동차들이 전진 혹은 정지를 하는지 확인한다.")
    void play(int power, int expectedDistance) {
        // given
        RacingGame racingGame = RacingGame.of(count, cars, new RandomMovementGenerator((a, b) -> power));
        // when
        racingGame.race();
//        TurnResult firstTurn = racingGame.getRaceResult().get(0);
        // then
        for (int i = 0; i < cars.getCars().size(); i++) {
//            assertThat(firstTurn.getCarStatuses().get(i).getDistance()).isEqualTo(expectedDistance);
        }
    }
}
