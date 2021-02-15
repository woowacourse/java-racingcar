package racingcar.dto;

public class CarDto {
    private final NameDto nameDto;
    private final PositionDto positionDto;

    public CarDto(final NameDto nameDto, final PositionDto positionDto) {
        this.nameDto = nameDto;
        this.positionDto = positionDto;
    }

    public NameDto getNameDto() {
        return nameDto;
    }

    public PositionDto getPositionDto() {
        return positionDto;
    }
}
