package racing.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundNumberInputTest {

    @Test
    void 잘못된라운드입력확인() {
        assertThrows(Exception.class, () -> {
            RoundNumberInput.getRoundNumber("aa");});
    }
}
