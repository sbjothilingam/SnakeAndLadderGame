/* COntrollerPlayer1.java
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

public class ControllerPlayer1 implements ActionListener
{
	ViewPlayer1 v;
    static int score1;
	
    @Override
    public void actionPerformed(ActionEvent e) {
		/*if(player2()){
		ViewPlayer1.player2=true;
        ViewPlayer1.player1=false;
        ViewPlayer1.player2status=true;
        score2=getPlayer2Score();
        score2=score2+1;
        JOptionPane.showMessageDialog(null, "Player 2 score: "+score2);
        ViewPlayer1.scorep2=ViewPlayer1.scorep2+score2;
        if(ViewPlayer1.scorep2-1==24){
            ViewPlayer1.name.setText("PLAYER 2 HAS WON");
            JOptionPane.showMessageDialog(null, "Player 2 Has Won");
            System.exit(0);
        }
        if(ViewPlayer1.scorep2-1<24){
            if(ViewPlayer1.scorep2-1==13){
                ViewPlayer1.scorep2=5;
            }
            else if(ViewPlayer1.scorep2-1==18){
                ViewPlayer1.scorep2=7;
            }
            else if(ViewPlayer1.scorep2-1==23){
                ViewPlayer1.scorep2=2;
            }
            else if(ViewPlayer1.scorep2-1==4){
                ViewPlayer1.scorep2=15;
            }
            else if(ViewPlayer1.scorep2-1==10){
                ViewPlayer1.scorep2=22;
            }
            ViewPlayer1.player2x=ViewPlayer1.xaxis[ViewPlayer1.scorep2-1];
            ViewPlayer1.player2y=ViewPlayer1.p2y[ViewPlayer1.scorep2-1];
            v=new ViewPlayer1();
		}
		}*/
            try {
                ViewPlayer1.player1=true;
                ViewPlayer1.player2=false;
                ViewPlayer1.player1status=true;
                //generates numbers between 1 to 6 for the dice
                score1=(int) (Math.random()*6);
                score1=score1+1;
				setPlayer1Score(score1);
				
                JOptionPane.showMessageDialog(null, "Player 1 score: "+score1);
                ViewPlayer1.scorep1=ViewPlayer1.scorep1+score1;
                //if the player has reached the end point then the player wins
                if(ViewPlayer1.scorep1-1==24){
                ViewPlayer1.name.setText("PLAYER 1 HAS WON");
                JOptionPane.showMessageDialog(null, "Player 1 Has Won");
                System.exit(0);
                }
            //conditions for the snakes and ladders on the board
            if(ViewPlayer1.scorep1-1<24){
            if(ViewPlayer1.scorep1-1==13){
                ViewPlayer1.scorep1=5;
            }
            else if(ViewPlayer1.scorep1-1==18){
                ViewPlayer1.scorep1=7;
            }
            else if(ViewPlayer1.scorep1-1==23){
                ViewPlayer1.scorep1=2;
            }
            else if(ViewPlayer1.scorep1-1==4){
                ViewPlayer1.scorep1=15;
            }
            else if(ViewPlayer1.scorep1-1==10){
                ViewPlayer1.scorep1=22;
            }
            ViewPlayer1.player1x=ViewPlayer1.xaxis[ViewPlayer1.scorep1-1];
            ViewPlayer1.player1y=ViewPlayer1.p1y[ViewPlayer1.scorep1-1];
                v=new ViewPlayer1();
				ViewPlayer1.dice.setEnabled(false);
            }
            //if the dice score is exceeds the number of grids in the board then it is a 
            //invalid score
            else{
            JOptionPane.showMessageDialog(null, "Player 1 Invalid score "+score1);
            ViewPlayer1.scorep1=ViewPlayer1.scorep1-score1;
            ViewPlayer1.player1=true;
            ViewPlayer1.player2=false;
        }   } catch (Exception ex) {
                Logger.getLogger(ControllerPlayer1.class.getName()).log(Level.SEVERE, null, ex);
            }
		
			
	}
         
	public void setPlayer1Score(int score1){
	  System.out.println("Set 1 method called");
		try{
       GameServerInterface rmiServer;

       try{
           rmiServer=
              (GameServerInterface)Naming.lookup("rmi://129.21.30.38 : 35678/rmiServer");
			rmiServer.setPlayer1Score(score1-1);
			}catch(Exception e){}
		}catch(Exception e){}
	}
	
	
    static public void main(String args[])
    {
		new ModelPlayer1();
	
	}
}