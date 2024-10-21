package GameV1;

import java.lang.System;
import java.util.ArrayList;
import java.util.Scanner;

import Exceptions.DuplicationNumber;
import Exceptions.NotNumber;

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
                parser.isLevel(level);
            } catch (NotNumber e) {
                check = false;
                System.out.println(e.getMessage());
            }
        } while (!check);
        return Integer.parseInt(level);
    }

    public ArrayList<Integer> getUserTry(int level) {
        ArrayList<Integer> userTryArray = new ArrayList<>();
        Parser parser = new Parser();
        System.out.println(level + "자리의 수를 중복 없이 입력하세요");
        boolean check = false;
        String userTry = "";
        do {
            try {
                check = true;
                userTry = scanner.nextLine();
                parser.isTry(userTry, level);
            } catch (DuplicationNumber e) {
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
                parser.isMode(mode);
            } catch (NotNumber e) {
                check = false;
                System.out.println(e.getMessage());
            }
        } while (!check);
        return Integer.parseInt(mode);
    }


}
