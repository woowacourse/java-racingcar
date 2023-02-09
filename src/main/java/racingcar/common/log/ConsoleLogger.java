package racingcar.common.log;

public class ConsoleLogger implements Logger {

    @Override
    public void error(final String message) {
        System.out.println(message);
    }
}
