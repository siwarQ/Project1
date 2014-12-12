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
	
	//***************************************** Constructors ******************************************
	/**
	 * Full C'tor, for singleton support. 
	 */
	private ModelLogic() {
		MyFileLogWriter.initializeMyFileWriter();
	}
	//***************************************** Methods ***********************************************
	/**
	 * The method creates this class's instance & provides access to it, by returning a reference (singleton).
	 * @return reference to this class's only instance, or null if reference was already returned (singleton).
	 * @throws GeneralException 
	 */
	public static ModelLogic getInstance() throws IOException {
		if(! exists){
			sData = SysData.getInstance(); // creating the sDatat instance
			if(sData != null){ 
				SysData.executeInput(); // creating the input file
				exists = true; // accessing this func may be done only once
				instance  = new ModelLogic(); // creating the model logic instance
				return instance; // returning model logic instance
			}
		}return null;
	}
        
        
	
	//***************************************** CRUD Methods ******************************************
    
        public ArrayList<Card> getCards(){
            buildCards(); // building the cards function
            return sData.getCards(); // returning the deck ready for dealing
        }
        
        public game startGame(){
        game g = new game(1); // creating game 1
		g.setDeck(sData.getCards()); // setting the deck to the one returning from getCards() func
		g.OpenRound(); // openning a new round
		g.Deal(); // activating DEAL FUNCTION
        return g; // returning the game which created
	}
	
	public  void buildCards(){
            
            
		ArrayList<Card> cardsWithCloverNumbers = new ArrayList<Card>(); //black ones
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
