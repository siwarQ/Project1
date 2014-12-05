
package view;
import java.awt.*; 
import java.awt.geom.*; 
import javax.swing.*; 


public class RoundButton extends JButton { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RoundButton(String label) { 
        super( label ); 
        // enlarge the button so that it becomes a circle 
        Dimension size = getPreferredSize(); 
        size.width = size.height = Math.max( size.width, size.height ); 
        setPreferredSize( size ); 
        // tell JButton not to paint the background. 
        setContentAreaFilled( false ); 
    } 
    
    // Paint the round background and label. 
    protected void paintComponent( Graphics g ) { 
        if ( getModel().isArmed() ) { 
            // could make the highlight color a property of this RoundButton class. 
            g.setColor( Color.lightGray ); 
        } else { 
            g.setColor( getBackground() ); 
        } 
        // Create the gradient paint 
        java.awt.GradientPaint paint = new java.awt.GradientPaint( 
getWidth() / 2, getHeight() / 2, g.getColor(), 
                    getWidth() / 2, 0, Color.white, true ); 
        // we need to cast to Graphics2D for this operation 
        Graphics2D g2 = (Graphics2D) g; 
        // set the paint to use for this operation 
        g2.setPaint(paint); 
        // fill the entire background using the paint 
        g2.fillOval( 0, 0, getSize().width-1, getSize().height-1 ); 
        // This call will paint the label and the set focus rectangle. 
        super.paintComponent(g); 
    } 
    
    // Paint the border of the button using a simple stroke. 
    protected void paintBorder( Graphics g ) { 
        g.setColor( getForeground() ); 
        g.drawOval( 0, 0, getSize().width - 1, getSize().height - 1 ); 
    } 
    
    // Hit detection. 
    Shape shape; 
    public boolean contains( int x, int y ) { 
        // If the button has changed size ,make a new shape object. 
        if ( shape == null || !shape.getBounds().equals( getBounds() ) ) { 
            shape = new Ellipse2D.Float( 0, 0,getWidth(), getHeight() ); 
        } 
        return shape.contains( x, y ); 
    } 
  
} 
