package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.Game;

public class GameTest {

    @Test
    void isEnd_시도횟수_남아있을시_false_반환() {

        Game game = new Game("love,happy", "3");

        game.race();

        assertThat(game.isEnd()).isEqualTo(false);

    }

    @Test
    void isEnd_시도횟수_끝났을시_true_반환() {

        Game game = new Game("love,happy", "1");

        game.race();

        assertThat(game.isEnd()).isEqualTo(true);

    }

    @Test
    void tryNo_숫자_아닐시_예외발생() {

        assertThatThrownBy(() ->
            new Game("love,happy", "헉")
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void tryNo_숫자인경우_Game_생성_성공() {

        assertThatCode(() ->
            new Game("love,happy", "3")
        ).doesNotThrowAnyException();

    }

    @Test
    void 시도횟수_입력_자연수_아닐시_예외() {

        assertThatThrownBy(() ->
            new Game("love,happy", "-1")
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void carName_쉼표로_구분_성공() {

        Game game = new Game("love,happy", "3");

        assertThat(
            game.getCars())
            .extracting("name")
            .containsExactly("love", "happy");

    }

}
