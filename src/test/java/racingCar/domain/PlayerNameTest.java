package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerNameTest {
    PlayerName playerName;

    @Test
    void nameLengthZero() {
        String nameLengthZero = "";
        Assertions.assertThatThrownBy(
                () -> {
                    new PlayerName(nameLengthZero);
                }
        );
    }

    @Test
    void nameLengthLargerThanFive() {
        String nameLengthLargerThanFive = "oversi";
        Assertions.assertThatThrownBy(
                () -> {
                    new PlayerName(nameLengthLargerThanFive);
                }
        );
    }

    @Test
    void checkValidName() {
        String validName = "asdf";
        Assertions.assertThat(new GameManager(validName).isCreated()).isTrue();
    }

    @Test
    void duplicateName() {
        String duplicateNameString = "over,over,pobi";
        String validString = "over,pobi";
        Assertions.assertThat(new GameManager(duplicateNameString).isCreated()).isFalse();
        //Assertions.assertThat(new GameManager(validString).isCreated()).isTrue();
    }
}
