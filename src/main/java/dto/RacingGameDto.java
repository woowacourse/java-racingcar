package dto;

import java.util.ArrayList;
import java.util.List;

public class RacingGameDto {
    private List<CarsDto> carsDtosFromFirstTrial;
    private CarsDto winningCarsDto;

    public RacingGameDto() {
        this.carsDtosFromFirstTrial = new ArrayList<>();
        this.winningCarsDto = CarsDto.EMPTY;
    }

    public static RacingGameDto create() {
        return new RacingGameDto();
    }

    public List<CarsDto> getCarsDtosFromFirstTrial() {
        return carsDtosFromFirstTrial;
    }

    public CarsDto getWinningCarsDto() {
        return winningCarsDto;
    }

    public void setWinningCarsDto(CarsDto winningCarsDto) {
        this.winningCarsDto = winningCarsDto;
    }

    public void addCarsDto(CarsDto carsDto) {
        this.carsDtosFromFirstTrial.add(carsDto);
    }
}
