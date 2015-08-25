/* ModelPlayer1.java
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
* This is a Model Class
*
* @author       Nitish Krishna Ganesan
* @author       Suresh Babu Jothilingam
*/
import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;


public class ModelPlayer1 {
    JFrame frame;
    ViewPlayer1 cp;
    //static variables coordinates for the player1 and player2 object to move
    //default constructor
    ModelPlayer1(){
        //Frame Creation
        frame=new JFrame("Snake and Ladder Using Swing");
        frame.setLayout(new GridLayout());
        //adding the panel to the frame
        cp=new ViewPlayer1();
        cp.create();
        frame.add(cp);
        frame.setSize(700, 700);
        frame.setVisible(true);
        
    }

}
