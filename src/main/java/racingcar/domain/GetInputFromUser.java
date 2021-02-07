package racingcar.domain;

import java.util.List;
import java.util.Scanner;
import racingcar.input.utils.carname.CarNamesInputFromUser;
import racingcar.input.utils.racingtrytime.RacingTryTimeInputFromUser;

public class GetInputFromUser {
    private final CarNamesInputFromUser carNamesInputFromUser;
    private final RacingTryTimeInputFromUser racingTryTimeInputFromUser;

    public GetInputFromUser(Scanner scanner) {
        this.carNamesInputFromUser = new CarNamesInputFromUser(scanner);
        this.racingTryTimeInputFromUser = new RacingTryTimeInputFromUser(scanner);
    }

    public List<String> getInputCarNamesFromUser() {
        return carNamesInputFromUser.getAllCarNames();
    }

    public int getInputRacingTryTimeFromUser() {
        return racingTryTimeInputFromUser.getRacingTryTime();
    }
}
