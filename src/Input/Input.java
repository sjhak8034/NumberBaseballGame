package Input;

import exception.DuplicateNumberException;
import exception.NotNumberException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class Input {



    public ArrayList<Integer> getUserInputForTrial(int level) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> userInputTrials = new ArrayList<>();
        Parser parser = new Parser();

        boolean check;
        String userInputTrial;

        do {
            System.out.println(level + "자리의 수를 중복 없이 입력하세요");
            userInputTrial = scanner.nextLine();
            check = executeWithExceptionHandling(userInputTrial, input -> parser.checkUserTryException(input, level));
        }while (!check);

        for (int i = 0; i < level; i++) {
            userInputTrials.add(Integer.parseInt(userInputTrial.charAt(i) + ""));
        }

        scanner.close();
        return userInputTrials;
    }

    public Integer getUserInputForMode() {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();

        boolean check;
        String mode;

        do {
            System.out.println("1. 게임 시작하기  2. 게임 기록 보기 3. 리플레이 보기 4. 종료하기");
            mode = scanner.nextLine();
            check = executeWithExceptionHandling(mode, parser::checkModeException);
        }while (!check);
        int i = 0;

        scanner.close();
        return Integer.parseInt(mode);
    }
    public Integer getUserInputForLevel() {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();

        String level;
        boolean check;

        do {
            System.out.println("Enter level (3~5): ");
            level = scanner.nextLine();
            check = executeWithExceptionHandling(level, parser::checkLevelException);
        }while (!check);

        scanner.close();
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
