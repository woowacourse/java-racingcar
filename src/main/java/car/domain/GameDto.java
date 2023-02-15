package car.domain;

import java.util.List;

public class GameDto {
    private final List<CarDto> cars;
    private final int maxPosition;
    public GameDto(Game game){
        this.cars = game.getCarsDto();
        this.maxPosition = game.findMaxPosition();
    }
    public List<CarDto> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

}
