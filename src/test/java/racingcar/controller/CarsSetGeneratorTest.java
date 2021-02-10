package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsSetGeneratorTest {

    private static final String[] OVERLAPPED_SAMPLE = {"bada", "bada", "whyb"};
    private static final String[] LONGNAME_SAMPLE = {"pobi", "bada", "whybbb"};
    private static final String OVERLAPPED_MESSAGE = "[ERROR] 이름을 중복하여 사용할 수 없습니다";
    private static final String LENGTH_MESSAGE = "[ERROR] 이름은 5자 이하로 입력해주세요";
    private static final String NULL_MESSAGE = "[ERROR] 경주할 자동차를 1대 이상 입력해주세요";

    @Test
    @DisplayName("자동차 중복된 이름있는지 체크 테스트")
    void checkOverlappedNames() {
        List<String> falseList = Arrays.asList(OVERLAPPED_SAMPLE);
        assertThatThrownBy(() -> {
            CarsSetGenerator.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(OVERLAPPED_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 길이 체크 테스트")
    void checkNameLength() {
        List<String> falseList = Arrays.asList(LONGNAME_SAMPLE);
        assertThatThrownBy(() -> {
            CarsSetGenerator.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LENGTH_MESSAGE);
    }

    @Test
    @DisplayName("자동차 빈 이름 체크 테스트")
    void checkNull() {
        List<String> falseList = new ArrayList<>();
        assertThatThrownBy(() -> {
            CarsSetGenerator.checkNames(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NULL_MESSAGE);
    }
}
