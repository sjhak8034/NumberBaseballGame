package UserInput;

import Exceptions.DuplicateNumberException;
import Exceptions.NotNumberException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String input = "";
    private String Try = "";
    private final String numberRegLev = "[3-5]";

    private final String numberRegMode = "[1-3]";
    public void checkLevelException(String input) {


        Pattern pattern = Pattern.compile(numberRegLev);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            this.input = input;
        } else {
            throw new NotNumberException(input, 3, 5);
        }

    }


    public void checkUserTryException(String userTry, int level) {
        String numberRegTry = "^(?!.*(.).*\\1)[1-9]{" + level + "}$";


        Pattern pattern = Pattern.compile(numberRegTry);
        Matcher matcher = pattern.matcher(userTry);

        if (matcher.matches()) {
            this.input = userTry;
        } else {
            throw new DuplicateNumberException();
        }


    }

    public void checkModeException(String input) {


        Pattern pattern = Pattern.compile(numberRegMode);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            this.input = input;
        } else {
            throw new NotNumberException(input, 1, 3);
        }

    }


}


