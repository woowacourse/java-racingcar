package racingcar.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ValidationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeAll
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void 플레이어_이름_5자_초과_검증() {
        assertThatThrownBy(() -> Validation.carNameValidation("aaaaaaa,bbbb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 1자 이상, 5자 이하여야 합니다");
    }

    @Test
    void 플레이어_이름_0자_검증() {
        assertThatThrownBy(() -> Validation.carNameValidation(",,,bbbb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름이 존재합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"q", "qwerasdfzxcv", "qq23", "aaa", "-5"})
    void 게임_회수_입력_오류검증(String value) {
        assertThatThrownBy(() -> Validation.tryNumValidation(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 회수는 숫자만 입력 가능합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "10", "20"})
    void 게임_회수_입력_참검증(String value) {
        Validation.tryNumValidation(value);
    }

    @Test
    void 플레이어_이름_중복_검증() {
        assertThatThrownBy(() -> Validation.carNameValidation("pobi,crong,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름이 존재합니다");
    }
}
