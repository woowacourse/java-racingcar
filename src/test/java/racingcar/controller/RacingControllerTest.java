package racingcar.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.TestInputView;
import racingcar.view.TestOutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingControllerTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.out.println(getOutput());
    }

    @Test
    @DisplayName("각 자동차가 움직인 위치를 구한다.")
    void getCarMovementResultTest() {
        //given
        RacingController racingController = new RacingController(new TestInputView(), new TestOutputView());

        //when
        racingController.start();

        //then
        assertThat(getOutput()).contains("미아:", "메이슨:");
    }

    @Test
    @DisplayName("우승자를 구한다.")
    void getWinnersTest() {
        //given
        RacingController racingController = new RacingController(new TestInputView(), new TestOutputView());

        //when
        racingController.start();

        //then
        assertThat(getOutput()).containsAnyOf("[경주의 우승자] 미아", "[경주의 우승자] 메이슨");
    }

    private String getOutput() {
        return outputStreamCaptor.toString().trim();
    }
}
