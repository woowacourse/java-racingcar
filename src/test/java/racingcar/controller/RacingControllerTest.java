package racingcar.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.IOTest;
import racingcar.utils.StubNumberGenerator;

import static org.assertj.core.api.Assertions.*;

public class RacingControllerTest extends IOTest {

    @ParameterizedTest
    @ValueSource(strings = "ac,cd,ef\n2")
    void 레이싱_컨트롤러_플레이_성공(String input) {
        systemIn(input);
        RacingController racingController = new RacingController();
        StubNumberGenerator numberGenerator = new StubNumberGenerator();
        numberGenerator.prepareStubNumbers(6,3,3,4,4,3,3);

        racingController.play(numberGenerator);

        assertThat(getOutput()).contains("ac, ef가 최종 우승 했습니다.");
    }


}