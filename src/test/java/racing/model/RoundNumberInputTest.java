package racing.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundNumberInputTest {

    @Test
    void 잘못된_라운드_입력_확인() {
        assertThrows(Exception.class, () -> {
            RoundNumberInput.getRoundNumber("aa");
        });
    }
}
