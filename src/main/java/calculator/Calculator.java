package calculator;

import exceptionsCalculator.CalculatorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static void main(String[] args) {
        doCalculate();
    }

    public static void doCalculate() {
        String userInput = CalculatorException.readAndReceiveInput();
        List<String> numbers = new ArrayList<>(Arrays.asList(userInput.split(" ")));
        List<Integer> numberList = extractNumbers(numbers);
        List<String> symbolList = extractSymbols(numbers);
        System.out.println(calculate(numberList, symbolList));
    }

    public static List<Integer> extractNumbers(List<String> numbers) {
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i += 2) {
            int number = CalculatorException.extractNumbersException(numbers.get(i));
            listOfNumbers.add(number);
        }
        return listOfNumbers;
    }

    public static List<String> extractSymbols(List<String> symbols) {
        List<String> listOfSymbols = new ArrayList<>();
        for (int i = 1; i < symbols.size(); i += 2) {
            listOfSymbols.add(symbols.get(i));
        }
        return listOfSymbols;
    }

    public static int calculate(List<Integer> listOfNumbers, List<String> listOfSymbols) {
        int result = listOfNumbers.get(0);
        for (int i = 0; i < listOfSymbols.size(); i++) {
            result = Calculate.RESULT.getCalculateResult(result, listOfNumbers.get(i + 1), listOfSymbols.get(i));
        }
        return result;
    }
}
