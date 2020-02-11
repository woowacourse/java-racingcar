package stringAdder;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    private String input;

    public Input(){
        this.input = InputView.inputValue();
    }

    public Input(String value){
        this.input = value;
    }

    private boolean isInputEmpty(){
        return input == null || input.isEmpty();

    }

    private String getDelimiter(){
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if(m.find()){
            input = m.group(2);
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    public List<String> splitInput() {
        try {
            String delimiter = getDelimiter();
            List<String> list = Arrays.asList(input.split(delimiter));

            if(isInputEmpty() || list.isEmpty()){
                return null;
            }

            return list;
        } catch(NullPointerException e){
            return null;
        }
    }

}
