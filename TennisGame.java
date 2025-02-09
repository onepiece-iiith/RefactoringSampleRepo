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
        return new ScoreCalculator(m_score1, m_score2).calculateScore();
    }

    private class ScoreCalculator {
        private int m_score1;
        private int m_score2;

        public ScoreCalculator(int m_score1, int m_score2) {
            this.m_score1 = m_score1;
            this.m_score2 = m_score2;
        }

        public String calculateScore() {
            if (m_score1 == m_score2) {
                return getScoreForEqualScores();
            } else if (m_score1 >= 4 || m_score2 >= 4) {
                return getScoreForAdvantageOrWin();
            } else {
                return getScoreForNormalScores();
            }
        }

        private String getScoreForEqualScores() {
            String[] scoreStrings = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
            int scoreIndex = Math.min(3, m_score1);
            return scoreStrings[scoreIndex];
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

        private String getScoreForNormalScores() {
            String score = getScoreForPlayer(m_score1) + "-" + getScoreForPlayer(m_score2);
            return score;
        }

        private String getScoreForPlayer(int score) {
            String[] scoreStrings = {"Love", "Fifteen", "Thirty", "Forty"};
            int scoreIndex = Math.min(3, score);
            return scoreStrings[scoreIndex];
        }
    }
}