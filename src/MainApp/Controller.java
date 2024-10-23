package MainApp;


import Games.Game;
import Games.NumberBaseballGame.NumberBaseball;
import Games.NumberBaseballGame.NumberBaseball_Log;
import UserInput.Input;
import UserRecord.NumberBaseballRecord;
import UserRecord.UserRecord;

public class Controller {


    public void start() {
        // 숫자 야구 게임 기록을 생성
        UserRecord<NumberBaseball_Log> recordBaseball = new NumberBaseballRecord<NumberBaseball_Log>();

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");


        boolean stop = false;

        while (!stop) {
            Mode mode = setMode();
            switch (mode) {
                case STARTGAME:
                    // 숫자야구게임 시작 및 기록
                    Game<NumberBaseball_Log> numberBaseball = new NumberBaseball();

                    recordBaseball.record(numberBaseball.playGame());

                    break;
                case PRINTRECORD:
                    // 기록을 출력
                    recordBaseball.printRecord();
                    break;
                case EXITGAME:
                    //게임 종료
                    stop = true;
                    System.out.println("<숫자 야구 게임을 종료합니다>");

                    break;

            }
        }

    }
    private Mode setMode (){
        Input input = new Input();
        int unconvertedMode = input.getMode();
        int modeCount = 0;
        Mode mode = Mode.EXITGAME;
        for (Mode m : Mode.values()) {
            modeCount++;
            mode= m;
            if (modeCount == unconvertedMode) {
                break;
            }

        }
        return mode;
    }
}
