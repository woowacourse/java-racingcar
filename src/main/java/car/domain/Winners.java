package car.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final Game game;
    private List<CarDto> winners;
    private final int maxPosition;
    public Winners(Game game){
        this.game = game;
        this.maxPosition = game.findMaxPosition();
    }
    public void findWinners(){
        winners = game.getCarsDto().stream()
                .filter(car->car.getPosition()==maxPosition)
                .collect(Collectors.toList());
    }
    public List<CarDto> getWinners(){
        return this.winners;
    }
}
