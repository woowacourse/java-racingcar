package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.TestNumberGenerator;

class RacingGameTest {

    private RacingGame generateRacingGame(int count) {
        NumberGenerator numberGenerator = new TestNumberGenerator(Lists.newArrayList(4, 3));
        Cars cars = new Cars(List.of(new Car("car1"), new Car("car2")));
        return new RacingGame(numberGenerator, cars, count);
    }

    @ParameterizedTest(name = "isPlayable 메서드는 진행 가능 횟수가 {0}인 경우 {1}을 반환한다.")
    @CsvSource({"1,true", "0,false"})
    void should_returnState_when_callIsPlayable(int count, boolean state) {
        RacingGame racingGame = generateRacingGame(count);

        assertThat(racingGame.isPlayable()).isEqualTo(state);
    }

    @Test
    @DisplayName("play 메서드는 자동차 경주 게임을 진행 후 결과를 반환한다.")
    void should_returnCarList_when_play() {
        RacingGame racingGame = generateRacingGame(1);

        List<Car> result = racingGame.play();

        assertThat(result)
                .extracting("position")
                .containsExactly(1, 0);
    }

    @Test
    @DisplayName("play 메서드 호출 시 진행 가능 횟수가 1 줄어든다.")
    void should_decreaseCount_when_play() {
        RacingGame racingGame = generateRacingGame(1);

        racingGame.play();

        assertThat(racingGame.isPlayable()).isFalse();
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
