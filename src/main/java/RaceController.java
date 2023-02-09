import domain.Car;
import domain.CarDTO;
import domain.Race;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class RaceController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<String> carNames = inputView.readCarNames();
        Race race = new Race(carNames);
        int tryTime = readValidTryTime();

        while (tryTime-- > 0) {
            race.tryMoveOneTime();
            List<CarDTO> carDTOs = race.getCarDTOs();
            outputView.printStatus(carDTOs);
        }

        List<String> winnerNames = race.judgeWinners().stream().map(Car::toString).collect(Collectors.toList());
        outputView.printWinners(winnerNames);
    }

    private int readValidTryTime() {
        int tryTime = inputView.readTryTime();
        if(tryTime < 0){
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
        return tryTime;
    }
}
