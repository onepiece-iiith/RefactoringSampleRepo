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
        return new ScoreFormatter(m_score1, m_score2).format();
    }

    private class ScoreFormatter {
        private int m_score1;
        private int m_score2;

        public ScoreFormatter(int m_score1, int m_score2) {
            this.m_score1 = m_score1;
            this.m_score2 = m_score2;
        }

        public String format() {
            String score = "";
            if (m_score1 == m_score2) {
                score = formatTie();
            } else if (m_score1 >= 4 || m_score2 >= 4) {
                score = formatAdvantageOrWin();
            } else {
                score = formatStandardScore();
            }
            return score;
        }

        private String formatTie() {
            String[] scores = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
            return (m_score1 < scores.length) ? scores[m_score1] : "Deuce";
        }

        private String formatAdvantageOrWin() {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) return "Advantage player1";
            if (minusResult == -1) return "Advantage player2";
            if (minusResult >= 2) return "Win for player1";
            return "Win for player2";
        }

        private String formatStandardScore() {
            String[] scoreDescriptions = {"Love", "Fifteen", "Thirty", "Forty"};
            return scoreDescriptions[m_score1] + "-" + scoreDescriptions[m_score2];
        }
    }
}