package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceResultTest {

    @DisplayName("new RaceResult() 테스트")
    @Test
    void constructor_test() {
        RaceResult raceResult = new RaceResult();
        assertThat(raceResult.getResult()).isEqualTo("자동차 경주 진행 전입니다.");
    }
}
