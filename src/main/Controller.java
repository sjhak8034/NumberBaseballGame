package main;


import game.Game;
import game.numberbaseball.NumberBaseballStarter;
import game.log.GameLogPrinter;
import Input.InputHelper;
import data.NumberBaseBallDataManager;
import data.Data;

public class Controller {


    public void start() {
        // 숫자 야구 게임 기록을 생성
        Data<GameLogPrinter> DataManager = new NumberBaseBallDataManager();

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");

        boolean stop = false;

        while (!stop) {
            GameMode gameMode = getModeFromUserInput();
            switch (gameMode) {
                case START_GAME:

                    Game<GameLogPrinter> numberBaseball = new NumberBaseballStarter();
                    DataManager.save(numberBaseball.playGame());
                    break;

                case PRINT_RECORD:

                    DataManager.printData();
                    break;

                case PLAY_REPLAY:

                    DataManager.printReplay();
                    break;

                case EXIT_GAME:

                    stop = true;
                    System.out.println("<숫자 야구 게임을 종료합니다>");

                    break;
            }
        }
    }

    private GameMode getModeFromUserInput(){
        InputHelper inputHelper = new InputHelper();
        int selectedModeNumber = inputHelper.getUserInputForMode();

        return GameMode.fromInt(selectedModeNumber);
    }

}
