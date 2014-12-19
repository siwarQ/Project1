package model;

import java.util.ArrayList;

public class Hand {
	
	//***************************************** Variables ******************************************
	/**KEY field, Hand's serialNumber*/
	private int serialNum;
	/**type of hand: dealer/player*/
	private TypeOfHand TypeOfHand ;
	/**cards existing in this hand*/
	private ArrayList<Card> cards;
	/** amount of cards*/
	private int amountOfCards;
	
	//***************************************** Constructors ******************************************
  	/**
  	 * Full C'tor
  	 */
	protected Hand(int serialNum, TypeOfHand typeOfHand) {
		super();
		this.serialNum = serialNum;
		TypeOfHand = typeOfHand;
		this.amountOfCards = 0;
		this.cards = new ArrayList<Card>();

	}
	
	
	protected Hand(int serialNum,TypeOfHand typeOfHand, int amountOfCards, ArrayList<Card> cards) { 
		super();
		this.serialNum = serialNum;
		TypeOfHand = typeOfHand;
		this.amountOfCards = amountOfCards;
		this.cards = cards;
	}


	/**
	 * @return the serialNum
	 */
	protected int getSerialNum() {
		return serialNum;
	}


	/**
	 * @param serialNum the serialNum to set
	 */
	protected void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}


	/**
	 * @return the typeOfHand
	 */
	protected TypeOfHand getTypeOfHand() {
		return TypeOfHand;
	}


	/**
	 * @param typeOfHand the typeOfHand to set
	 */
	protected void setTypeOfHand(TypeOfHand typeOfHand) {
		TypeOfHand = typeOfHand;
	}


	/**
	 * @return the amountOfCards
	 */
	protected int getAmountOfCards() {
		return amountOfCards;
	}


	/**
	 * @param amountOfCards the amountOfCards to set
	 */
	protected void setAmountOfCards(int amountOfCards) {
		this.amountOfCards = amountOfCards;
	}
	
	/**
	 * @return the cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hand [serialNum=" + serialNum + ", TypeOfHand=" + TypeOfHand
				+ ", cards=" + cards + ", amountOfCards=" + amountOfCards + "]";
	}


	/**
	 * @param cards the cards to set
	 */
	protected void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}


	// function which checks if amount of values is legal
	public boolean isLegal(int a){
             if (this.TypeOfHand.equals(model.TypeOfHand.User)){
		if (a >= 21){
			return false;
		}
		else 
			return true;
            }
            else {
                if (a >= 17){
			return false;
		}
		else 
			return true;
            }
		
	}
	
	// function which add a card to the dealer/player's hand
	public boolean addCard(Card c){ 
            if (c.getLetter()== Letter.A)
                {
                    if ((amountOfCards+11)<=21)
                    {
                        c.setValue(11);
                      System.err.println("The cards Value:"+c.getValue());
                    }
                }
            if (this.TypeOfHand.equals(model.TypeOfHand.Dealer))
                System.err.println("The dealer cards are: "+this.cards.toString());
            else
                System.err.println("The player cards are: "+this.cards.toString());
		////////////////////////////////////////////////////////CHECK ASSSS
		//int a = this.amountOfCards+ c.getValue();
		// submit changes so we can check if player winning/loosing
		//this.amountOfCards 
                System.err.println("The amount is:"+this.amountOfCards);
		if (isLegal(this.amountOfCards))
		{
			this.amountOfCards+= c.getValue();
			this.cards.add(c);
			
			return true;			
		}
                else{
                    this.amountOfCards+= c.getValue();
                    this.cards.add(c);
                    
                    //System.err.println("IT IS NOT LEGAL");
                    return false;
                }
	}
	
	
	
	

}
