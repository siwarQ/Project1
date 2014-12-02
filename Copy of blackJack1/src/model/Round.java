package model;
import java.util.ArrayList;
import java.util.Random;


public class Round {
	
	private static int serialNum=0;
	private int totalScore;
	private Status statusOfPlayer;
	private Hand dealerHand; 
	private Hand PlayerHand; 
	private ArrayList<Card> deck; 
	
	/**
	 * @param deck the deck to set
	 */
	protected void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public Round(int serialNum,int totalScore,Status statusOfPlaye,Hand dealerHand, Hand PlayerHand)
	{
		Round.setSerialNum(Round.getSerialNum() + 1);
		this.totalScore=totalScore;
		this.statusOfPlayer=statusOfPlaye;
		this.setDealerHand(dealerHand);
		this.PlayerHand=PlayerHand;
		this.deck = new ArrayList <Card>();	
	}
	
	public Round(int serialNum,Hand dealerHand, Hand PlayerHand)
	{
		Round.setSerialNum(Round.getSerialNum() + 1);
		this.totalScore=0;
		this.setDealerHand(dealerHand);
		this.PlayerHand=PlayerHand;
		this.deck = new ArrayList <Card>();	
	}
	
	public Round()
	{
		Round.setSerialNum(Round.getSerialNum() + 1);
		this.totalScore=0;
		this.deck = new ArrayList <Card>();	
	}

	protected int getTotalScore() {
		return totalScore;
	}

	protected void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	protected Status getStatusOfPlayer() {
		return statusOfPlayer;
	}

	protected void setStatusOfPlayer(Status statusOfPlayer) {
		this.statusOfPlayer = statusOfPlayer;
	}

	

	protected Hand getPlayerHand() {
		return PlayerHand;
	}

	protected ArrayList<Card> getDeck() {
		return this.deck;
	}
	
	public int calculateScoreForRound()
	{
		int sum = 0;
		if (getSerialNum() % 2 == 0 )
			sum = totalScore *2;
		else
			sum = totalScore * 3;
		return sum;	
	}

	public Hand getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(Hand dealerHand) {
		this.dealerHand = dealerHand;
	}

	public static int getSerialNum() {
		return serialNum;
	}

	public static void setSerialNum(int serialNum) {
		Round.serialNum = serialNum;
	}
	
	
	public ArrayList<Card> shuffle(ArrayList<Card> deck){
		
		/*int newI;
		Card temp;
		Random randIndex = new Random();

		for (int i = 0; i < deck.size(); i++) {

		// pick a random index between 0 and cardsInDeck - 1
		newI = randIndex.nextInt(52);

		// swap cards[i] and cards[newI]
		temp = deck.get(i);
		Card tempC = deck.get(i);
		tempC= deck.get(newI);
		Card tempC2= deck.get(newI) ;
		tempC2= temp;
	
	}
		System.out.println(deck.get(0).toString());
		setDeck(deck);
		
		return deck;*/
		/*var rand = new Random();
		for (int i = cards.Length - 1; i > 0; i--)
		{
		int n = rand.Next(i + 1);
		int temp = cards[i];
		cards[i] = cards[n];
		cards[n] = temp;*/
		
		setDeck(deck);
		
		
		Random random = new Random();
		//System.out.println(this.deck.size());
		for (int i = this.deck.size() - 1; i >= 0; i--) {
		    int j = random.nextInt(i + 1);

		    /* swap cards i,j */
		    Card card = this.deck.get(i);
		    this.deck.set(i, this.deck.get(j));
		    this.deck.set(j, card);
		}
		
		System.out.println(this.deck.toString());
		System.out.println(this.deck.size());
		return this.deck;
		
		
	}

	/**
	 * @param playerHand the playerHand to set
	 */
	protected void setPlayerHand(Hand playerHand) {
		PlayerHand = playerHand;
	}
	}
