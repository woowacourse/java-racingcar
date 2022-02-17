package racingcar.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.IOTest;
import racingcar.utils.StubNumberGenerator;

import static org.assertj.core.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
public class RacingControllerTest extends IOTest {

    private StubNumberGenerator numberGenerator = new StubNumberGenerator();

    @ParameterizedTest
    @ValueSource(strings = "ac,cd,ef\n2")
    void 레이싱_컨트롤러_플레이_성공(String input) {
        systemIn(input);
        RacingController racingController = new RacingController();
        numberGenerator.prepareStubNumbers(6, 3, 3, 4, 4, 3, 3);

        racingController.play(numberGenerator);

        assertThat(getOutput()).contains("ac, ef가 최종 우승 했습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = "ac, cd,ef\nac,cd\n2")
    void 레이싱_컨트롤러_공백_에러_메시지(String input) {
        systemIn(input);
        RacingController racingController = new RacingController();
        numberGenerator.prepareStubNumbers(4, 4, 1, 4, 1);

        racingController.play(numberGenerator);

        assertThat(getOutput()).contains("[ERROR] 이름에 공백이 존재합니다.")
                .contains("ac가 최종 우승 했습니다.");
    }

}