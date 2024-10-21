package GameV1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exceptions.DuplicationNumber;
import Exceptions.NotNumber;

public class Parser {
    private String input = "";
    private String Try = "";

    // level 판별
    public void isLevel(String input) {
        // 들어온 input이 숫자인지 아닌지 판단하고 아닐경우 Exception throw
        String numberRegLev = "[3-5]";
        Pattern pattern = Pattern.compile(numberRegLev);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            this.input = input;
        } else {
            throw new NotNumber(input, 3, 5);
        }

    }

    // user 시도 판별
    public void isTry(String Try, int level) {

        String numberRegTry = "^(?!.*(.).*\\1)[1-9]{" + level + "}$";

        Pattern pattern = Pattern.compile(numberRegTry);
        Matcher matcher = pattern.matcher(Try);

        if (matcher.matches()) {
            this.input = Try;
        } else {
            throw new DuplicationNumber();
        }


    }

    public void isMode(String input) {
        // 들어온 input이 숫자인지 아닌지 판단하고 아닐경우 Exception throw
        String numberRegLev = "[1-3]";
        Pattern pattern = Pattern.compile(numberRegLev);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            this.input = input;
        } else {
            throw new NotNumber(input, 1, 3);
        }

    }


}


