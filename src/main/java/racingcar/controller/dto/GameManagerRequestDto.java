package racingcar.controller.dto;

public class GameManagerRequestDto {
    private final String carNames;
    private final String round;

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
