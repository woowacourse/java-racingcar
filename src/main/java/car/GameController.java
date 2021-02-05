package car;

import car.domain.Cars;
import car.domain.Round;
import car.domain.ScoreBoard;
import car.view.InputView;
import car.view.OutputView;

public class GameController {
    
    private final InputView inputView;
    
    private final OutputView outputView;
    
    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
    
    public void run() {
        race(setCars(), setRound());
    }
    
    private Cars setCars() {
        return Cars.from(inputView.readCarNames());
    }
    
    private int setRound() {
        return Round.from(inputView.readRound())
                    .getRound();
    }
    
    private void race(Cars cars, int round) {
        ScoreBoard scoreBoard = null;
        
        outputView.printResultTitle();
        
        for (int i = 0; i < round; i++) {
            scoreBoard = cars.race()
                             .recordScore();
            
            outputView.printRoundResult(scoreBoard);
        }
        
        outputView.printWinners(scoreBoard);
    }
}
