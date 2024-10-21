package GameV1;

public class ControlSystem {

    public void start() {
        Record Record = new Record();
        SelectMode selectMode = new SelectMode();
        boolean stop = false;
        while (!stop) {
            int mode = selectMode.selectMode();
            switch (mode) {
                case 1:
                    Game game = new Game();
                    int result = game.playGame();
                    Record.record(result);
                    break;
                case 2:
                    Record.printRecord();
                    break;
                case 3:
                    stop = true;
                    System.out.println("<숫자 야구 게임을 종료합니다>");
                    Record.clearRecord();
                    break;

            }
        }

    }


}
