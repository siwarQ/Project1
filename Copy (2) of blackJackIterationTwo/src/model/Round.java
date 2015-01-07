package model;
import java.util.ArrayList;
import java.util.Collections;



public class Round {
	//***************************************** Variables ******************************************
		/**KEY field, Round's serialNumber*/
	private static int serialNum=0;
        private int code;
	// total score
	private int totalScore;
	// status: winning/loosing
	private Status statusOfPlayer;
	// dealer hand
	private Hand dealerHand; 
	//player hand
	private Hand PlayerHand; 
	//deck of cards
	private ArrayList<Card> deck;
        // boolean check
    private boolean check = true;
  
	//***************************************** Constructors ******************************************
  	/**
  	 * Full C'tor
  	 */
	public Round(int serialNum,int totalScore,Status statusOfPlaye,Hand dealerHand, Hand PlayerHand)
	{
		Round.setSerialNum(Round.getSerialNum() + 1);
		this.totalScore=totalScore;
		this.statusOfPlayer=statusOfPlaye;
		this.dealerHand=dealerHand;
		this.PlayerHand=PlayerHand;
		this.deck = new ArrayList <>();	
	}
	/**
  	 * Partiel C'tor
  	 */
	public Round(int serialNum,Hand dealerHand, Hand PlayerHand)
	{
		Round.setSerialNum(Round.getSerialNum() + 1);
		this.totalScore=0;
		this.setDealerHand(dealerHand);
		this.PlayerHand=PlayerHand;
		this.deck = new ArrayList <Card>();	
	}
	/**
  	 * Partiel C'tor
  	 */
	public Round()
	{
		this.code = ++serialNum;
		this.totalScore=0;
		this.deck = new ArrayList <>();	
	}
	
	public Round(int serialNum, int totalScore) // for tests
	{
		Round.serialNum = serialNum;
		this.totalScore=totalScore;
		this.deck = new ArrayList <Card>();	
	}

	
	//***************************************** GETTERS AND SETTERS******************************************
	
	/**
	 * @param deck the deck to set
	 */
	protected void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	
	/**
	 * @param playerHand the playerHand to set
	 */
	protected void setPlayerHand(Hand playerHand) {
		PlayerHand = playerHand;
	}
	/**
	 * @return the total score for round
	 */
	protected int getTotalScore() {
		return totalScore;
	}
	
	/**
	 * @param set the total score for round
	 */
	protected void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	/**
	 * @return the status of player
	 */
	protected Status getStatusOfPlayer() {
		return statusOfPlayer;
	}
	/**
	 * @param set the status of player
	 */
	protected void setStatusOfPlayer(Status statusOfPlayer) {
		this.statusOfPlayer = statusOfPlayer;
	}
	
	/**
	 * @return playerHand
	 */
	public Hand getPlayerHand() {
		return PlayerHand;
	}

	/**
	 * @return deack of round
	 */
	protected ArrayList<Card> getDeck() {
		return this.deck;
	}
	
	
	/**
	 * @return delearHand
	 */
	public Hand getDealerHand() {
		return dealerHand;
	}
	
	/**
	 * @return set delearHand
	 */
	public void setDealerHand(Hand dealerHand) {
		this.dealerHand = dealerHand;
	}
	/**
	 * @return serial number of round
	 */
	public static int getSerialNum() {
		return serialNum;
	}
	/**
	 * @param set serial number of round
	 */
	public static void setSerialNum(int serialNum) {
		Round.serialNum = serialNum;
	}

	/**
	 * @return the amunt of cards for player hand
	 */
    public int getPlayerAmount()
    {
     return this.PlayerHand.getAmountOfCards();
    }
    /**
     *@return the amunt of cards for delear hand
     **/  
    public int getDelaerAmount()
    {
     return this.dealerHand.getCards().get(0).getValue();
    }
    /**
     * return the amunt of cards for delear hand after stand button is choose*/
    public int getDelaerAmountAfterStand()
    {
     return this.dealerHand.getAmountOfCards();
    }
	
	/**
	 * @param function calculates score for round. 
	 */
	public int calculateScoreForRound()
	{
		int sum = 0;
                totalScore = this.PlayerHand.getAmountOfCards();
                 
		if (code % 2 == 0 )
			sum = totalScore *3;
		else
			sum = totalScore * 2;
                this.totalScore = sum;
		return sum;	
	}
	
	/**
	 *  this function shuffles the deck 
	 * @param deck
	 * @return
	 */
	public ArrayList<Card> shuffle(ArrayList<Card> deck){
		setDeck(deck);
		
                Collections.shuffle(this.deck);
                //test for the shuffling 
		System.out.println("Test for the shuffling deck -> the result of the deck after shuffling is: ");
                System.out.println();
                System.out.println(this.deck.toString());
                System.out.println();
                
                //test for the deck size --> suppose to be 52
		System.out.println("Test for the number of cards -> suppose to be 52 : Size = "+this.deck.size());
		System.out.println();
                return this.deck;
		
		
	}
	
	
	/**
	 *  hit function
	 * @return card
	 */	
public Card  hit(){
	
    Card c= this.deck.get(0);
              if (this.PlayerHand.isLegal(this.PlayerHand.getAmountOfCards())){ // returns false if hand is not legal
                   if(!this.PlayerHand.addCard(c)){
                       setCheck(false);
                   }
                    this.deck.remove(0);
                    System.err.println("The sum of cards after hit: "+this.PlayerHand.getAmountOfCards());
                }         
                else {
                    if (!this.PlayerHand.isLegal(c.getValue()+ this.PlayerHand.getAmountOfCards()))// checking if the player lost or not
                       setCheck(false);
                    System.err.println("The sum of cards after hit: "+this.PlayerHand.getAmountOfCards());
                   }
                
              this.deck.add(c);
              return c;		
	}


/**
 *  stand function
 * @return the array of cards 
 */
public ArrayList<Card> stand(){
    ArrayList<Card> dealerCards = new ArrayList<>();
    /////// buid a function in dealer hand
    Card c= this.deck.get(0);
    while ( this.dealerHand.isLegal(this.dealerHand.getAmountOfCards())){
        this.dealerHand.addCard(c);
        dealerCards.add(c);
        
        this.deck.remove(0); //////test what if the deck is empty   
        c = this.deck.get(0);
        System.err.println("CARD OF DEALER: "+ c.toString());
    }
    
    setCheck(false);
    this.deck.add(c);
    return dealerCards;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Round [Serialnumber= "+ this.code+" totalScore=" + totalScore + ", statusOfPlayer="
			+ statusOfPlayer + ", dealerHand=" + dealerHand + ", PlayerHand="
			+ PlayerHand + ", deck=" + deck + "]";
}

public boolean isCheck() {
	return check;
}

public void setCheck(boolean check) {
	this.check = check;
}

	
	}
