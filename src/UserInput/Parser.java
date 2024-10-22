package UserInput;

import Exceptions.DuplicationNumberException;
import Exceptions.NotNumberException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String input = "";
    private String Try = "";

    // level 판별
    public void checkLevelException(String input) {
        // 들어온 input이 숫자인지 아닌지 판단하고 아닐경우 Exception throw
        String numberRegLev = "[3-5]";
        Pattern pattern = Pattern.compile(numberRegLev);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            this.input = input;
        } else {
            throw new NotNumberException(input, 3, 5);
        }

    }

    // user 시도 판별
    public void checkUserTryException(String userTry, int level) {

        String numberRegTry = "^(?!.*(.).*\\1)[1-9]{" + level + "}$";

        Pattern pattern = Pattern.compile(numberRegTry);
        Matcher matcher = pattern.matcher(userTry);

        if (matcher.matches()) {
            this.input = userTry;
        } else {
            throw new DuplicationNumberException();
        }


    }

    public void checkModeException(String input) {
        // 들어온 input이 숫자인지 아닌지 판단하고 아닐경우 Exception throw
        String numberRegLev = "[1-3]";
        Pattern pattern = Pattern.compile(numberRegLev);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            this.input = input;
        } else {
            throw new NotNumberException(input, 1, 3);
        }

    }


}


