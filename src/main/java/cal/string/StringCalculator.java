package cal.string;

public class StringCalculator {


    public int calculate(String inputString) {
        String[] parsedStrings =  inputString.split(" ");
          return arrayCalculate(parsedStrings);
    }

    public int arrayCalculate(String[] parsedStrings){
        int result, op;
        op = Operation.getOperator(parsedStrings[1]);
        result = Integer.parseInt(parsedStrings[0]);
        for (int i=1; i<parsedStrings.length; i+=2) {
            op = Operation.getOperator(parsedStrings[i]);
            result = Operation.makeFormular(result, Integer.parseInt(parsedStrings[i+1]), op);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
