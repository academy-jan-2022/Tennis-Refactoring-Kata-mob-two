
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    public String player1Score = "";
    public String player2Score = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";

        boolean isTied = player1Points == player2Points;
        if (isTied && player1Points < 4) {
            return calculateTiedScore(score);
        }
        if (isTied && player1Points >=3) {
            return "Deuce";
        }


        if (player1Points > 0 && player2Points ==0)
        {
            player1Score = convertPointsToScore(player1Points);
            player2Score = convertPointsToScore(player2Points);

            score = player1Score + "-" + player2Score;
        }
        if (player2Points > 0 && player1Points ==0)
        {
            if (player2Points ==1)
                player2Score = "Fifteen";
            if (player2Points ==2)
                player2Score = "Thirty";
            if (player2Points ==3)
                player2Score = "Forty";
            
            player1Score = "Love";
            score = player1Score + "-" + player2Score;
        }
        
        if (player1Points > player2Points && player1Points < 4)
        {
            if (player1Points ==2)
                player1Score ="Thirty";
            if (player1Points ==3)
                player1Score ="Forty";

            if (player2Points ==1)
                player2Score ="Fifteen";
            if (player2Points ==2)
                player2Score ="Thirty";
            score = player1Score + "-" + player2Score;
        }
        if (player2Points > player1Points && player2Points < 4)
        {
            if (player2Points ==2)
                player2Score ="Thirty";
            if (player2Points ==3)
                player2Score ="Forty";

            if (player1Points ==1)
                player1Score ="Fifteen";
            if (player1Points ==2)
                player1Score ="Thirty";
            score = player1Score + "-" + player2Score;
        }
        
        if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
        
        if (player1Points >=4 && player2Points >=0 && (player1Points - player2Points)>=2)
        {
            score = "Win for player1";
        }
        if (player2Points >=4 && player1Points >=0 && (player2Points - player1Points)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String convertPointsToScore(int playerPoints) {
        if (playerPoints ==1)
            return "Fifteen";
        if (playerPoints ==2)
            return "Thirty";
        if (playerPoints ==3)
            return "Forty";

        return "Love";
    }

    private String calculateTiedScore(String score) {
        if (player1Points ==0)
            score = "Love";
        if (player1Points ==1)
            score = "Fifteen";
        if (player1Points ==2)
            score = "Thirty";
        score += "-All";
        return score;
    }

    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}