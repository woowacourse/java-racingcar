import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomMovementGeneratorTest {
    @Test
    @DisplayName("랜덤 이동 생성")
    void create() {
        assertThatCode(() -> new RandomMovementGenerator(new RandomNumberGenerator())).doesNotThrowAnyException();
    }
}