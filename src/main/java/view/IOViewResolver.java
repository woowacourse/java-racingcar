package view;

import dto.input.ReadCarNamesDto;
import dto.input.ReadTryCountDto;
import dto.output.PrintCriticalExceptionDto;
import dto.output.PrintExceptionDto;
import dto.output.PrintWinnersDto;
import view.exception.NotFoundViewException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class IOViewResolver {

    private final Map<Class<?>, Supplier<Object>> inputViewMap;
    private final Map<Class<?>, Consumer<Object>> outputViewMap;

    public IOViewResolver(InputView inputView, OutputView outputView) {
        inputViewMap = new HashMap<>();
        outputViewMap = new HashMap<>();
        initInputViewMappings(inputView);
        initOutputViewMappings(outputView);
    }

    private void initInputViewMappings(InputView inputView) {
        inputViewMap.put(ReadCarNamesDto.class, inputView::readCarNames);
        inputViewMap.put(ReadTryCountDto.class, inputView::readTryCount);
    }

    private void initOutputViewMappings(OutputView outputView) {
        outputViewMap.put(PrintWinnersDto.class, dto -> outputView.printWinners((PrintWinnersDto) dto));
        outputViewMap.put(PrintExceptionDto.class, dto -> outputView.printException((PrintExceptionDto) dto));
        outputViewMap.put(PrintCriticalExceptionDto.class, dto -> outputView.printCriticalException((PrintCriticalExceptionDto) dto));
    }

    public <T> T inputViewResolve(final Class<T> type) {
        try {
            return type.cast(inputViewMap.get(type).get());
        } catch (NullPointerException e) {
            throw new NotFoundViewException();
        }
    }

    public void outputViewResolve(final Object dto) {
        try {
            outputViewMap.get(dto.getClass()).accept(dto);
        } catch (NullPointerException e) {
            throw new NotFoundViewException();
        }
    }
}
