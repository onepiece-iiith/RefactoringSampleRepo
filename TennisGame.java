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
            return getScoreForEqualScores();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getScoreForAdvantageOrWin();
        } else {
            return getScoreForNormalPlay();
        }
    }

    private String getScoreForEqualScores() {
        String[] scores = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
        return scores[Math.min(m_score1, 3)];
    }

    private String getScoreForAdvantageOrWin() {
        int minusResult = m_score1 - m_score2;
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

    private String getScoreForNormalPlay() {
        String score = "";
        String[] scoreValues = {"Love", "Fifteen", "Thirty", "Forty"};
        score = scoreValues[m_score1] + "-" + scoreValues[m_score2];
        return score;
    }
}