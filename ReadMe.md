# JAVA Class 4

## 1. 基础面板搭建

```java
package mygame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fatel on 2016/5/28.
 */
public class CartoonApp extends JFrame implements ActionListener{
    public CartoonApp(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    class CartoonPaint extends JPanel{

    }

    public static void main (String [] args){
        CartoonApp ca = new CartoonApp();
        ca.setTitle("我的第一个动画程序");
        ca.setBounds(300,200,400,450);
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ca.setVisible(true);
    }
}

```

## 2. 变量定义
```java
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
```

## 3.基本图形绘制
```java
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
```

## 4. 异常
```java
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
```