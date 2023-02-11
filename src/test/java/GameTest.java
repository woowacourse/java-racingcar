import controller.RaceController;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;
import view.input.InputView;

class GameTest {

    private Game game;
    private InputView inputView;
    private ByteArrayOutputStream outputMessage;

    @BeforeEach
    void before() {
        game = new Game(new RaceController());
    }

    void setInputStream(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView = new InputView();
    }

    void setOutput() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @DisplayName("아무도 전진하지 못하는 상태로 게임을 할 때.")
    @Test
    void race_one_round_not_move() {
        //given
        setInputStream("split\n3");
        setOutput();
        game.ready(new InputView());
        NumberGenerator numberGenerator = () -> 3;
        game.playGame(numberGenerator);
        //then
        Assertions.assertThat(outputMessage.toString()).contains("split : ");
    }

    @DisplayName("항상 전진하는 상태로 게임을 할 때")
    @Test
    void race_one_round_move() {
        //given
        setInputStream("split\n3");
        setOutput();
        game.ready(new InputView());
        NumberGenerator numberGenerator = () -> 4;
        game.playGame(numberGenerator);
        //then
        Assertions.assertThat(outputMessage.toString()).contains("split : ---");
    }

    @DisplayName("게임플레이가 잘 되는가")
    @Test
    void playGame() {
        //given
        Game game = new Game(new RaceController());
        setInputStream("split\n3");
        setOutput();
        game.ready(new InputView());
        NumberGenerator numberGenerator = () -> 4;
        game.playGame(numberGenerator);
        game.showResult();
        //then
        Assertions.assertThat(outputMessage.toString()).contains(
            "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
            "시도할 회수는 몇회인가요?",
            "split : ---",
            "실행 결과",
            "split가 최종 우승했습니다."
        );
    }
}
