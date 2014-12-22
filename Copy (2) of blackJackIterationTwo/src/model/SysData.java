/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import utils.Constants;

/**
 *
 * @author siwar
 */
public class SysData implements Serializable  {
	
	 /**
	 * 
	 */
	//***************************************** Variables *********************************************
	/**Singleton instance of this class, loaded on the first execution of SysData.getInstance()*/  
	private static SysData instance;
	/**serlizing the sysData class*/
	private static final long serialVersionUID = 1L;	
	/**Stores all the players*/
	private ArrayList<Player> players; 
	/**Stores all the cards*/
    private  ArrayList<Card> cards;
    

	//***************************************** Constructors ******************************************
	/**
	 * Full C'tor, for singleton support. 
	 */
    private SysData(){
        players = new ArrayList<Player>();
        cards= new ArrayList<Card>();
       
    }


    protected static SysData getInstance() {
        executeInput(); // creating the output file
		if(instance==null){
			instance = new SysData(); // creating sysData instance
			return instance; // returning the instance of sData
		}
        else{
             return instance;
        }
	}
    
    //siwar
    protected void buildCards(){
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
                
		
		setCards(arr);	
		
	
    }


//***************************************** Getters & Setters *************************************
	/**
	 * @return the cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}
      
	/**
	 * setting the arrayList of cards
	 * @param ArrayList<Card> arr
	 */
     public void setCards(ArrayList<Card> arr) {
    	 this.cards =arr ;
	}
	/**
	 * @return the players
	 */
	protected ArrayList<Player> getPlayers() {
		return players;
	}


//********************************** Layer's closure procedure methods ****************************
    
    /*
     * Creating output input file
     */ 

	protected static void executeInput() {
		
        File f = new File(Constants.FILENAME);
        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(Constants.FILENAME);
                ObjectInputStream in = new ObjectInputStream(fis);
                instance = (SysData) in.readObject();
                in.close();
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } 
	}

	public void executeOutput() {				
	        try {
            FileOutputStream fos = new FileOutputStream(Constants.FILENAME);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(instance);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
 
}
