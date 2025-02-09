public class TennisGame1 implements TennisGame {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

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
        if (m_score1 == m_score2) {
            return getScoreForEqualScores(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getScoreForAdvantageOrWin(m_score1, m_score2);
        } else {
            return getScoreForNormalScores(m_score1, m_score2);
        }
    }

    private String getScoreForEqualScores(int score) {
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

    private String getScoreForAdvantageOrWin(int score1, int score2) {
        int minusResult = score1 - score2;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getScoreForNormalScores(int score1, int score2) {
        String score = "";
        String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty"};
        score += scoreNames[score1];
        score += "-";
        score += scoreNames[score2];
        return score;
    }
}