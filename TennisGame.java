public class TennisGame1 implements TennisGame {

    private Score score;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        score = new Score();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            score.wonPoint(1);
        } else {
            score.wonPoint(2);
        }
    }

    public String getScore() {
        return score.toString();
    }

    private static class Score {
        private int player1Score = 0;
        private int player2Score = 0;

        public void wonPoint(int player) {
            if (player == 1) {
                player1Score += 1;
            } else {
                player2Score += 1;
            }
        }

        @Override
        public String toString() {
            String score = "";
            if (player1Score == player2Score) {
                score = getScoreForTie(player1Score);
            } else if (player1Score >= 4 || player2Score >= 4) {
                score = getScoreForAdvantageOrWin(player1Score, player2Score);
            } else {
                score = getScoreForNormal(player1Score, player2Score);
            }
            return score;
        }

        private String getScoreForNormal(int player1Score, int player2Score) {
            return scoreForPoint(player1Score) + "-" + scoreForPoint(player2Score);
        }

        private String scoreForPoint(int score) {
            String scoreString = "";
            switch (score) {
                case 0:
                    scoreString = "Love";
                    break;
                case 1:
                    scoreString = "Fifteen";
                    break;
                case 2:
                    scoreString = "Thirty";
                    break;
                case 3:
                    scoreString = "Forty";
                    break;
            }
            return scoreString;
        }

        private String getScoreForTie(int score) {
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

        private String getScoreForAdvantageOrWin(int player1Score, int player2Score) {
            int minusResult = player1Score - player2Score;
            if (minusResult == 1) return "Advantage player1";
            else if (minusResult == -1) return "Advantage player2";
            else if (minusResult >= 2) return "Win for player1";
            else return "Win for player2";
        }
    }
}