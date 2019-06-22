package dto;

import java.util.ArrayList;
import java.util.List;

public class RacingGameDto {
    private List<CarsDto> carsDtosFromFirstTrial;
    private CarsDto winningCarsDto;

    public RacingGameDto() {
        this(new ArrayList<>(), CarsDto.EMPTY);
    }

    private RacingGameDto(List<CarsDto> carsDtosFromFirstTrial, CarsDto winningCarsDto) {
        this.carsDtosFromFirstTrial = carsDtosFromFirstTrial;
        this.winningCarsDto = winningCarsDto;
    }

    public static RacingGameDto create() {
        return new RacingGameDto();
    }

    public static RacingGameDto of(List<CarsDto> carsDtosFromFirstTrial, CarsDto winningCarsDto) {
        return new RacingGameDto(carsDtosFromFirstTrial, winningCarsDto);
    }

    public List<CarsDto> getCarsDtosFromFirstTrial() {
        return carsDtosFromFirstTrial;
    }

    public CarsDto getWinningCarsDto() {
        return winningCarsDto;
    }

    public void setCarsDtosFromFirstTrial(List<CarsDto> carsDtosFromFirstTrial) {
        this.carsDtosFromFirstTrial = carsDtosFromFirstTrial;
    }

    public void setWinningCarsDto(CarsDto winningCarsDto) {
        this.winningCarsDto = winningCarsDto;
    }

    public void addCarsDto(CarsDto carsDto) {
        this.carsDtosFromFirstTrial.add(carsDto);
    }
}
