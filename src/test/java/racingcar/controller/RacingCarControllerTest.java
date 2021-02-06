package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarControllerTest {
    private static final String[] OVERLAPPED_SAMPLE = {"bada", "bada", "whyb"};
    private static final String[] LONGNAME_SAMPLE = {"pobi", "bada", "whybbb"};
    private static final String OVERLAPPED_MESSAGE = "[ERROR] 이름을 중복하여 사용할 수 없습니다";
    private static final String LENGTH_MESSAGE = "[ERROR] 이름은 5자 이하로 입력해주세요";
    private static final String NULL_MESSAGE = "[ERROR] 경주할 자동차를 1대 이상 입력해주세요";
    private static final String INTEGER_TURN_MESSAGE = "[ERROR] 시도 횟수는 정수여야만 합니다.";
    private static final String NEGATIVE_TURN_MESSAGE = "[ERROR] 시도 횟수는 음수일 수 없습니다";
    private static final String MINUS_TURN_SAMPLE = "-1";
    private static final String VOID_SAMPLE = "";

    @Test
    void checkOverlappedNames() {
        List<String> falseList = Arrays.asList(OVERLAPPED_SAMPLE);
        assertThatThrownBy(()-> {
            RacingCarController.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(OVERLAPPED_MESSAGE);
    }

    @Test
    void checkNameLength() {
        List<String> falseList = Arrays.asList(LONGNAME_SAMPLE);
        assertThatThrownBy(()-> {
            RacingCarController.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(LENGTH_MESSAGE);
    }

    @Test
    void checkNull() {
        List<String> falseList = new ArrayList<>();
        assertThatThrownBy(()-> {
            RacingCarController.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(NULL_MESSAGE);
    }

    @Test
    void checkInteger() {
        String turns = VOID_SAMPLE;
        assertThatThrownBy(()-> {
            RacingCarController.checkTurns(turns);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(INTEGER_TURN_MESSAGE);
    }

    @Test
    void checkNegative() {
        String turns = MINUS_TURN_SAMPLE;
        assertThatThrownBy(()-> {
            RacingCarController.checkTurns(turns);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(NEGATIVE_TURN_MESSAGE);
    }
}
