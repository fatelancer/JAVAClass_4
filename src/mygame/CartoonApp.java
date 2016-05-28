package mygame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by fatel on 2016/5/28.
 */
public class CartoonApp extends JFrame implements ActionListener{
    JPanel [] pnl = {new JPanel(new BorderLayout()),
                    new JPanel(new FlowLayout()),
                    new JPanel(new BorderLayout()),
                    new JPanel(new FlowLayout())};
    String [] str = {"North", "Center", "South"};
    JLabel lblTitle = new JLabel("我的第一个动画程序");
    JButton [] btn = {new JButton("start"), new JButton("pause"),
                        new JButton("resume"), new JButton("exit")};
    int x,y,z;
    Random rnd = new Random();
    Color [] c = {Color.red, Color.green, Color.blue,Color.pink, Color.yellow};
    CartoonPaint cp = new CartoonPaint();

    public CartoonApp(){
        pnl[1].add(lblTitle);
        pnl[2].add("Center", cp);
        for (int i = 0; i<btn.length;i++){
            btn[i].addActionListener(this);
            pnl[3].add(btn[i]);
        }
        for (int i = 0;i<pnl.length-1;i++){
            pnl[0].add(str[i], pnl[i+1]);
        }
        this.setContentPane(pnl[0]);
    }

    public void actionPerformed(ActionEvent ae) {
        try{
            if (ae.getSource()==btn[0]){

            }else if (ae.getSource()==btn[1]){

            }else if (ae.getSource()==btn[2]){

            }else if (ae.getSource()==btn[3]){
                System.exit(0);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }

    class CartoonPaint extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(c[0]);
            g.drawOval(10,10,100,100);
            g.fillOval(120,10,100,100);
            g.drawRect(230,10,100,100);
            g.fillRect(340,10,100,100);
            int [] x1 = {100, 50,150};
            int [] y1 = {50,150, 150};
            g.drawPolygon(new Polygon(x1,y1,x1.length));
        }
    }

    public static void main (String [] args){
        CartoonApp ca = new CartoonApp();
        ca.setTitle("我的第一个动画程序");
        ca.setBounds(300,200,400,450);
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ca.setVisible(true);
    }
}
