import java.util.Random;

public class Blackjack
{
    public static void main(String[] agrs)
    {
        Deck[] cards = new Deck[13];
        for(int z = 0 ; z < 13; z++)
        {
            cards[z] = new Deck(0);
        }
        displayInstructions();
        int iplayer = 0;
        int idealer = 0;
        
    }

    public static void displayInstructions()
    {
        System.out.println("You will be playing against the dealer");
        System.out.println("The goal of the game is to get as close to 21 as you can \n1.)A Ace card can either be counted as an 1 or an 11 \n2.)Jack, Queen and King count as 10\n3.)If you exceed 21 you automatically lose");
        
    }
    public void beginning()
    {
        int iplayer = 0;
        int idealer = 0;
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
                    if(numberaddition > 10)
                    {
                        iplayer = player(iplayer,numberaddition);
                    }
                }
            }
        }
    }
    public int player(int score, int newcard)
    {
        return score + newcard;
    }

    public int dealer(int score, int newcard)
    {
        return score + newcard;
    }
}