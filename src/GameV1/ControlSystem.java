package GameV1;


import Game.Game;
import Game.NumberBaseball;
import UserRecord.NumberBaseballRecord;
import UserRecord.UserRecord;

public class ControlSystem {

    public void start() {
        UserRecord recordBaseball = new NumberBaseballRecord();
        SelectMode selectMode = new SelectMode();

        boolean stop = false;
        while (!stop) {
            int mode = selectMode.selectMode();
            switch (mode) {
                case 1:
                    Game numberBaseball = new NumberBaseball();
                    int result = numberBaseball.playGame();
                    recordBaseball.record(result);
                    break;
                case 2:
                    recordBaseball.printRecord();
                    break;
                case 3:
                    stop = true;
                    System.out.println("<숫자 야구 게임을 종료합니다>");
                    recordBaseball.clearRecord();
                    break;

            }
        }

    }


}
