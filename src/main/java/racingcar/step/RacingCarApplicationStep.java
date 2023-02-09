package racingcar.step;

import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.step.context.GameContext;

import static java.lang.String.format;

public abstract class RacingCarApplicationStep implements Step {

    private static final int MAX_RETRY_COUNT = 3;
    protected final Logger log;
    protected final RacingCarController controller;
    protected final GameContext context;

    @Override
    public Step execute() {
        int retryCount = 0;
        while (retryCount < MAX_RETRY_COUNT) {
            try {
                return pureExecute();
            } catch (IllegalArgumentException e) {
                log.error(e.getMessage());
            }
            retryCount++;
        }
        log.error(format("잘못된 입력이 %d번 이상 입력되어 프로그램을 종료합니다.", MAX_RETRY_COUNT));
        throw new IllegalStateException();
    }

    protected abstract Step pureExecute();

    protected RacingCarApplicationStep(final RacingCarController controller,
                                       final Logger log,
                                       final GameContext context) {
        this.controller = controller;
        this.log = log;
        this.context = context;
    }
}
