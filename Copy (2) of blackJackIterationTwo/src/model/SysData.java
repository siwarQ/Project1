/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
	private static final long serialVersionUID = 3482080340125280481L;
	/**
	 * 
	 */
	//***************************************** Variables *********************************************
	/**Singleton instance of this class, loaded on the first execution of SysData.getInstance()*/  
	private static SysData instance;
	/**serlizing the sysData class*/
        
        private static boolean exists = false;
	/**Stores all the players*/
	private static ArrayList<Player> players;
	/**Stores all the cards*/
        private static  ArrayList<Card> cards;
        
        private game currentGame;
    

	//***************************************** Constructors ******************************************
	/**
	 * Full C'tor, for singleton support. 
	 */
    private SysData(){
     //   players = new ArrayList<Player>();
        cards= new ArrayList<Card>();
        System.err.println("IM IN THE CONSTRUCTORRRRRR");
      //  players.add(new Player("aaa", "111"));
      
    }


    protected static SysData getInstance() {
        executeInput(); // creating the output file
        System.err.println("NOT NULL");
		if(instance==null){
                    System.err.println("IMMMMMMMMMMMMMMMMMMMMMMMMMMMM//////////////////////");
                        setExists(true);
			instance = new SysData(); // creating sysData instance  
			return instance; // returning the instance of sData
		}
        else{
                    setExists(true);
             return instance;
        }
	}
    
    
    
         
       /* public Player checkLogIn(String name, String passWord){ //////////////////////////////////////////////////////////////
                  Player p1= new Player("leew", "100", "lee", "amiel");
                  System.err.println(p1.toString());
                  players.add(p1);
        	for(Player p: players){
        		if (p.getUserName().equals(name) && p.getPassWord().equals(passWord)){
        			System.err.println("Player: "+ p.toString());
                               // s= p.getUserName();
        			return p;
        			
        			
        		}
        	}
        	System.err.println("no players");
        	return null;      	
        }*/
      public boolean addNewUser( String userName, String pass, String firstName, String lastName)
         {
             Player p = new Player(userName, pass, firstName, lastName);
             executeOutput();
             if ( players.add(p)){
                 
                 return true;
             }
             else
                 return false;
         }
    
    protected void buildCards(){
        
        currentGame = new game(1);
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
        public game getGame() {
		return currentGame;
	}
      
	/**
	 * setting the arrayList of cards
	 * @param ArrayList<Card> arr
	 */
     public void setCards(ArrayList<Card> arr) {
    	 SysData.cards =arr ;
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

	 public static void executeInput() {
		// TODO Auto-generated method stub      //<<<--- for 3rd HW.
            
                //    File f = new File(Constants.FILENAME);
                    players = new ArrayList<>();
                    
    	try
    	{
    		FileInputStream fileIn = new FileInputStream(Constants.FILENAME);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		Object obj = in.readObject();
    		if(obj instanceof ArrayList<?>){
    			ArrayList<?> al = (ArrayList<?>) obj;
    			for(int i=0; i<al.size();i++){
    				Object o = al.get(i);
    				if(o instanceof Player)
    				{
                                    System.err.println(((Player) o).toString());
                                    players.add((Player) o);
    				}
    			}
    		}
    		in.close();
    		fileIn.close();
    	}catch(IOException i)
    	{
    		i.printStackTrace();
    		return;
    	}catch(ClassNotFoundException c)
    	{
    		System.out.println("Users Array not found");
    		c.printStackTrace();
    		return;
    	}
                    
        /*
               FileInputStream fis = new FileInputStream(Constants.FILENAME) ;
                    ObjectInputStream in = new ObjectInputStream(fis);
                    Object obj = in.readObject();
                        if(obj instanceof ArrayList<?>){
                                ArrayList<?> al = (ArrayList<?>) obj;
                                for(int i=0; i<al.size();i++){
                                        Object o = al.get(i);
                                        if(o instanceof Player) 
                                        {
                                                players.add((Player) o);
                                        }
                                }
                        }
                        
                    //instance = (SysData) in.readObject();
                    in.close();
                    fis.close();
           
        } */
	}

	public void executeOutput() {				//<<<--- for 3rd HW.
	        try {
            FileOutputStream fos = new FileOutputStream(Constants.FILENAME);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(players);
            out.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}


	public static boolean isExists() {
		return exists;
	}


	public static void setExists(boolean exists) {
		SysData.exists = exists;
	}
 
}
