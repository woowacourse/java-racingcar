package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.view.valid.InputValidException;

import static org.junit.Assert.assertTrue;

public class InputViewTest {

    @Test
    void 자동차_이름이_공백_AND_NULL_테스트() {
        String[] inputName = {""};
        assertTrue(InputValidException.hasBlank(inputName));
    }

    @Test
    void 자동차_이름아_5자초과_테스트() {
        String[] inputName = {"red", "yellow", "green"};
        assertTrue(InputValidException.overLengthName(inputName));
    }

    @Test
    void 자동차_이름이_하나일때_테스트() {
        String[] inputName = {"red"};
        assertTrue(InputValidException.hasNotAnotherPlayer(inputName));
    }

    @Test
    void 자동차_이름이_중복일때_테스트() {
        String[] inputName = {"red", "blue", "red"};
        assertTrue(InputValidException.overLapName(inputName));
    }

    @Test
    void 자동차_이름이_중간에_빌_떄_테스트() {
        String[] inputName = {"red", "", "blue"};
        assertTrue(InputValidException.hasMiddleBlank(inputName));
    }

    @Test
    void 시도_횟수가_빈칸_일_때() {
        String inputName = "";
        assertTrue(InputValidException.hasBlankNumber(inputName));
    }

    @Test
    void 시도_횟수가_음수_일_때() {
        String inputName = "-1";
        assertTrue(InputValidException.hasNegativeNumber(inputName));
    }

    @Test
    void 시도_횟수가_Charater형_일_때() {
        String inputName = "$";
        assertTrue(InputValidException.hasCharacter(inputName));
    }
}
