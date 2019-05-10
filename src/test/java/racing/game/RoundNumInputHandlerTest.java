package racing.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundNumInputHandlerTest {
    @Test
    void 라운드에문자입력시에러확인() {
        assertThrows(Exception.class, () -> {
            RoundNumInputHandler.getRoundNumber("aa");
        });
    }

    @Test
    void 라운드에1미만의정수입력시에러확인() {
        assertThrows(Exception.class, () -> {
            RoundNumInputHandler.getRoundNumber("0");
        });
    }

    @Test
    void 라운드에빈입력시에러확인() {
        assertThrows(Exception.class, () -> {
            RoundNumInputHandler.getRoundNumber("aa");
        });
    }
}
