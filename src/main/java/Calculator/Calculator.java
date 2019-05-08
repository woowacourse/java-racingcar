package Calculator;


import Exceptions.CalculatorException;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        doCalculate();
    }

    public static void doCalculate() {
        Calculator cal = new Calculator();
        String userInput = CalculatorException.readAndReceiveInput();
        List<String> numbers = Arrays.asList(userInput.split(" "));
        List<Integer> numberList = cal.extractNumbers(numbers);
        List<String> symbolList = cal.extractSymbols(numbers);
        System.out.println(cal.calculate(numberList, symbolList));

    }

    public List<Integer> extractNumbers(List<String> numbers) {
        List<Integer> listOfNumbers= new ArrayList<>();
        for (int i=0; i<numbers.size(); i += 2) {
            try{
                int number = Integer.parseInt(numbers.get(i));
                listOfNumbers.add(number);
            }catch (Exception e){
                doCalculate();
            }
        }
        return listOfNumbers;
    }

    public List<String> extractSymbols(List<String> symbols){
        List<String> listOfSymbols = new ArrayList<>();
        for(int i=1; i<symbols.size(); i += 2){
            listOfSymbols.add(symbols.get(i));
        }
        return listOfSymbols;
    }

    public int calculate(List<Integer>listOfNumbers, List<String>listOfSymbols) {
        int result = listOfNumbers.get(0);
        for (int i=0; i<listOfSymbols.size(); i++) {
            result = innerCalculate(result, listOfNumbers.get(i+1), listOfSymbols.get(i));
        }
        return result;
    }

    public int innerCalculate(int result, int number, String symbol) {
        if (symbol.equals("+")) {
            return result + number;
        }
        if (symbol.equals("-")) {
            return result - number;
        }
        if (symbol.equals("/")) {
            return result/number;
        }
        if (symbol.equals("*")) {
            return result*number;
        }
        return -1;
    }




}
