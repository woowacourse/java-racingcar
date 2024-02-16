package view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import exception.DuplicateCarNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    @DisplayName("자동차 이름은 중복될 수 없다.")
    void isDuplicatedCarName() {
        String names = "pobi,pobi,gugu,gugu,jun";
        assertThrows(DuplicateCarNameException.class, () -> InputView.getSplitCarNames(names));
    }

    @Test
    @DisplayName("시도 횟수는 숫자여야 한다.")
    void isRoundCountsNumber() {
        String counts = "5번";
        assertThrows(IllegalArgumentException.class, () -> InputView.getParsedRacingRounds(counts));
    }
}