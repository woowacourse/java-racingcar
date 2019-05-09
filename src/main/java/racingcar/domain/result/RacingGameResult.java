package racingcar.domain.result;

import java.util.List;

public class RacingGameResult {
    private final List<RacingGameRound> gameResultDB;

    public RacingGameResult(List<RacingGameRound> gameResultDB) {
        this.gameResultDB = gameResultDB;
    }

    public List<RacingGameRound> getGameResultDB() {
        return this.gameResultDB;
    }

    // TODO : winner list 추출을 위한 maxPosition 구하는 메소드

    // TODO : maxPosition을 이용하여 winner list를 반환하는 메소드

}
