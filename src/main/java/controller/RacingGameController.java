package controller;

import domain.RacingCar;
import domain.RacingCars;
import domain.TryCount;
import java.util.List;
import java.util.stream.Collectors;
import util.CommaSeparator;
import view.InputView;

public class RacingGameController {

    private RacingCars racingCars;
    private TryCount tryCount;

    void start(){
       setUpGame();
    }

    void setUpGame(){
        racingCars = createRacingCar();
        tryCount = getTryCount();
    }

    private RacingCars createRacingCar(){
        List<String> names = CommaSeparator.sliceNameByComma(getNames());
        return new RacingCars(createRacingCar(names));
    }

    private String getNames() {
        return InputView.requestCarName();
    }

    private List<RacingCar> createRacingCar(List<String> names) {
        return names.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private TryCount getTryCount(){
        return new TryCount(InputView.requestTryCount());
    }
}
