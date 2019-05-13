package racinggame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class RacingGameTest {
	RacingGame racingGameMove;
	RacingGame racingGameStop;
	List<String> carNames;
	RacingGameMovingStrategy racingGameMovingStrategyMove;
	RacingGameMovingStrategy racingGameMovingStrategyStop;

	@BeforeEach
	void setup() {
		racingGameMovingStrategyMove = new SelectableRacingGameMovingStrategy(3, 4);
		racingGameMovingStrategyStop = new SelectableRacingGameMovingStrategy(4, 4);
		carNames = new ArrayList<String>();
		carNames.add("bmo");
		racingGameMove = new RacingGame(carNames.stream().toArray(String[]::new), racingGameMovingStrategyMove);
		racingGameStop = new RacingGame(carNames.stream().toArray(String[]::new), racingGameMovingStrategyStop);
	}

	@Test
	void 생성() {
		String[] names1 = { "amo" };
		RacingGame racingGame1 = new RacingGame(names1, racingGameMovingStrategyMove);
		assertThat(racingGameMove).isNotEqualTo(racingGame1);

		String[] names2 = { "bmo" };
		RacingGame racingGame2 = new RacingGame(names2, racingGameMovingStrategyMove);
		assertThat(racingGameMove).isEqualTo(racingGame2);
	}

	@Test
	void play() {
		assertThat(racingGameMove).isEqualTo(racingGameStop);
		assertThat(racingGameMove.playOneRound()).isNotEqualTo(racingGameStop.playOneRound());

		racingGameMove.playOneRound();
		racingGameMove.playOneRound();

		RacingGame comparingRacingGameMove =
				new RacingGame(carNames.stream().toArray(String[]::new), racingGameMovingStrategyMove);

		comparingRacingGameMove.playOneRound();
		comparingRacingGameMove.playOneRound();
		comparingRacingGameMove.playOneRound();

		assertThat(racingGameMove).isEqualTo(comparingRacingGameMove);
	}

	@AfterEach
	void tearDown() {
		racingGameMove = null;
		racingGameStop = null;
		carNames = null;
		racingGameMovingStrategyMove = null;
		racingGameMovingStrategyStop = null;
	}
}
