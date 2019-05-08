package Calculator;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println("숫자를 입력해 주세요: ");
        String userInput = cal.readInput();
        List<String> numbers = new ArrayList<>();
        numbers = Arrays.asList(userInput.split(" "));

    }

    public String readInput() {
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();
        return userInput;
    }

    public List<Integer> extractNumbers(List<String> numbers) {
        List<Integer> listOfNumbers= new ArrayList<>();
        for (int i=0; i<numbers.size(); i += 2) {
            int number = Integer.parseInt(numbers.get(i));
            listOfNumbers.add(number);
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
