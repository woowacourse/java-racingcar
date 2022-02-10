package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AttemptTest {

    @Test
    void 같은_숫자_테스트() {
        Attempt attempt = new Attempt(5);
        assertTrue(attempt.isSame(5));
    }
}