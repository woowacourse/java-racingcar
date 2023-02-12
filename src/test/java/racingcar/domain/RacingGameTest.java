package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.TestNumberGenerator;

class RacingGameTest {

    private RacingGame generateRacingGame(final int count) {
        NumberGenerator numberGenerator = new TestNumberGenerator(Lists.newArrayList(4, 3));
        List<String> names = List.of("car1", "car2");
        return new RacingGame(numberGenerator, names, count);
    }

    @Test
    @DisplayName("play 메서드는 자동차 경주 게임을 진행한다.")
    void should_playGame_when_play() {
        RacingGame racingGame = generateRacingGame(1);

        racingGame.play();

        assertThat(racingGame.findWinners()).containsExactly("car1");
    }

    @Test
    @DisplayName("play 메서드 호출 시 진행 가능 횟수가 1 줄어든다.")
    void should_decreaseCount_when_play() {
        RacingGame racingGame = generateRacingGame(1);

        racingGame.play();

        assertThat(racingGame.isPlayable()).isFalse();
    }

    @Test
    @DisplayName("findCurrentCarPositions 메서드는 현재 경주에 참가하는 자동차들의 이름과 위치를 반환한다.")
    void should_returnCarList_when_findCurrentCarPositions() {
        RacingGame racingGame = generateRacingGame(1);
        racingGame.play();

        List<Car> result = racingGame.findCurrentCarPositions();

        assertThat(result)
                .extracting(Car::getPosition)
                .containsExactly(1, 0);
    }

    @Test
    @DisplayName("findWinners 메서드는 우승자의 이름목록을 반환한다.")
    void should_returnWinnersName_when_findWinners() {
        RacingGame racingGame = generateRacingGame(1);
        racingGame.play();

        List<String> result = racingGame.findWinners();

        assertThat(result).containsExactly("car1");
    }
}
