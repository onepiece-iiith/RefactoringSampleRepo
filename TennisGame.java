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
        if (score1 == score2) {
            return getScoreForSameScore(score1);
        } else if (score1 >= 4 || score2 >= 4) {
            return handleHighScores(score1, score2);
        } else {
            return getScoreForDifferentScore(score1, score2);
        }
    }

    private String handleHighScores(int score1, int score2) {
        int minusResult = score1 - score2;
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
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
        String[] scoreStrings = {"Love", "Fifteen", "Thirty", "Forty"};
        return scoreStrings[score1] + "-" + scoreStrings[score2];
    }
}