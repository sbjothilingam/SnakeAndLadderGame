/* COntrollerPlayer22.java
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
* This is Controller for refresh button
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

public class ControllerPlayer22 implements ActionListener
{
	ViewPlayer2 v;
	static int score2=0;
	@Override
    public void actionPerformed(ActionEvent e) {
		if(player1()){
				score2=getPlayer1Score();
				ViewPlayer2.player1=true;
                ViewPlayer2.player2=false;
                ViewPlayer2.player1status=true;
                //generates numbers between 1 to 6 for the dice
                score2=score2+1;
                JOptionPane.showMessageDialog(null, "Player 1 score: "+score2);
                ViewPlayer2.scorep1=ViewPlayer2.scorep1+score2;
                //if the player has reached the end point then the player wins
                if(ViewPlayer2.scorep1-1==24){
                ViewPlayer2.name.setText("PLAYER 1 HAS WON");
                JOptionPane.showMessageDialog(null, "Player 1 Has Won");
                System.exit(0);
                }
            //conditions for the snakes and ladders on the board
            if(ViewPlayer2.scorep1-1<24){
            if(ViewPlayer2.scorep1-1==13){
                ViewPlayer2.scorep1=5;
            }
            else if(ViewPlayer2.scorep1-1==18){
                ViewPlayer2.scorep1=7;
            }
            else if(ViewPlayer2.scorep1-1==23){
                ViewPlayer2.scorep1=2;
            }
            else if(ViewPlayer2.scorep1-1==4){
                ViewPlayer2.scorep1=15;
            }
            else if(ViewPlayer2.scorep1-1==10){
                ViewPlayer2.scorep1=22;
            }
            ViewPlayer2.player1x=ViewPlayer2.xaxis[ViewPlayer2.scorep1-1];
            ViewPlayer2.player1y=ViewPlayer2.p1y[ViewPlayer2.scorep1-1];
                new ViewPlayer2();
			ViewPlayer2.dice.setEnabled(true);
            }
            //if the dice score is exceeds the number of grids in the board then it is a 
            //invalid score
            else{
            JOptionPane.showMessageDialog(null, "Player 1 Invalid score "+score2);
            ViewPlayer2.scorep1=ViewPlayer2.scorep1-score2;
            ViewPlayer2.player1=true;
            ViewPlayer2.player2=false;
				}
		}
	}
	boolean player1(){
		int chck=0;
		try{
       GameServerInterface rmiServer;

       try{

           rmiServer=
              (GameServerInterface)Naming.lookup("rmi://129.21.30.38 : 35678/rmiServer");
			if(rmiServer.getPlayer1Status()){
				chck=1;
			}
			}catch(Exception e){}
		}catch(Exception e){}
		if(chck==1)
			return true;
		else
			return false;
	}
	int getPlayer1Score(){
	int score=0;
		try{
       GameServerInterface rmiServer;

       try{
           rmiServer=
              (GameServerInterface)Naming.lookup("rmi://129.21.30.38 : 35678/rmiServer");
			score=rmiServer.getPlayer1Score();
			}catch(Exception e){}
		}catch(Exception e){}
		return score;
	}
}