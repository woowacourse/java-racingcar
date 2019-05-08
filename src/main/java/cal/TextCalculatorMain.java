package cal;

public class TextCalculatorMain {
    public static void main(String[] args) {
        TextCalculator textCalculator = new TextCalculator();
        try {
            textCalculator.run();
        }catch (Exception e){
            e.printStackTrace();
            textCalculator.run();
        }
    }
}
