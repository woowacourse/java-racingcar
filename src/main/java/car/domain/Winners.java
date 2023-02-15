package car.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public List<CarDto> findWinners(GameDto gameDto){
        return gameDto.getCars().stream()
                .filter(car->car.getPosition()== gameDto.getMaxPosition())
                .collect(Collectors.toList());
    }
}
