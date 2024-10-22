package MainApp;


import Games.Game;
import Games.NumberBaseballGame.NumberBaseball;
import UserInput.GetInput;
import UserRecord.NumberBaseballRecord;
import UserRecord.UserRecord;

public class ControlSystem {

    public void start() {
        // 숫자 야구 게임 기록을 생성
        UserRecord recordBaseball = new NumberBaseballRecord();

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        GetInput getInput = new GetInput();


        boolean stop = false;
        while (!stop) {
            int mode = getInput.setMode();
            switch (mode) {
                case 1:
                    // 숫자야구게임 시작 및 기록
                    Game numberBaseball = new NumberBaseball();
                    int result = numberBaseball.playGame();
                    recordBaseball.record(result);
                    break;
                case 2:
                    // 기록을 출력
                    recordBaseball.printRecord();
                    break;
                case 3:
                    //게임 종료
                    stop = true;
                    System.out.println("<숫자 야구 게임을 종료합니다>");
                    recordBaseball.clearRecord();
                    break;

            }
        }

    }


}
