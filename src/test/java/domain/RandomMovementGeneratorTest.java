package domain;

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
        final MovementGenerator movementGenerator = new RandomMovementGenerator(new MoveNumberGenerator());

        assertThat(movementGenerator.generate()).isEqualTo(Movement.MOVE);
    }
    @Test
    @DisplayName("랜덤 숫자가 4미만이면 전진을 반환한다.")
    void move_false() {
        final MovementGenerator movementGenerator = new RandomMovementGenerator(new StayNumberGenerator());

        assertThat(movementGenerator.generate()).isEqualTo(Movement.STAY);
    }

    static class MoveNumberGenerator implements NumberGenerator {

        @Override
        public int generate() {
            return 4;
        }
    }

    static class StayNumberGenerator implements NumberGenerator {

        @Override
        public int generate() {
            return 3;
        }
    }
}