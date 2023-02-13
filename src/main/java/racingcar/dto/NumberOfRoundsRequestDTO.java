package racingcar.dto;

public class NumberOfRoundsRequestDTO {
    private final int numberOfRounds;

    public NumberOfRoundsRequestDTO(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

}
