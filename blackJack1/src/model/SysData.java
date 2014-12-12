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
