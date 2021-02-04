package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarControllerTest {
    @Test
    void checkOverlappedNames() {
        List<String> falseList = Arrays.asList("bada", "bada", "whyb");
        assertThatThrownBy(()-> {
            RacingCarController.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 이름을 중복하여 사용할 수 없습니다");
    }

    @Test
    void checkNameLength() {
        List<String> falseList = Arrays.asList("pobi", "bada", "whybbb");
        assertThatThrownBy(()-> {
            RacingCarController.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 이름은 5자 이하로 입력해주세요");
    }

    @Test
    void checkNull() {
        List<String> falseList = new ArrayList<>();
        assertThatThrownBy(()-> {
            RacingCarController.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 경주할 자동차를 1대 이상 입력해주세요");
    }

    @Test
    void checkInteger() {
        String turns = "";
        assertThatThrownBy(()-> {
            RacingCarController.checkTurns(turns);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 시도 횟수는 숫자여야 합니다");
    }

    @Test
    void checkNegative() {
        String turns = "-1";
        assertThatThrownBy(()-> {
            RacingCarController.checkTurns(turns);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 시도 횟수는 음수일 수 없습니다");
    }
}
