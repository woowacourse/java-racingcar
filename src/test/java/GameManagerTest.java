import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class GameManagerTest {
    GameManager gameManager;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @ParameterizedTest
    @CsvSource(value = {"5:true", "2:false" }, delimiter = ':')
    void judgement(int randomNumber, boolean result) {
        assertThat(gameManager.judgement(randomNumber)).isEqualTo(result);
    }

}