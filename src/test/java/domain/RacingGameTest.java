package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import movestrategy.MoveStrategy;
import movestrategy.RandomPowerMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    private final MoveStrategy moveStrategy = new RandomPowerMoveStrategy();

    @ParameterizedTest
    @ValueSource(strings = {"a", "a,bb,cCc,dDdD,eeeee", "  a  , bb  , cCc ,    dDdD ,eeeee  "})
    @DisplayName("자동차 이름 입력 성공")
    void carNames_ok(String rawCarNames) {
        assertThatCode(() -> new RacingGame(rawCarNames, moveStrategy)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름 입력 성공: 경계값 100대")
    void carNames_ok_boundaryTest_hundredCases() {
        String testCase = makeTestNames(100);
        new RacingGame(testCase, moveStrategy);
    }

    @Test
    @DisplayName("자동차 이름 입력 실패: 중복")
    void carNames_exception_noDuplication() {
        assertThatThrownBy(() -> new RacingGame("aa,aa,bb", moveStrategy))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되거나 비어 있는 자동차 이름이 있습니다.");
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = " ")
    @DisplayName("자동차 이름 입력 실패: 비어 있거나 null인 입력")
    void carNames_exception_noEmptyInput(String rawCarNames) {
        assertThatThrownBy(() -> new RacingGame(rawCarNames, moveStrategy))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("null 값이나 빈 문자열을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 입력 실패: 쉼표만 입력")
    void carNames_exception_onlyComma() {
        assertThatThrownBy(() -> new RacingGame(",,", moveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b.c", "a,b,c,,d", ",,a,b", "a,b,,"})
    @DisplayName("자동차 이름 입력 실패: delimiter 위반")
    void carNames_exception_delimiterViolation(String rawCarNames) {
        assertThatThrownBy(() -> new RacingGame(rawCarNames, moveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 입력 실패: 경계값 초과 101개")
    void carNames_exception_rangeViolation() {
        String testCase = makeTestNames(101);
        assertThatThrownBy(() -> new RacingGame(testCase, moveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static String makeTestNames(int testCaseAmount) {
        List<String> carNames = new ArrayList<>();
        while (carNames.size() < testCaseAmount) {
            addNameToList(makeRandomName(5), carNames);
        }
        return String.join(",", carNames);
    }

    private static StringBuilder makeRandomName(int length) {
        Random random = new Random();
        StringBuilder randomName = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('a' + random.nextInt(26));
            randomName.append(randomChar);
        }
        return randomName;
    }

    private static void addNameToList(StringBuilder randomName, List<String> carNames) {
        if (!carNames.contains(randomName.toString())) {
            carNames.add(randomName.toString());
        }
    }
}
