package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameControllerTest {
    RacingGameController racingGameController;

    @BeforeEach
    void setUp() {
        racingGameController = new RacingGameController();
    }

    @Test
    void 이름이_잘_나눠지는지_확인() throws Exception {
        String carNameList = "pobi,brown,woni,cu,jun,jason";
        String[] resultArray = {"pobi", "brown", "woni", "cu", "jun", "jason"};
        String[] testArray = racingGameController.makeValidCarNames(carNameList);

        for (int i = 0; i < testArray.length; i++) {
            assertThat(testArray[i]).isEqualTo(resultArray[i]);
        }
    }

    @Test
    void 앞에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGameController.makeValidCarNames(",,,pobi");
        });
    }

    @Test
    void 중간에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGameController.makeValidCarNames("po,,,bi");
        });
    }

    @Test
    void 뒤에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGameController.makeValidCarNames("pobi,,,");
        });
    }

    @Test
    void 다섯자_이상_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGameController.makeValidCarNames("pppooobbbiii,brown,cu");
        });
    }

    @Test
    void 공백이_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGameController.makeValidCarNames("pobi,   ,brown");
        });
    }
}
