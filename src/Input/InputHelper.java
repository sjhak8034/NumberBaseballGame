package Input;

import exception.DuplicateNumberException;
import exception.NotNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class InputHelper {
    Scanner scanner = new Scanner(System.in);


    public List<Integer> getUserInputForTrial(int level) {

        List<Integer> userInputTrials = new ArrayList<>();
        Parser parser = new Parser();
        boolean check;
        String userTrial;

        do {
            System.out.println(level + "자리의 수를 중복 없이 입력하세요");
            userTrial = scanner.nextLine();
            check = executeWithExceptionHandling(userTrial, input -> parser.checkUserTryException(input, level));
        }while (!check);

        for (int i = 0; i < level; i++) {
            userInputTrials.add(Integer.parseInt(userTrial.charAt(i) + ""));
        }


        return userInputTrials;
    }

    public Integer getUserInputForMode() {

        Parser parser = new Parser();
        boolean check;
        String mode;

        do {
            System.out.println("1. 게임 시작하기  2. 게임 기록 보기 3. 리플레이 보기 4. 종료하기");
            mode = scanner.nextLine();
            check = executeWithExceptionHandling(mode, parser::checkModeException);
        }while (!check);
        int i = 0;


        return Integer.parseInt(mode);
    }
    public Integer getUserInputForLevel() {

        Parser parser = new Parser();

        String level;
        boolean check;

        do {
            System.out.println("Enter level (3~5): ");
            level = scanner.nextLine();
            check = executeWithExceptionHandling(level, parser::checkLevelException);
        }while (!check);


        return Integer.parseInt(level);
    }

    private boolean executeWithExceptionHandling(String input , Consumer<String> checkException) {

        try {
            checkException.accept(input);
        } catch (NotNumberException e) {
            System.out.println(e.getMessage());
            return false;
        }catch (DuplicateNumberException e){
            System.out.println(e.getMessage());
            return false;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

}
