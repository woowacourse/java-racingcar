package view;

import dto.CarNameRequest;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private final Reader reader;
    private final Printer printer;
    private final InputValidater inputValidater;

    public InputView(Reader reader, Printer printer, InputValidater inputValidater) {
        this.reader = reader;
        this.printer = printer;
        this.inputValidater = inputValidater;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer, new InputValidater());
    }

    public CarNameRequest readCars() {
        printer.printLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = reader.readLineWithTrim();
        inputValidater.validateCars(input);
        return new CarNameRequest(Arrays.asList(input.split(",")));
    }

    public int readCount() {
        printer.printLine(("시도할 회수는 몇회인가요?");
        String input = reader.readLineWithTrim();
        inputValidater.validateCount(input);
        return Integer.parseInt(input);
    }
}
