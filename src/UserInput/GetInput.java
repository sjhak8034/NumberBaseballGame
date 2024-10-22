package UserInput;

import Exceptions.DuplicationNumberException;
import Exceptions.NotNumberException;

import java.util.ArrayList;
import java.util.Scanner;

public class GetInput {
    Scanner scanner = new Scanner(System.in);


    public Integer setLevel() {
        Parser parser = new Parser();
        boolean check = false;
        String level = "";

        do {
            try {
                check = true;
                System.out.println("Enter level (3~5):  ");
                level = scanner.nextLine();
                parser.checkLevelException(level);
            } catch (NotNumberException e) {
                check = false;
                System.out.println(e.getMessage());
            }
        } while (!check);
        return Integer.parseInt(level);
    }

    public ArrayList<Integer> getUserTry(int level) {
        ArrayList<Integer> userTryArray = new ArrayList<>();
        Parser parser = new Parser();

        boolean check = false;
        String userTry = "";

        do {
            try {
                System.out.println(level + "자리의 수를 중복 없이 입력하세요");
                check = true;
                userTry = scanner.nextLine();
                parser.checkUserTryException(userTry, level);
            } catch (DuplicationNumberException e) {
                check = false;
                System.out.println(e.getMessage());
            }
        } while (!check);
        for (int i = 0; i < level; i++) {
            userTryArray.add(Integer.parseInt(userTry.charAt(i) + ""));
        }


        return userTryArray;
    }

    public Integer setMode() {
        Parser parser = new Parser();
        boolean check = false;
        String mode = "";

        do {
            try {
                check = true;
                System.out.println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");
                mode = scanner.nextLine();
                parser.checkModeException(mode);
            } catch (NotNumberException e) {
                check = false;
                System.out.println(e.getMessage());
            }
        } while (!check);
        return Integer.parseInt(mode);
    }


}
