package operation;

public class Operation {

    public double calculate(String predictor){
        String[] predictorIndex = predictor.trim().split(" ");
        double result =isNumber(predictorIndex[0]);

        for (int i = 1; i < predictorIndex.length ; i+=2) {
            double number = isNumber(predictorIndex[i+1]);
            String operator = predictorIndex[i];
            result = Operator.doCalculator(operator, result, number);
        }

        return result;
    }

    private static double isNumber(String index){
        try{
            return Double.parseDouble(index);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("적절한 값이 아닙니다.");
        } catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("다항식의 순서가 부적절 합니다.");
        }
    }

}
