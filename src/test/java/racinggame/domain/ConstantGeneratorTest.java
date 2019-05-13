package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConstantGeneratorTest {
    @Test
    void name() {
        NumberGenerator constantGenerator = new ConstantGenerator(3);

        assertThat(constantGenerator.generateNumber()).isEqualTo(3);
    }
}