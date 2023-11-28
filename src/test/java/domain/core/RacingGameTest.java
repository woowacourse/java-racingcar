package domain.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import domain.vo.Record;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private final List<String> carNames = List.of("doggy", "0chil", "1bean");
    private final int tryCount = 10;
    private final RacingGame racingGame = new RacingGame(new FixedNumberGenerator(), carNames, tryCount);

    @Test
    void 주어진_횟수만큼_게임을_진행한다() {
        // when
        List<List<Record>> records = racingGame.playGame();

        // then
        assertSoftly(softly -> {
            softly.assertThat(records).hasSize(tryCount);

            List<Record> lastRecord = records.get(records.size() - 1);
            assertThat(lastRecord)
                    .filteredOn(it -> it.distance() == tryCount)
                    .hasSize(carNames.size());
        });
    }

    @Test
    void 우승자를_반환한다() {
        // when
        List<Car> winners = racingGame.winners();

        // then
        assertSoftly(softly -> {
            softly.assertThat(winners.size()).isEqualTo(carNames.size());
            softly.assertThat(winners).allMatch(car -> car.distance() == 0);
        });
    }
}
