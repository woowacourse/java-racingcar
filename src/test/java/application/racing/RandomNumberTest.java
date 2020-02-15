package application.racing;

import application.racing.domain.RandomNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {
    @DisplayName("RandomNumber 생성자 테스트")
    @Test
    public void randomNumberConstructorTest() {
        RandomNumber randomNumber = new RandomNumber();
        Assertions.assertThat(randomNumber.getRandomNumber()).isBetween(0, 9);
    }
}
