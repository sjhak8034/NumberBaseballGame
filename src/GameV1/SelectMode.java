package GameV1;

import java.util.Scanner;

public class SelectMode {
    Scanner scanner = new Scanner(System.in);

    public Integer selectMode() {
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        GetInput getInput = new GetInput();
        int mode = getInput.setMode();
        return mode;
    }
}
