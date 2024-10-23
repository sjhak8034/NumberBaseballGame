package Games.NumberBaseballGame;

import Games.Log;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseball_Log implements Log<CurrentResult> {
    List<CurrentResult> currentResults = new ArrayList<CurrentResult>();
    @Override
    public void append(CurrentResult currentResult) {
        currentResults.add(currentResult);
    }

    @Override
    public void printScore() {
        System.out.println(currentResults.size());
    }

    public void printLevel() {
        currentResults.get(0).printLevel();
    }

    public void printTime(){
        currentResults.get(currentResults.size()-1).printTime();
    }





}
