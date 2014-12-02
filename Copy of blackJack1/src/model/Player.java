package model;

public class Player {
	
	private String ID;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private int maxScore;
	private int winningCounter;
	private int loosingCounter;
	
	protected Player(String iD, String userName, String passWord,
			String firstName, String lastName) {
		super();
		ID = iD;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.maxScore = 0;
		this.winningCounter =0;
		this.loosingCounter = 0;
	}
	
	
	protected Player(String iD, String userName, String passWord,
			String firstName, String lastName, int maxScore,
			int winningCounter, int loosingCounter) {
		super();
		ID = iD;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.maxScore = maxScore;
		this.winningCounter = winningCounter;
		this.loosingCounter = loosingCounter;
	}


	public Player() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the iD
	 */
	protected String getID() {
		return ID;
	}


	/**
	 * @param iD the iD to set
	 */
	protected void setID(String iD) {
		ID = iD;
	}


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
	
	public boolean updateHighScore(int score){
		if (this.maxScore < score){
			this.maxScore = score;
			return true;
		}
		return false;		
	}
	
	public void updateWinningCounter(){
		this.winningCounter++;
	}
	
	public void updateLosingCounter(){
		this.loosingCounter++;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [ID=" + ID + ", userName=" + userName + ", passWord="
				+ passWord + ", firstName=" + firstName + ", lastName="
				+ lastName + ", maxScore=" + maxScore + ", winningCounter="
				+ winningCounter + ", loosingCounter=" + loosingCounter + "]";
	}
	
	
	
	

}
