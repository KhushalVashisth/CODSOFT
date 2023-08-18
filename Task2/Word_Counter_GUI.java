//WORD COUNTER TASK 2
// PROMPT PROVIDED FOR THE USER TO ENTER THE SENTENCE
// THE USER ENTERS A TEXT
//TEXT IS SPLIT INTO WORDS
//COUNT THE NUMBER OF WORDS
// CREATE A GUI FOR MORE INTERACTIVE VIEW TO SHOW THE RESULT
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Word_Counter_GUI extends JFrame implements ActionListener{
     Label l1;
     Button b;
     JTextArea t;
Word_Counter_GUI(){
        JFrame f=new JFrame();
        l1=new Label("Words");
        l1.setBounds(55,80,100,20);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Verdana", Font.ITALIC, 12));
        t=new JTextArea();
        t.setBounds(50,110,300,200);
        t.setForeground(Color.WHITE);
        t.setFont(new Font("Verdana", Font.BOLD, 14));
        t.setBackground(Color.GRAY);
        b=new Button("Count Words");
        b.setForeground(Color.BLACK);
        b.setFont(new Font("Verdana", Font.ITALIC, 12));
        b.setBounds(50,320,80,30);
        b.addActionListener(this);
        add(b);
        add(l1);
        add(t);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
        f.getContentPane().setBackground(Color.YELLOW);
}
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b){
           String s = t.getText();
           if(s.length()==0){
               System.out.println("Empty string");
           }
           int count = 1;
           for (int i = 0;i<s.length();i++) {
               if(s.charAt(i)==' '&& s.charAt(i+1)!=' ')
                   count++;
           }
           l1.setText("Words="+count);
       }
    }
    public static void main(String[] args){
    new Word_Counter_GUI();
    }
}

