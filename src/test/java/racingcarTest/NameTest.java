package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Model.Name;
import racingcar.Model.TrialTime;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 클래스 이름 : inputValidationTest.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class NameTest {
    @Test
    @DisplayName("차 이름에 null 값 입력 시")
    void inputValidation_차_이름_null() {
        String carNames = null;
        assertThatThrownBy(() -> {
            Name.checkNullCarName(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 NULL 값일 수 없습니다.");
    }

    @Test
    @DisplayName("차 이름에 빈 문자열 입력 시")
    void inputValidation_차_이름_빈_문자열() {
        String carNames = "";
        assertThatThrownBy(() -> {
            Name.checkEmptyCarName(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 빈 문자열일 수 없습니다.");
    }

    @Test
    @DisplayName("차 이름이 5글자 이내")
    void inputValidation_차_이름_글자수() {
        assertThatThrownBy(() -> {
            String result = "Maserati";
            Name.checkSmallerThanSix(result);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름의 길이가 6 이상입니다.");
    }
}
