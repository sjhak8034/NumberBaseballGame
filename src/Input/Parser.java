package Input;

import exception.DuplicateNumberException;
import exception.NotNumberException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final String NUMBER_REG_LEVEL = "[3-5]";
    private final String NUMBER_REG_MODE = "[1-4]";

    public void checkLevelException(String input) throws NotNumberException {
        Pattern LEVEL_PATTERN = Pattern.compile(NUMBER_REG_LEVEL);
        Matcher matcher = LEVEL_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new NotNumberException(input, 3, 5);
        }

    }


    public void checkUserTryException(String userTrial, int level) throws DuplicateNumberException {
        final String NUMBER_REG_TRY = "^(?!.*(.).*\\1)[1-9]{" + level + "}$";

        Pattern MODE_PATTERN  = Pattern.compile(NUMBER_REG_TRY);
        Matcher matcher = MODE_PATTERN .matcher(userTrial);

        if (!matcher.matches()) {
            throw new DuplicateNumberException();
        }


    }

    public void checkModeException(String input) throws NotNumberException {
        Pattern pattern = Pattern.compile(NUMBER_REG_MODE);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new NotNumberException(input, 1, 3);
        }

    }


}


