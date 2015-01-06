package model;

import java.util.ArrayList;

public class Hand {
	
	//***************************************** Variables ******************************************
	/**KEY field, Hand's serialNumber*/
	private static int serialNum=0;
        private int code;
	/**type of hand: dealer/player*/
	private TypeOfHand TypeOfHand ;
	/**cards existing in this hand*/
	private ArrayList<Card> cards;
	/** amount of cards*/
	private int amountOfCards;
        private int Aflg = 0;
	
	//***************************************** Constructors ******************************************
  	/**
  	 * Full C'tor
  	 */
	public Hand(TypeOfHand typeOfHand) {
		super();
		this.setCode(++serialNum);
		TypeOfHand = typeOfHand;
		this.amountOfCards = 0;
		this.cards = new ArrayList<>();

	}
	
	public Hand(){
		
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

	/**
	 * @param function which checks if amount of values is legal
	 */
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
	
	/**
	 * @param  function which add a card to the dealer/player's hand
	 */
	public boolean addCard(Card c){ 
            if (c.getLetter()== Letter.A && Aflg==0){
                c.setValue(11);
                Aflg = 1;
            }
		if (isLegal(this.amountOfCards))
		{
			this.amountOfCards+= c.getValue();
			this.cards.add(c);
			
			return true;			
		}
                else{
                    this.amountOfCards+= c.getValue();
                    this.cards.add(c);
                    return false;
                }
	}
	/**
	 * @param get code- serial number of hand
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param set code- serial number of hand
	 */
	public void setCode(int code) {
		this.code = code;
	}
	

}
