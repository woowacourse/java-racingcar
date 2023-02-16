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
import view.output.OutputView;

class GameTest {

    private Game game;
    private InputView inputView;
    private OutputView outputView;
    private ByteArrayOutputStream outputMessage;

    @BeforeEach
    void before() {
        game = new Game(new RaceController());
        outputView = new OutputView();
    }

    void setInputStream(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView = new InputView();
    }

    void setOutput() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @DisplayName("제대로 된 입력이 올때까지 입력을 받고 게임을 진행한다.")
    @Test
    void input_empty() {
        //given
        Game game = new Game(new RaceController());
        setInputStream("\n     \nspli-\nsplitt\n  split    \n3");
        setOutput();
        game.ready(new InputView());
        NumberGenerator numberGenerator = () -> 4;
        game.playGame(numberGenerator, outputView);
        game.showResult(outputView);
        //then
        Assertions.assertThat(outputMessage.toString()).isEqualTo(
            "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n"
                + "1에서 5사이의 길이의 자동차 이름으로 다시 입력해주세요\n"
                + "1에서 5사이의 길이의 자동차 이름으로 다시 입력해주세요\n"
                + "이름에는 - 를 포함시킬 수 없습니다. 다시 입력해주세요\n"
                + "1에서 5사이의 길이의 자동차 이름으로 다시 입력해주세요\n"
                + "시도할 회수는 몇회인가요?\n"
                + "split : -\n\n"
                + "split : --\n\n"
                + "split : ---\n\n"
                + "split : ---\n\n"
                + "실행 결과\n"
                + "split가 최종 우승했습니다.\n"
        );
    }

    @DisplayName("아무도 전진하지 못하는 상태로 게임을 할 때.")
    @Test
    void race_one_round_not_move() {
        //given
        setInputStream("split\n2");
        setOutput();
        game.ready(new InputView());
        NumberGenerator numberGenerator = () -> 3;
        game.playGame(numberGenerator, outputView);
        game.showResult(outputView);
        //then
        Assertions.assertThat(outputMessage.toString()).isEqualTo(
            "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n"
                + "시도할 회수는 몇회인가요?\n"
                + "split : \n\n"
                + "split : \n\n"
                + "split : \n\n"
                + "실행 결과\n"
                + "split가 최종 우승했습니다.\n"
        );
    }

    @DisplayName("항상 전진하는 상태로 게임을 할 때")
    @Test
    void race_one_round_move() {
        //given
        setInputStream("split\n2");
        setOutput();
        game.ready(new InputView());
        NumberGenerator numberGenerator = () -> 4;
        game.playGame(numberGenerator, outputView);
        game.showResult(outputView);
        //then
        Assertions.assertThat(outputMessage.toString()).isEqualTo(
            "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n"
                + "시도할 회수는 몇회인가요?\n"
                + "split : -\n\n"
                + "split : --\n\n"
                + "split : --\n\n"
                + "실행 결과\n"
                + "split가 최종 우승했습니다.\n"
        );
    }
}
