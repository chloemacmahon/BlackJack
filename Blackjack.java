import java.util.Random;

public class Blackjack
{
    //Global variables
    public int[] playerhand;
    public int[] dealerhand;
    public int iplayer = 0;
    public int idealer = 0;
    public int playercardcounter = 0;
    public int dealercardcounter = 0;
    public static void main(String[] agrs)
    {
        Deck[] cards = new Deck[13];
        for(int z = 0 ; z < 13; z++)
        {
            cards[z] = new Deck(0);
        }
        displayInstructions();
        
    }
    //Displays rules of blackjack
    public static void displayInstructions()
    {
        System.out.println("You will be playing against the dealer");
        System.out.println("The goal of the game is to get as close to 21 as you can \n1.)A Ace card can either be counted as an 1 or an 11 \n2.)Jack, Queen and King count as 10\n3.)If you exceed 21 you automatically lose");
        
    }
    public void beginning(Deck[] cards)
    {
        for(int w = 0 ; w < 2; w++)
        {
            boolean validcard = false;
            while(!validcard)
            {
                Random rand = new Random();
                int numberaddition = rand.nextInt(13);
                if(cards[numberaddition].getCard() < 4)
                {
                    cards[numberaddition].setCard(cards[numberaddition].getCard()+1);
                    if((numberaddition > 10)&&(numberaddition != 0))
                    {
                        iplayer = calculateScore(iplayer,numberaddition);
                        playerhand[playercardcounter] = numberaddition;
                        playercardcounter++;
                    }
                    else if(numberaddition > 10)
                    {
                        iplayer = calculateScore(iplayer,numberaddition);
                    }
                    else if (numberaddition == 0)
                    {
                        iplayer = calculateScore(iplayer, ace(iplayer));
                        playerhand[playercardcounter] = numberaddition;
                        playercardcounter++;
                    }
                    validcard = true;
                }
            }
        }
        for(int w = 0 ; w < 2; w++)
        {
            boolean validcard = false;
            while(!validcard)
            {
                Random rand = new Random();
                int numberaddition = rand.nextInt(13);
                if(cards[numberaddition].getCard() < 4)
                {
                    cards[numberaddition].setCard(cards[numberaddition].getCard()+1);
                    if((numberaddition > 10)&&(numberaddition != 0))
                    {
                        idealer = calculateScore(idealer,numberaddition);
                        dealerhand[dealercardcounter] = numberaddition;
                        dealercardcounter++;
                    }
                    else if(numberaddition > 10)
                    {
                        idealer = calculateScore(idealer,numberaddition);
                    }
                    else if (numberaddition == 0)
                    {
                        idealer = calculateScore(idealer, ace(idealer));
                        dealerhand[dealercardcounter] = numberaddition;
                        dealercardcounter++;
                    }
                    validcard = true;
                }
            }
        }
    }
    public int ace(int currentscore)
    {
        return 11;        
    }   
    public int calculateScore(int score, int newcard)
    {
        return score + newcard;
    }
    
}