package domain;

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
    @DisplayName("자동차 이름 정상 입력")
    void carNames_ok(String rawCarNames) {
        new RacingGame(rawCarNames, moveStrategy);
    }

    @Test
    @DisplayName("자동차 이름 정상 입력: 경계값 입력 - 자동차 100대")
    void carNames_ok_boundaryTest_hundredCases() {
        String testCase = makeTestNames(100);
        new RacingGame(testCase, moveStrategy);
    }

    @Test
    @DisplayName("자동차 이름 예외 입력: 자동차 이름에 중복이 있어서는 안 된다.")
    void carNames_exception_noDuplication() {
        assertThatThrownBy(() -> new RacingGame("aa,aa,bb", moveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = " ")
    @DisplayName("자동차 이름 예외 입력: 입력이 비어 있거나 null이면 안 된다.")
    void carNames_exception_noEmptyInput(String rawCarNames) {
        assertThatThrownBy(() -> new RacingGame(rawCarNames, moveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 예외 입력: 쉼표만 입력하면 안 된다.")
    void carNames_exception_onlyComma() {
        assertThatThrownBy(() -> new RacingGame(",,", moveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b.c", "a,b,c,,d", ",,a,b", "a,b,,"})
    @DisplayName("자동차 이름 예외 입력: 이름은 하나의 쉼표로 구분되어야 한다.")
    void carNames_exception_delimiterViolation(String rawCarNames) {
        assertThatThrownBy(() -> new RacingGame(rawCarNames, moveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 예외 입력(5): 1~100개의 이름만 입력 가능하다.")
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
