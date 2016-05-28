package test;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class CartoonApp extends JFrame implements ActionListener{

   JPanel [] pnl={new JPanel(new BorderLayout()),
                          new JPanel(new FlowLayout()),
                          new JPanel(new GridLayout(3,3)), 
	         new JPanel(new FlowLayout())};
   String [] str={"North","Center","South"}; 
   JLabel lblTitle=new JLabel("我的第一个动画程序");
   JButton [] btn={new JButton("三角形"),new JButton("矩形"),
                             new JButton("椭圆"),new JButton("exit")};
    int x,y,z;
    Random rnd=new Random();
    Color [] c={Color.red,Color.green,Color.blue,Color.pink,Color.yellow};  
    Toolkit tk=Toolkit.getDefaultToolkit();
    Image pic1,pic2,pic3,back;

    JPanel [] p=new JPanel[9];
    
    static int count=0;

   public CartoonApp(){      

       pnl[1].add(lblTitle);

      for(int i=0;i<p.length;i++){
          p[i]=new JPanel(new BorderLayout());
          pnl[2].add(p[i]);
       }
    
       for(int i=0;i<btn.length;i++){
           btn[i].addActionListener(this);
           pnl[3].add(btn[i]);
       }
       for(int i=0;i<pnl.length-1;i++){
          pnl[0].add(str[i],pnl[i+1]);
       }
       this.setContentPane(pnl[0]);
   }
   public void actionPerformed(ActionEvent ae){
       try{
       	  if(count<9){
       	  
           if(ae.getSource()==btn[0]){
           	  TrianglePanel tp=new TrianglePanel();
              p[count].add("Center",tp);
              tp.repaint();
              pnl[2].validate();   
             
           }else if(ae.getSource()==btn[1]){
           	  RectPanel rp=new RectPanel();
              p[count].add("Center",rp);
              rp.repaint();
              pnl[2].validate();  
           }else if(ae.getSource()==btn[2]){
           	  OvalPanel op=new OvalPanel();
              p[count].add("Center",op);
              op.repaint();
              pnl[2].validate();  
           }
           count++;
          }
           if(ae.getSource()==btn[3]){
               System.exit(0);
           }
       }catch(Exception ex){
          JOptionPane.showMessageDialog(null,ex.getMessage());
       }
   }
      class TrianglePanel extends JPanel{
      public void paintComponent(Graphics g){
      	  Graphics2D g2d=(Graphics2D)g;
      	  super.paintComponent(g2d);
          g2d.setColor(c[0]);
          int [] x={getWidth()/2,0,getWidth()};
          int [] y={0,getHeight(),getHeight()};
          g2d.fillPolygon(x,y,x.length);
      }
   }

   class RectPanel extends JPanel{
      public void paintComponent(Graphics g){
      	  Graphics2D g2d=(Graphics2D)g;
      	  super.paintComponent(g2d);
          g.setColor(c[1]);
          g.fillRect(0,0,getWidth(),getHeight());
      }
   }

   class OvalPanel extends JPanel{
      public void paintComponent(Graphics g){
      	  Graphics2D g2d=(Graphics2D)g;
      	  super.paintComponent(g2d);
          g.setColor(c[2]);
          g.fillOval(0,0,getWidth(),getHeight());
      }
   }
   public static void main(String [] args){
       CartoonApp ca=new CartoonApp();
       ca.setTitle("我的第一个动画程序");
       ca.setBounds(300,200,400,450);
       ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ca.setVisible(true);
   }
}
                                        