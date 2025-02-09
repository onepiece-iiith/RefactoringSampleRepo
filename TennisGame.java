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
            return getScoreForSameScore(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getScoreForAdvantageOrWin(m_score1, m_score2);
        } else {
            return getScoreForDifferentScores(m_score1, m_score2);
        }
    }

    private String getScoreForSameScore(int score) {
        return TennisGameScore.getScoreForSameScore(score);
    }

    private String getScoreForDifferentScores(int score1, int score2) {
        return TennisGameScore.getScoreForDifferentScores(score1, score2);
    }

    private String getScoreForAdvantageOrWin(int score1, int score2) {
        return TennisGameScore.getScoreForAdvantageOrWin(score1, score2);
    }
}

class TennisGameScore{
    public static String getScoreForSameScore(int score) {
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

    public static String getScoreForDifferentScores(int score1, int score2) {
        String score = "";
        String[] scoreNames ={"Love", "Fifteen", "Thirty", "Forty"};
        score = scoreNames[score1] + "-" + scoreNames[score2];
        return score;
    }

    public static String getScoreForAdvantageOrWin(int score1, int score2){
        String score = "";
        int minusResult = score1 - score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }
}