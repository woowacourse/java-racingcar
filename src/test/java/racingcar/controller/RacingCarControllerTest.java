package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarControllerTest {
    @Test
    void checkOverlappedNames() {
        List<String> falseList = Arrays.asList("bada", "bada", "whyb");
        assertThatThrownBy(()-> {
            Boolean expectedFalse = RacingCarController.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 이름을 중복하여 사용할 수 없습니다");
    }

    @Test
    void checkNameLength() {
        List<String> falseList = Arrays.asList("pobi", "bada", "whybbb");
        assertThatThrownBy(()-> {
            Boolean expectedFalse = RacingCarController.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 이름은 5자 이하로 입력해주세요");
    }

    @Test
    void checkNull() {
        List<String> falseList = Arrays.asList("");
        assertThatThrownBy(()-> {
            Boolean expectedFalse = RacingCarController.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 경주할 자동차를 1대 이상 입력해주세요");
    }
}
