package racingcar.config;

import racingcar.service.RacingCarService;

public class ServiceConfig {

    public static RacingCarService getRacingCarService() {
        return new RacingCarService();
    }
}
