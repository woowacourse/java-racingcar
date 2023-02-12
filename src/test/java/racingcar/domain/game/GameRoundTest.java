package racingcar.domain.game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("게임 랴운드 ")
class GameRoundTest {

	@DisplayName("생성 성공 테스트")
	@ParameterizedTest(name = "totalRound = {0}")
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void createGameRoundSuccessTest(int totalRound) {
		GameRound gameRound = new GameRound(totalRound);
		assertThat(gameRound).isNotNull();
	}

	@DisplayName("종료 성공 테스트")
	@ParameterizedTest(name = "totalRound = {0}, executeTime = {1}, expectedIsEnd = {2}")
	@CsvSource(value = {"1:1:true", "2:2:true", "10:1:false"}, delimiterString = ":")
	void isEndRoundTest(int totalRound, int executeTimes, boolean expectedIsEnd) {
		GameRound gameRound = new GameRound(totalRound);
		for (int count = 0; count < executeTimes; count++) {
			gameRound.nextRound();
		}
		assertThat(gameRound.isEnd()).isEqualTo(expectedIsEnd);
	}
}