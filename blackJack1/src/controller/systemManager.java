package controller;



import java.io.Serializable;




public class systemManager implements Serializable  {
	
	/**ControllerLogic reference pointer*/
    private static ControllerLogic controller;
    
    /**Serlizing the systemManager class*/
    private static final long serialVersionUID = 1L;

	
    /**
	 * The main method of the system.
	 * @param args'
	 */
        public static void main(String[] args) {
            controller = ControllerLogic.getInstance(); 
            controller.executeSysExit();
                        
}
        
	
	
	
	
	
	
}
