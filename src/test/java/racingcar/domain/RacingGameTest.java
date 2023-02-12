package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestNumberGenerator;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = generateRacingGame(1);
    }

    private RacingGame generateRacingGame(final int count) {
        final NumberGenerator numberGenerator = new TestNumberGenerator(Lists.newArrayList(4, 3));
        final List<String> names = List.of("car1", "car2");
        return new RacingGame(numberGenerator, new Cars(names), new Count(count));
    }

    @Test
    @DisplayName("play 메서드는 자동차 경주 게임을 진행한다.")
    void should_returnCarList_when_play() {
        racingGame.play();
        final List<Car> result = racingGame.getCurrentResult();

        assertThat(result)
                .extracting(Car::getPosition)
                .containsExactly(1, 0);
    }

    @Test
    @DisplayName("play 메서드 호출 시 진행 가능 횟수가 1 줄어든다.")
    void should_decreaseCount_when_play() {
        racingGame.play();

        assertThat(racingGame.isPlayable()).isFalse();
    }

    @Test
    @DisplayName("findWinners 메서드는 우승자의 이름목록을 반환한다.")
    void should_returnWinnersName_when_findWinners() {
        racingGame.play();

        final List<String> result = racingGame.findWinners();

        assertThat(result).containsExactly("car1");
    }

    @Test
    @DisplayName("isPlayable 메서드는 자동차 경주 게임 진행 가능 여부를 반환한다.")
    void should_returnPlayableStatus_when_isPlayable() {
        boolean result = racingGame.isPlayable();

        assertThat(result).isTrue();
    }
}
