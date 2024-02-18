package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("[Success] position 증가를 요청하면 현재 position보다 1 증가된 Position 객체의 인스턴스를 생성한다")
    void increasePosition() {
        final Position position = new Position(0);

        assertThat(position.increasePosition().position())
                .isEqualTo(1);
    }
}
