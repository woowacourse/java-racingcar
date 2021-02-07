package racingcar.domain.dto;

public class GameManagerRequestDto {
    private String carNames;
    private String round;

    public GameManagerRequestDto(String carNames, String round) {
        this.carNames = carNames;
        this.round = round;
    }

    public String getCarNames() {
        return this.carNames;
    }

    public String getRound() {
        return this.round;
    }
}
