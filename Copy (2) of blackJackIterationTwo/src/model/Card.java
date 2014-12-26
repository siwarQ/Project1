package model;


public class Card {
	//HELLO LEE
	// hello leee
	//hello siwar
	//***************************************** Variables ******************************************
	/**KEY field, Card's valu*/
	private int value;
	/**color of card*/
	private Color color;
	/**suit of card*/
	private Suit suit;
	/**letter of card*/
	private Letter letter;
	/**source of image to card*/
	private String image;
			
	//***************************************** Constructors ******************************************
	/**
	 * Full C'tor 
	 */
	public Card (int value, Color color, Suit suit, String image)
	{
		this.value = value;
		this.color = color;
		this.suit = suit;
		this.setLetter(null);
        this.image = image;
	}
        
        public Card (int value, Color color, Suit suit, Letter l, String image)
	{
		this.value = value;
		this.color = color;
		this.suit = suit;
		this.setLetter(l);
        this.image = image;
	}
        //siwar
        public Card (int value, Suit suit){ // FOR TESTS
        	this.value = value;
        	this.suit = suit;	
        }
	
        
        
     //***************************************** GETTERS AND SETTERS******************************************
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return value
	 */
	public int getValue() {
		return value;
	}

	/**
	 *  @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * @return color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 *  @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 *  @param suit
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	/**
	 * @return letter
	 */
	public Letter getLetter() {
		return letter;
	}
	
	/**
	 *  @param letter
	 */
	public void setLetter(Letter letter) {
		this.letter = letter;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [value=" + value + ", color=" + color + ", suit=" + suit
				+ ", letter=" + letter + "]";
	}
	
	
	

}
