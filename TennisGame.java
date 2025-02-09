public class TennisGame1 implements TennisGame {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private ScoreCalculator scoreCalculator = new ScoreCalculator();

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        return scoreCalculator.calculateScore(m_score1, m_score2);
    }
}

class ScoreCalculator {
    public String calculateScore(int score1, int score2) {
        String score = "";
        if (score1 == score2) {
            score = getScoreForSameScore(score1);
        } else if (score1 >= 4 || score2 >= 4) {
            int minusResult = score1 - score2;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            score = getScoreForDifferentScore(score1, score2);
        }
        return score;
    }

    private String getScoreForSameScore(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String getScoreForDifferentScore(int score1, int score2) {
        String score = "";
        String[] scoreStrings = {"Love", "Fifteen", "Thirty", "Forty"};
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                score += scoreStrings[score1];
            } else {
                score += "-" + scoreStrings[score2];
            }
        }
        return score;
    }
}