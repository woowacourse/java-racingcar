package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 자동차_이름_입력시_예외가_제대로_발생하는지_확인한다() {
        String userInput1 = "pobi,cony,whale"; //예외가 발생하지 않아야 한다
        String userInput2 = "pobi,  ,whale"; //예외가 발생해야 한다
        String userInput3 = "        ";
        String userInput4 = ",,,,";

        assertThatCode(() -> {validator.checkCarNames(userInput1);}).doesNotThrowAnyException();
        assertThatThrownBy(() -> {validator.checkCarNames(userInput2);}).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {validator.checkCarNames(userInput3);}).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {validator.checkCarNames(userInput4);}).isInstanceOf(IllegalArgumentException.class);
    }
}
