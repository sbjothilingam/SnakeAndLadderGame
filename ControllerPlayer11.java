/* COntrollerPlayer11.java
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

public class ControllerPlayer11 implements ActionListener
{
	ViewPlayer1 v;
	static int score2;
	@Override
    public void actionPerformed(ActionEvent e) {
		if(player2()){
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
			ViewPlayer1.dice.setEnabled(true);
		}
		else{
            JOptionPane.showMessageDialog(null, "Player 2 Invalid score "+score2);
            ViewPlayer1.scorep2=ViewPlayer1.scorep2-score2;
            ViewPlayer1.player1=false;
            ViewPlayer1.player2=true;
				}
		}
	}
	boolean player2(){
	int chck=0;
		try{
       GameServerInterface rmiServer;

       try{

           rmiServer=
              (GameServerInterface)Naming.lookup("rmi://129.21.30.38 : 35678/rmiServer");
			if(rmiServer.getPlayer2Status()){
				chck=1;
			}
			}catch(Exception e){}
		}catch(Exception e){}
		if(chck==1)
			return true;
		else
			return false;
	}
	int getPlayer2Score(){
	int score=0;
		try{
       GameServerInterface rmiServer;

       try{

           rmiServer=
              (GameServerInterface)Naming.lookup("rmi://129.21.30.38 : 35678/rmiServer");
			score=rmiServer.getPlayer2Score();
				
			}catch(Exception e){}
		}catch(Exception e){}
		return score;
	}
}