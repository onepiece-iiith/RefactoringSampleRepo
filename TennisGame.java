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
    public String calculateScore(int m_score1, int m_score2) {
        if (m_score1 == m_score2) return getScoreForEvenScores(m_score1);
        if (m_score1 >= 4 || m_score2 >= 4) return getScoreForAdvantageOrWin(m_score1, m_score2);
        return getScoreForUnevenScores(m_score1, m_score2);
    }

    private String getScoreForEvenScores(int score) {
        String scoreString = "";
        switch (score) {
            case 0:
                scoreString = "Love-All";
                break;
            case 1:
                scoreString = "Fifteen-All";
                break;
            case 2:
                scoreString = "Thirty-All";
                break;
            default:
                scoreString = "Deuce";
                break;
        }
        return scoreString;
    }

    private String getScoreForAdvantageOrWin(int m_score1, int m_score2) {
        String score = "";
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String getScoreForUnevenScores(int m_score1, int m_score2) {
        String score = "";
        for (int i = 1; i < 3; i++) {
            int tempScore = (i == 1 ? m_score1 : m_score2);
            String playerScore = getScoreForSinglePlayer(tempScore);
            score += playerScore + (i == 1 ? "-" : "");
        }
        return score;
    }

    private String getScoreForSinglePlayer(int tempScore) {
        String score = "";
        switch (tempScore) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
        }
        return score;
    }
}