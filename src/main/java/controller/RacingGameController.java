package controller;

import domain.Cars;
import domain.GameProcess;
import domain.Name;
import domain.RacingGame;
import dto.input.ReadCarNamesDto;
import dto.input.ReadTryCountDto;
import dto.output.PrintCriticalExceptionDto;
import dto.output.PrintExceptionDto;
import dto.output.PrintMovingStatusDto;
import dto.output.PrintWinnersDto;
import utils.MovingStrategy;
import view.IOViewResolver;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class RacingGameController {
    private final IOViewResolver ioViewResolver;
    private final Map<GameProcess, Supplier<GameProcess>> processMap;

    private RacingGame racingGame;
    private List<Name> carNames;

    public RacingGameController(IOViewResolver ioViewResolver, MovingStrategy strategy) {
        this.ioViewResolver = ioViewResolver;
        this.processMap = new EnumMap<>(GameProcess.class);
        initProcessMap(strategy);
    }

    private void initProcessMap(MovingStrategy strategy) {
        processMap.put(GameProcess.READ_CAR_NAMES, this::readCarNames);
        processMap.put(GameProcess.READ_TRY_COUNT, this::readTryCount);
        processMap.put(GameProcess.START_RACE, () -> this.startRace(strategy));
        processMap.put(GameProcess.PRINT_WINNERS, this::printWinners);
    }

    public GameProcess run(GameProcess process) {
        try {
            return processMap.get(process).get();
        } catch (IllegalArgumentException exception) {
            ioViewResolver.outputViewResolve(new PrintExceptionDto(exception));
            return process;
        } catch (Exception exception) {
            ioViewResolver.outputViewResolve(new PrintCriticalExceptionDto(exception));
            return GameProcess.EXIT;
        }
    }

    private GameProcess readCarNames() {
        ReadCarNamesDto readCarNamesDto = ioViewResolver.inputViewResolve(ReadCarNamesDto.class);

        this.carNames = readCarNamesDto.getCarNames()
                .stream()
                .map(Name::of)
                .collect(Collectors.toUnmodifiableList());

        return GameProcess.READ_TRY_COUNT;
    }

    private GameProcess readTryCount() {
        ReadTryCountDto readTryCountDto = ioViewResolver.inputViewResolve(ReadTryCountDto.class);

        racingGame = new RacingGame(carNames, readTryCountDto.getTryCount());

        return GameProcess.START_RACE;
    }

    private GameProcess startRace(MovingStrategy strategy) {
        List<Cars> movingStatus = racingGame.start(strategy);
        ioViewResolver.outputViewResolve(new PrintMovingStatusDto(movingStatus));

        return GameProcess.PRINT_WINNERS;
    }

    private GameProcess printWinners() {

        ioViewResolver.outputViewResolve(new PrintWinnersDto(racingGame.decideWinners()));

        return GameProcess.EXIT;
    }
}
