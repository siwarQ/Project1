package model;

public class Card {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [value=" + value + ", color=" + color + ", suit=" + suit
				+ ", letter=" + letter + "]";
	}

	private int value;
	private Color color;
	private Suit suit;
	private Letter letter;
	
	
	public Card (int value, Color color, Suit suit)
	{
		this.value = value;
		this.color = color;
		this.suit = suit;
		this.setLetter(null);
	}
	
	public Card (int value, Color color, Suit suit, Letter l)
	{
		this.value = value;
		this.color = color;
		this.suit = suit;	
		this.setLetter(l);
	}


	protected int getValue() {
		return value;
	}


	protected void setValue(int value) {
		this.value = value;
	}


	protected Color getColor() {
		return color;
	}


	protected void setColor(Color color) {
		this.color = color;
	}


	protected Suit getSuit() {
		return suit;
	}


	protected void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Letter getLetter() {
		return letter;
	}

	public void setLetter(Letter letter) {
		this.letter = letter;
	}
	
	
	

}
