import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRacingRuleTest {
    @Test
    void getRandomNumber() {
        assertThat((0 <= CarRacingRule.getRandomNumber())
                && (CarRacingRule.getRandomNumber() <= 9)).isTrue();
    }
}
