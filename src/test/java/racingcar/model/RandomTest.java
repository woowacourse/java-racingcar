package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class RandomTest {

    @Test
    void 랜덤수가_0부터_9까지인지_검사() {
        for (int i = 0; i < 100; i++) {
            int random = Random.createRandomNumber();
            assertThat(random).isLessThan(10);
            assertThat(random).isGreaterThanOrEqualTo(0);
        }
    }

}
