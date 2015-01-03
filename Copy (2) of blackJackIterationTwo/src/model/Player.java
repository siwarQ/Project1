package model;

import java.io.Serializable;

public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6787079487402440625L;
	//***************************************** Variables ******************************************
	/**KEY field, player's passWord*/
        private String passWord;
	/**user name*/
	private String userName;
	/**password*/
	
	/**players first name*/
	private String firstName;
	/**players last name*/
	private String lastName;
	/**max score of player*/
	private int maxScore=0;
	/**winning and loosing counters*/
	private int winningCounter;
	private int loosingCounter;
	
	//***************************************** Constructors ******************************************
  	/**
  	 * Full C'tor
  	 */
	protected Player(String userName, String passWord,
			String firstName, String lastName) {
	
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.maxScore = 0;
		this.winningCounter =0;
		this.loosingCounter = 0;
	}
	
	protected Player(String userName, String passWord){
		
		//this.ID=null;
		this.userName = userName;
		this.passWord = passWord;
		this.maxScore = 0;
		this.winningCounter =0;
		this.loosingCounter = 0;
	}
	
	
	protected Player( String userName, String passWord,
			String firstName, String lastName, int maxScore,
			int winningCounter, int loosingCounter) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.maxScore = maxScore;
		this.winningCounter = winningCounter;
		this.loosingCounter = loosingCounter;
	}


	public Player() {
	}

	//***************************************** GETTERS AND SETTERS******************************************



	


	/**
	 * @return the userName
	 */
	protected String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	protected void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the passWord
	 */
	protected String getPassWord() {
		return passWord;
	}


	/**
	 * @param passWord the passWord to set
	 */
	protected void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	/**
	 * @return the firstName
	 */
	protected String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	protected String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the maxScore
	 */
	protected int getMaxScore() {
		return maxScore;
	}


	/**
	 * @param maxScore the maxScore to set
	 */
	protected void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}


	/**
	 * @return the winningCounter
	 */
	protected int getWinningCounter() {
		return winningCounter;
	}


	/**
	 * @param winningCounter the winningCounter to set
	 */
	protected void setWinningCounter(int winningCounter) {
		this.winningCounter = winningCounter;
	}


	/**
	 * @return the loosingCounter
	 */
	protected int getLoosingCounter() {
		return loosingCounter;
	}


	/**
	 * @param loosingCounter the loosingCounter to set
	 */
	protected void setLoosingCounter(int loosingCounter) {
		this.loosingCounter = loosingCounter;
	}
	
	
	// function update a new highest score 
	public boolean updateHighScore(int score){
		if (this.maxScore < score){
			this.maxScore = score;
			return true;
		}
		return false;		
	}
	
	// updating the winneng counter
	public void updateWinningCounter(){
		this.winningCounter++;
	}
	
	// update the loosing counter
	public void updateLosingCounter(){
		this.loosingCounter++;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((passWord == null) ? 0 : passWord.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [userName=" + userName + ", passWord="
				+ passWord + ", firstName=" + firstName + ", lastName="
				+ lastName + ", maxScore=" + maxScore + ", winningCounter="
				+ winningCounter + ", loosingCounter=" + loosingCounter + "]";
	}
	
	
	
	

}
