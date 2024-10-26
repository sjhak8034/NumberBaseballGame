package main;


import game.Game;
import game.log.GameLog;
import game.log.LogPrinter;
import game.numberbaseball.NumberBaseballStarter;
import game.log.GameLogPrinter;
import Input.InputHelper;
import data.NumberBaseBallDataManager;
import data.Data;

public class Controller {


    public void start() {

        Data<LogPrinter<GameLog>> DataManager = new NumberBaseBallDataManager();

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

    /**
     * get userInputForMode to choose GameMode
     * @return return GameMode to select play game or looking for logs or exit game
     */
    private GameMode getModeFromUserInput(){
        InputHelper inputHelper = new InputHelper();
        int selectedModeNumber = inputHelper.getUserInputForMode();

        return GameMode.fromInt(selectedModeNumber);
    }

}
