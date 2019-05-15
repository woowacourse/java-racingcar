package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MoveStrategyTest {

    private MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        moveStrategy = new MoveStrategy();
    }

    // 외부에서 랜덤을 신경 쓸 필요가 없는 대신
    // 테스트코드에서 내부에 있는 세부정보 (랜덤값 생성)을 신경쓰게되는 건가?
    @Test
    void isMove_참인랜덤값생성() {
        // Arrange
        IntStream validRandValues = IntStream.range(MoveStrategy.MOVE_START, MoveStrategy.MAX_NUM);

        validRandValues.forEach((v) -> {
            assertTrue(moveStrategy.test(v), String.format("v: %d", v));
        });
    }

    @Test
    void isMove_거짓인랜덤값생성() {
        // Arrange
        IntStream validRandValues = IntStream.range(0, MoveStrategy.MOVE_START);

        validRandValues.forEach((v) -> {
            assertFalse(moveStrategy.test(v), String.format("v: %d", v));
        });
    }
}