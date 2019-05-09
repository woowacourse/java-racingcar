package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 이름이_잘_분리되는지_확인한다() {
        String userInput1 = "pobi,cony,whale";
        String userInput2 = " pobi, cony, whale ";
        String[] carNameArray = {"pobi", "cony", "whale"};

        assertThat(validator.splitUserCarNames(userInput1)).isEqualTo(carNameArray);
        assertThat(validator.splitUserCarNames(userInput2)).isEqualTo(carNameArray);
    }
}
