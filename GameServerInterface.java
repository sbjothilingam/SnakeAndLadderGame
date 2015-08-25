/* GameServerInterface.java
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
* This is Interface for the server class
*
* @author       Nitish Krishna Ganesan
* @author       Suresh Babu Jothilingam
*/
import java.rmi.*;
public interface GameServerInterface extends Remote
{
   void setPlayer1Score(int score1) throws RemoteException;
   void setPlayer2Score(int score2) throws RemoteException;
   int getPlayer1Score() throws RemoteException;
   int getPlayer2Score() throws RemoteException;
   boolean getPlayer1Status() throws RemoteException;
   boolean getPlayer2Status() throws RemoteException;
   }