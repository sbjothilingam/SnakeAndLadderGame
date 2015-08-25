/* GameServer.java
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
* This is implementation for the server interface class
*
* @author       Nitish Krishna Ganesan
* @author       Suresh Babu Jothilingam
*/

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.net.*;
 
public class GameServer extends java.rmi.server.UnicastRemoteObject
implements GameServerInterface
{
	int score1,score2;
	boolean player1=false;
	boolean player2=false;
    int      thisPort;
    String   thisAddress;
    Registry registry;    

   public void setPlayer1Score(int score1) throws RemoteException{
    System.out.println("Player1 set");
	this.player1=true;
	this.score1=score1;
   }
   public void setPlayer2Score(int score2) throws RemoteException{
    System.out.println("Player2 set");
    this.player2=true;
	this.score2=score2;
   }
   public int getPlayer1Score() throws RemoteException{
    System.out.println("Player1 got");
    this.player1=false;
	return score1;
   }
   public int getPlayer2Score() throws RemoteException{
    System.out.println("Player2 got");
    this.player2=false;
	return score2;
   }
   public boolean getPlayer1Status() throws RemoteException{
	return player1;
   }
   public boolean getPlayer2Status() throws RemoteException{
	return player2;
   }
	
    public GameServer() throws RemoteException
    {
    }
   
    static public void main(String args[])
    {
        try{
        GameServerInterface s=new GameServer();
	 Naming.rebind("rmi://129.21.30.38 : 35678/rmiServer");
    }
    catch (Exception e) {
           e.printStackTrace();
           System.exit(1);
    }
     }
}