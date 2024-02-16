import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import domain.Movement;
import domain.MovementGenerator;
import domain.NumberGenerator;
import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomMovementGeneratorTest {
    @Test
    @DisplayName("랜덤 숫자가 4이상이면 전진을 반환한다.")
    void move_true() {
        NumberGenerator numberGenerator = () -> 4;
        MovementGenerator movementGenerator = new RandomMovementGenerator(numberGenerator);
        assertThat(movementGenerator.generate()).isEqualTo(Movement.MOVE);
    }
    @Test
    @DisplayName("랜덤 숫자가 4미만이면 전진을 반환한다.")
    void move_false() {
        NumberGenerator numberGenerator = () -> 3;
        MovementGenerator movementGenerator = new RandomMovementGenerator(numberGenerator);
        assertThat(movementGenerator.generate()).isEqualTo(Movement.STAY);
    }
}