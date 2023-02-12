package racingcar.dto;

public class CarNamesRequestDTO {
    private final String carNames;

    public CarNamesRequestDTO(String carNames) {
        this.carNames = carNames;
    }

    public String getCarNames() {
        return carNames;
    }

}
