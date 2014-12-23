/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import utils.MyFileLogWriter;

/**
 *
 * @author siwar
 */
public class ModelLogic implements Serializable  {
    
    /**
	 * 
	 */
	
	//***************************************** Variables *********************************************
	/**Singleton instance of this class, loaded on the first execution of ModelLogic.getInstance()*/
	private static ModelLogic instance;
	/**Boolean flag for class instance existence (singleton)*/
	private static boolean exists = false;
	/**SysData reference pointer*/
	private static SysData sData; 
	/**Serilizing the ModelLogic class*/
	private static final long serialVersionUID = 1L;
	/** the current game */
	private game currentGame;
	/** indication of winning */
	private int flag = 0;
        /** total amount of player's cards */
        private int amountOfPlayerCards = 0;
        /** total amount of dealer's cards */
        private int amountOfDealerCards = 0;
	//***************************************** Constructors ******************************************
	/**
	 * Full C'tor, for singleton support. 
	 */
	private ModelLogic() {
		MyFileLogWriter.initializeMyFileWriter();
                currentGame = new game();
	}
	//***************************************** Methods ***********************************************
	/**
	 * The method creates this class's instance & provides access to it, by returning a reference (singleton).
	 * @return reference to this class's only instance, or null if reference was already returned (singleton).
	 * @throws GeneralException 
	 */
	public static ModelLogic getInstance() {
		if(! exists){
			sData = SysData.getInstance(); // creating the sDatat instance
			
			if(sData != null){ 
				sData.buildCards(); // activating the biulding cards function
				SysData.executeInput(); // creating the input file
				exists = true; // accessing this func may be done only once
				instance  = new ModelLogic(); // creating the model logic instance
				return instance; // returning model logic instance
			}
		}return null;
	}
        
        
	
	//***************************************** CRUD Methods ******************************************
    
        public ArrayList<Card> getCards(){
            return sData.getCards(); // returning the deck ready for dealing
        }
        
       //siwar
        public game startGame(){
        game g = new game(1); // creating game 1
		g.setDeck(sData.getCards()); // setting the deck to the one returning from getCards() func
		//g.OpenRound(); // openning a new round
		//g.Deal(); // activating DEAL FUNCTION
		g.startGame();
                System.err.print(g.toString());
                this.currentGame = g;
        return g; // returning the game which created
	}
	
	/*public  void buildCards(){
	
            
            
		/*ArrayList<Card> cardsWithCloverNumbers = new ArrayList<Card>(); //black ones
		ArrayList<Card> cardsWithLeafNumbers = new ArrayList<Card>(); // black ones
		ArrayList<Card> cardsWithHearts = new ArrayList<Card>(); //red ones
		ArrayList<Card> cardsWithDiamonds = new ArrayList<Card>(); //red ones
		
		cardsWithCloverNumbers.add(new Card(1, Color.BLACK, Suit.CLOVER, Letter.A, "1BC.png"));
		cardsWithLeafNumbers.add(new Card(1, Color.BLACK, Suit.LEAF, Letter.A,"1BL.png"));
		cardsWithHearts.add(new Card(1, Color.RED, Suit.HEART, Letter.A, "1RH.png"));
		cardsWithDiamonds.add(new Card(1, Color.RED, Suit.DIAMOND, Letter.A, "1RD.png"));
		
		//BUILDING THE REDULAR CARDS FROM VALUE 2 TO 10
		for (int i=2; i< 11; i++){
			cardsWithCloverNumbers.add(new Card(i, Color.BLACK, Suit.CLOVER, (i+"BC.png")));
			cardsWithLeafNumbers.add(new Card(i, Color.BLACK, Suit.LEAF,(i+"BL.png")));
			cardsWithHearts.add(new Card(i, Color.RED, Suit.HEART,(i+"RH.png")));
			cardsWithDiamonds.add(new Card(i, Color.RED, Suit.DIAMOND, (i+"RD.png")));
			
		}
		
		// clover pictures
		cardsWithCloverNumbers.add(new Card(10, Color.BLACK, Suit.CLOVER, Letter.J, "11BC.png"));
		cardsWithCloverNumbers.add(new Card(10, Color.BLACK, Suit.CLOVER, Letter.K, "13BC.png"));
		cardsWithCloverNumbers.add(new Card(10, Color.BLACK, Suit.CLOVER, Letter.Q, "12BC.png"));
		
		
		// Leaf pictures
		cardsWithLeafNumbers.add(new Card(10, Color.BLACK, Suit.LEAF, Letter.J, "11BL.png"));
		cardsWithLeafNumbers.add(new Card(10, Color.BLACK, Suit.LEAF, Letter.K, "13BL.png"));
		cardsWithLeafNumbers.add(new Card(10, Color.BLACK, Suit.LEAF, Letter.Q, "12BL.png"));
		
		
		// hEART pictures
		cardsWithHearts.add(new Card(10, Color.RED, Suit.HEART, Letter.J, "11RH.png"));
		cardsWithHearts.add(new Card(10, Color.RED, Suit.HEART, Letter.K, "13RH.png"));
		cardsWithHearts.add(new Card(10, Color.RED, Suit.HEART, Letter.Q, "12RH.png"));
		
		
		// DIAMOND pictures
		cardsWithDiamonds.add(new Card(10, Color.RED, Suit.DIAMOND, Letter.J, "11RD.png"));
		cardsWithDiamonds.add(new Card(10, Color.RED, Suit.DIAMOND, Letter.K, "13RD.png"));
		cardsWithDiamonds.add(new Card(10, Color.RED, Suit.DIAMOND, Letter.Q, "12RD.png"));
		//cardsWithDiamonds.add(new Card(1, Color.RED, Suit.DIAMOND, Letter.A));
		
		//returning arraylist
		ArrayList<Card> arr = new ArrayList<Card>();
		
		//ADDING ALL THE CARDS FORM DIFFERENT TYPES
		arr.addAll(cardsWithCloverNumbers);
		arr.addAll(cardsWithLeafNumbers);
		arr.addAll(cardsWithHearts);
		arr.addAll(cardsWithDiamonds);
                
		
		sData.setCards(arr);	
		
	}*/
	
	
	/*public String hitFunc(){
           /* System.err.println("ENTERRING HIT FUNC");
		Card card;
//		Player p = this.currentGame.getPlayer();
                if (this.currentGame== null)
                    System.err.println("here is the problem");
                System.err.println("size of array: "+ this.currentGame.toString());
                System.err.println(this.currentGame.getRounds().size());
		Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
		
		
		card = round.hit();
		this.amountOfPlayerCards = round.getPlayerHand().getAmountOfCards();
                
                if (round.isCheck()){
                    if (this.amountOfPlayerCards == 21){
				this.flag = 1;
                    }
                    
                    
                }
                else{
                    this.flag = -1; 
                    
                }
                return card.getImage();
            //SIWAR 
            System.err.println("ENTERRING HIT FUNC");
		Card card;
//		Player p = this.currentGame.getPlayer();
                if (this.currentGame== null)
                    System.err.println("here is the problem");
                //System.err.println("size of array: "+ this.currentGame.toString());
                System.err.println("size of round: "+this.currentGame.getRounds().size());
		Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
		
		
		card = round.hit();
		this.amountOfPlayerCards = round.getPlayerHand().getAmountOfCards();
                
                if (round.isCheck()){
                    if (this.amountOfPlayerCards == 21){
			this.flag = 1;
                    }
                    else{
                        if (this.amountOfPlayerCards > 21){
                            this.flag = -1;
                        }
                    }
                }
                else{
                    if (this.amountOfPlayerCards > 21){
                            this.flag = -1;
                        }
                    
                    
                }
                return card.getImage();
				
	}

        /*StandFunc compares the amount of cards between the dealer and the player and returns the array of cards 
        public ArrayList<String> standFunc(){
          /*  ArrayList<String> arr = new ArrayList<>();
            ArrayList<Card> dealerCards = new ArrayList<>();
            Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
            //call for stand() function in Round class
            dealerCards = round.stand();
            // supplying the string array
            for (Card c : dealerCards){
               arr.add(c.getImage());
            }
            // get the amount of dealer cards in order to check it and compare it to the player's amount of cards
            this.amountOfDealerCards = round.getDealerHand().getAmountOfCards();
            //if the dealer's amount of cards is more than 21: the dealer loses
            if (this.amountOfDealerCards  > 21)
                this.flag = 1;
            //if the dealer's amount of cards is equal to 21: the dealer wins
            if (this.amountOfDealerCards == 21)
                this.flag = -1;
            //if the dealers amount of cards is more than or equal to the player's amount of cards: the dealer wins
            if (this.amountOfDealerCards >= this.amountOfPlayerCards)
                this.flag = -1;
            else
                this.flag = 1;
            return arr;
            //siwar
            ArrayList<String> arr = new ArrayList<>();
            ArrayList<Card> dealerCards = new ArrayList<>();
            Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
            //call for stand() function in Round class
            dealerCards = round.stand();
            
            // supplying the string array
            for (Card c : dealerCards){
               arr.add(c.getImage());
            }
            // get the amount of dealer cards in order to check it and compare it to the player's amount of cards
            this.amountOfPlayerCards = round.getPlayerHand().getAmountOfCards();
            this.amountOfDealerCards = round.getDealerHand().getAmountOfCards();
            System.err.println("the player's sum: "+ this.amountOfPlayerCards);
            System.err.println("the dealer's sum: "+ this.amountOfDealerCards);
            //if the dealer's amount of cards is more than 21: the dealer loses
            if (this.amountOfDealerCards  > 21){
                this.flag = 1;
            }
           
            //if the dealer's amount of cards is equal to 21: the dealer wins
            else  if (this.amountOfDealerCards == 21)
                this.flag = -1;
            //if the dealers amount of cards is more than or equal to the player's amount of cards: the dealer wins
            else if (this.amountOfDealerCards >= this.amountOfPlayerCards)
                this.flag = -1;
            else if (this.amountOfDealerCards < this.amountOfPlayerCards)
                this.flag = 1;
            else
                this.flag = 1;
            return arr;
        }
        
        public ArrayList<String> PlayerHand(){
            Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
            ArrayList<String> arr = new ArrayList<>();
            for (Card c : round.getPlayerHand().getCards() ){
                arr.add(c.getImage());
            }
            return arr ;
        }
        
        public ArrayList<String> DealerHand(){
            Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
            ArrayList<String> arr = new ArrayList<>();
            for (Card c : round.getDealerHand().getCards() ){
                arr.add(c.getImage());
            }
            return arr;
        }*/
        
        public String hitFunc(){

            //SIWAR	
       		String card = this.currentGame.hitFunc();
               this.flag= this.currentGame.getFlag();
               return card;
       				
       	}

               /*StandFunc compares the amount of cards between the dealer and the player and returns the array of cards */
               public ArrayList<String> standFunc(){
                //siwar
                   
                
               	ArrayList<String> setOfCardsToDealer = this.currentGame.standFunc();
               	this.flag = this.currentGame.getFlag();
               	
               	return setOfCardsToDealer;
               }
               
               public ArrayList<String> PlayerHand(){
                 
               	return this.currentGame.PlayerHand();
               }
               
               public ArrayList<String> DealerHand(){
                  
               	return this.currentGame.DealerHand();
               }
               
        
        
        
        
	
	public int getFlag(){
		return this.flag;
                
	}
	
    public int getPlayerHand()
    {
        Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
        return round.getPlayerAmount();       
    }
    
     public int getDealerHand()
    {
        Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
        return round.getDelaerAmount();       
    }
     
       public int getDealerHandAfterStand()
    {
        Round round = this.currentGame.getRounds().get(this.currentGame.sizeOfCurrentRound);
        return round.getDelaerAmountAfterStand();       
    }
     
     public int checkWinOnStart()
     {
        return this.currentGame.getwinOnStart();
     }
     
     
     /**
		 * @return the sData
		 */
		public SysData getsData() {
			return sData;
		}
       
        
	//********************************** Layer's closure procedure methods ****************************
    
    /*
     * Calls the method from SDATA which prints the output from executing the file
     */   
	public void executeSysExit()
	{
		sData.executeOutput();
	}

        
    
    
}
