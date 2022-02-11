
public class TennisGame3 implements TennisGame {
    
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;
    private String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {

        if (isGameInPlay()) {
            var player1Points = points[player1Score];
            var player2Points = points[player2Score];

            return isTied()
                    ? player1Points + "-All"
                    : player2Points + "-" + player1Points;

        }


        if (isTied())
            return "Deuce";

        var inLeadPlayer = player2Score > player1Score ? player1Name : player2Name;
        return (checkForWin() ? "Win for " : "Advantage ") + inLeadPlayer;

    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.player2Score += 1;
        else
            this.player1Score += 1;
        
    }

    public boolean isGameInPlay(){
        return player2Score < 4 && player1Score < 4 && !(player2Score + player1Score == 6);
    }

    public boolean isTied(){
        return player2Score == player1Score;
    }

    public boolean checkForWin() {
        return Math.abs(player1Score - player2Score) > 1;
    }
}
