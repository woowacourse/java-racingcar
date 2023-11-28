package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private NumberGenerator numberGenerator;
    private Cars cars;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        numberGenerator = new FixedNumberGenerator();
        cars = new Cars(List.of(
                new Car(new Name("doggy")),
                new Car(new Name("0chil")),
                new Car(new Name("1bean"))
        ));
        racingGame = new RacingGame(numberGenerator, cars);
    }

    @Test
    void 주어진_횟수만큼_게임을_진행한다() {
        // given
        TryCount tryCount = new TryCount(10);

        // when
        List<List<Car>> records = racingGame.playGame(tryCount);

        // then
        assertSoftly(softly -> {
            softly.assertThat(records).hasSize(tryCount.value());

            List<Car> lastRecord = records.get(records.size() - 1);
            assertThat(lastRecord)
                    .filteredOn(it -> it.distance() == tryCount.value())
                    .hasSize(cars.cars().size());
        });
    }

    @Test
    void 우승자를_반환한다() {
        // given
        TryCount tryCount = new TryCount(10);
        racingGame.playGame(tryCount);

        // when
        List<Car> winners = racingGame.winners();

        // then
        assertThat(winners.size()).isEqualTo(cars.cars().size());
    }
}
