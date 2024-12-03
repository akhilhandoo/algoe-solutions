package easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results
    ) {
        Map<String, Integer> analysis = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String teamWithMaxTotal = "";
        for (int index = 0; index < results.size(); index++) {
            int winningIndex = results.get(index) == 0 ? 1 : 0;
            String winningTeam = competitions.get(index).get(winningIndex);
            analysis.put(winningTeam, analysis.getOrDefault(winningTeam, 0) + 1);
            if (analysis.get(winningTeam) > max) {
                max = analysis.get(winningTeam);
                teamWithMaxTotal = winningTeam;
            }
        }
        return teamWithMaxTotal;
    }
}
