/* COntrollerPlayer2.java
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
* This is Controller for the dice
*
* @author       Nitish Krishna Ganesan
* @author       Suresh Babu Jothilingam
*/
import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerPlayer2 implements ActionListener
{
	ViewPlayer2 v;
    static int score1=0;
    @Override
    public void actionPerformed(ActionEvent e) {
	
        ViewPlayer2.player2=true;
        ViewPlayer2.player1=false;
        ViewPlayer2.player2status=true;
        score1=(int) (Math.random()*6);
        score1=score1+1;
		setPlayer2Score(score1);
        JOptionPane.showMessageDialog(null, "Player 2 score: "+score1);
        ViewPlayer2.scorep2=ViewPlayer2.scorep2+score1;
        if(ViewPlayer2.scorep2-1==24){
            ViewPlayer2.name.setText("PLAYER 2 HAS WON");
            JOptionPane.showMessageDialog(null, "Player 2 Has Won");
            System.exit(0);
        }
        if(ViewPlayer2.scorep2-1<24){
            if(ViewPlayer2.scorep2-1==13){
                ViewPlayer2.scorep2=5;
            }
            else if(ViewPlayer2.scorep2-1==18){
                ViewPlayer2.scorep2=7;
            }
            else if(ViewPlayer2.scorep2-1==23){
                ViewPlayer2.scorep2=2;
            }
            else if(ViewPlayer2.scorep2-1==4){
                ViewPlayer2.scorep2=15;
            }
            else if(ViewPlayer2.scorep2-1==10){
                ViewPlayer2.scorep2=22;
            }
            ViewPlayer2.player2x=ViewPlayer2.xaxis[ViewPlayer2.scorep2-1];
            ViewPlayer2.player2y=ViewPlayer2.p2y[ViewPlayer2.scorep2-1];
            v=new ViewPlayer2();
			ViewPlayer2.dice.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Player 2 Invalid score "+score1);
            ViewPlayer2.scorep2=ViewPlayer2.scorep2-score1;
            ViewPlayer2.player2=true;
            ViewPlayer2.player1=false;
        }
	}
	public void setPlayer2Score(int score1){
		try{
       GameServerInterface rmiServer;

       try{

           rmiServer=
              (GameServerInterface)Naming.lookup("rmi://129.21.30.38 : 35678/rmiServer");
			rmiServer.setPlayer2Score(score1-1);
			}catch(Exception e){}
		}catch(Exception e){}
	}
	
	public static void main(String arg[]){
		new ModelPlayer2();

	}
}