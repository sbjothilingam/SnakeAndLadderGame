/* ViewPlayer2.java
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
* This is a View Class
*
* @author       Nitish Krishna Ganesan
* @author       Suresh Babu Jothilingam
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ViewPlayer2 extends JPanel{
    static JLabel name;
    static boolean player1,player2;
    static boolean player1status,player2status;
    static JButton dice,refresh;
    static int xaxis[]={150,250,350,450,550,550,450,350,250,150,150,250,350,450,550,550,450,350,250,150,150,250,350,450,550};
    static int p1y[]={520,520,520,520,520,420,420,420,420,420,320,320,320,320,320,220,220,220,220,220,120,120,120,120,120};
    static int p2y[]={560,560,560,560,560,460,460,460,460,460,360,360,360,360,360,260,260,260,260,260,160,160,160,160,160};
    static int scorep1,scorep2;
    static int player1x,player1y;
    static int player2x,player2y;
    //default constructor
    ViewPlayer2(){
        repaint();
    }
    void create(){
        name=new JLabel("");
        name.setPreferredSize(new Dimension(200,50));
        dice=new JButton("Dice");
        dice.setPreferredSize(new Dimension(300,50));
        add(dice);
        add(name);
        //action listener to the Dice button
		refresh=new JButton("REFRESH");
		refresh.setPreferredSize(new Dimension(100,100));
		add(refresh);
		refresh.addActionListener(new ControllerPlayer22());
        dice.addActionListener(new ControllerPlayer2());   
        repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(100, 100, 500, 500);
        g.setColor(Color.ORANGE);
            g.drawString("5", 580, 580);
            g.drawString("6", 580, 480);
            g.drawString("15", 580, 380);
            g.drawString("16", 580, 280);
            g.drawString("25", 580, 180);
            g.drawString("4", 480, 580);
            g.drawString("7", 480, 480);
            g.drawString("14", 480, 380);
            g.drawString("17", 480, 280);
            g.drawString("24", 480, 180);
            g.drawString("3", 380, 580);
            g.drawString("8", 380, 480);
            g.drawString("13", 380, 380);
            g.drawString("18", 380, 280);
            g.drawString("23", 380, 180);
            g.drawString("2", 280, 580);
            g.drawString("9", 280, 480);
            g.drawString("12", 280, 380);
            g.drawString("19", 280, 280);
            g.drawString("22", 280, 180);
            g.drawString("1", 180, 580);
            g.drawString("10", 180, 480);
            g.drawString("11", 180, 380);
            g.drawString("20", 180, 280);
            g.drawString("21", 180, 180);
        g.setColor(Color.WHITE);
        for(int i=100; i<600; i=i+100){
            g.drawLine(100, i, 600, i);
        }
        for(int i=100; i<600; i=i+100){
            g.drawLine(i, 100, i, 600);
        }
       g.setColor(Color.magenta);
            g.drawLine(125, 368, 230, 159);
            g.drawLine(150, 370, 260, 165);
            g.drawLine(565, 585, 565, 380);
            g.drawLine(590, 585, 590, 380);
       g.setColor(Color.GREEN);
            g.fillOval(250, 250, 25, 25);
            g.drawLine(270, 270, 450, 450);
            g.fillOval(450, 150, 25, 25);
            g.drawLine(460, 160, 240, 550);
            g.fillOval(450, 350, 25, 25);
            g.drawLine(460, 360, 530, 550);
            //moves the player 1 according to the score recieved
            if(player1status==true){
                g.setColor(Color.red);
                g.fillRect(player1x, player1y, 25, 25);
            }
            //moves player 2 according to the score received
            if(player2status==true){
                g.setColor(Color.BLUE);
                 g.fillRect(player2x, player2y, 25, 25);
            }
            repaint();
    }


}
    

