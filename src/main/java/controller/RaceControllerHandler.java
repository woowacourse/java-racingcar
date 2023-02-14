package controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import view.OutputView;

public class RaceControllerHandler implements InvocationHandler {

    private static final String APPLICATION_EXCEPTION_MESSAGE = "애플리케이션에 문제가 발생했습니다.";

    private final RaceController raceController;
    private final OutputView outputView;

    public RaceControllerHandler(RaceController raceController, OutputView outputView) {
        this.raceController = raceController;
        this.outputView = outputView;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(raceController, args);
        } catch (InvocationTargetException exception) {
            Object[] flowArgs = processApplicationFlow(exception.getCause(), args);

            return this.invoke(proxy, method, flowArgs);
        }
    }

    private Object[] processApplicationFlow(Throwable throwable, Object[] args) {
        if (isUserException(throwable)) {
            outputView.printExceptionMessage(throwable.getMessage());
            return args;
        }
        outputView.printExceptionMessage(APPLICATION_EXCEPTION_MESSAGE);
        return new Object[] {RaceState.APPLICATION_EXCEPTION};
    }

    private boolean isUserException(Throwable throwable) {
        return throwable instanceof IllegalArgumentException;
    }
}
