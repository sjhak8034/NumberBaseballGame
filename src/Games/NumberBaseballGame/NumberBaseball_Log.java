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
    public void print() {
        System.out.println(currentResults.size());

    }





}
