package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

//    private static final String CAR_1_NAME = "pobi";
//    private static final String CAR_2_NAME = "jason";
//
//    private RacingGame racingGame;
//    private List<String> names;
//
//    @BeforeEach
//    public void setUp() {
//        names = List.of(CAR_1_NAME, CAR_2_NAME);
//    }
//
//    @Test
//    public void 시도횟수만큼_게임진행() {
//        racingGame = new RacingGame(names, 2, new MockRandomNumberGenerator());
//        assertThat(racingGame.isFinished()).isFalse();
//        racingGame.proceedTurn();
//        racingGame.proceedTurn();
//        assertThat(racingGame.isFinished()).isTrue();
//    }
//
//    @Test
//    public void 시도횟수_이상으로_게임_진행시_예외_발생() {
//        racingGame = new RacingGame(names, 1, new MockRandomNumberGenerator());
//        racingGame.proceedTurn();
//        assertThatThrownBy(() -> racingGame.proceedTurn())
//                .isInstanceOf(RacingGameIsFinishedException.class);
//    }
//
//    @Test
//    public void 중간_실행결과_반환() {
//        racingGame = new RacingGame(names, 1, new MockRandomNumberGenerator());
//        racingGame.proceedTurn();
//        GameLog result = racingGame.getMidtermResult();
//        assertThat(result.getPositionByName(CAR_1_NAME)).isEqualTo(1);
//        assertThat(result.getPositionByName(CAR_2_NAME)).isEqualTo(0);
//    }
//
//    @Test
//    public void 단독우승자_조회() {
//        racingGame = new RacingGame(names, 3, new MockRandomNumberGenerator());
//        racingGame.proceedTurn();
//        racingGame.proceedTurn();
//        racingGame.proceedTurn();
//        assertThat(racingGame.getWinnersResult().getWinnerNames()).contains(CAR_1_NAME);
//    }
//
//    @Test
//    public void 공동우승자_조회() {
//        racingGame = new RacingGame(names, 4, new MockRandomNumberGenerator());
//        racingGame.proceedTurn();
//        racingGame.proceedTurn();
//        racingGame.proceedTurn();
//        racingGame.proceedTurn();
//        assertThat(racingGame.getWinnersResult().getWinnerNames()).contains(CAR_1_NAME, CAR_2_NAME);
//    }
//
//    @Test
//    public void 게임_종료전에_우승자_반환시_예외_발생() {
//        racingGame = new RacingGame(names, 1, new MockRandomNumberGenerator());
//        assertThatThrownBy(() -> racingGame.getWinnersResult())
//                .isInstanceOf(GetWinnersBeforeFinishException.class);
//    }
}
