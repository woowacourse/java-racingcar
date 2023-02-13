package controller;

import exception.ApplicationRuntimeException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import view.OutputView;

public class RaceControllerHandler implements InvocationHandler {

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
            outputView.printExceptionMessage(exception.getCause().getMessage());
            return this.invoke(proxy, method, args);
        } catch (RuntimeException e) {
            throw new ApplicationRuntimeException();
        }
    }
}
