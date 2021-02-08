package racingcar.domain.dto;

public class GameManagerRequestDto {
    private final String carNames;
    private final int round;

    public GameManagerRequestDto(String carNames, int round) {
        this.carNames = carNames;
        this.round = round;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRound() {
        return round;
    }
}
