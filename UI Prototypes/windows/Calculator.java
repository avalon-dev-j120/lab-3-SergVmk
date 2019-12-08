
package windows;
import java.awt.*;
import java.awt.event.*;
import java.awt.Frame.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;
import java.text.*;
import javax.swing.text.*;
import javax.swing.*;
import java.util.*;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.event.ChangeEvent;
import javax.swing.text.NumberFormatter;

public class Calculator extends JFrame{
    private static class Constants 
    {
        static final int WIDTH = 220;
        static final int HEIGHT = 280;
    }
    private String operation;
    private JPanel jpaneltext;
    private JPanel jpanelbuttons;
    private JPanel jpanelrezbutton;
    private JFormattedTextField jtextfield;
    private JButton jbuton0;
    private JButton jbuton1;
    private JButton jbuton2;
    private JButton jbuton3;
    private JButton jbuton4;
    private JButton jbuton5;
    private JButton jbuton6;
    private JButton jbuton7;
    private JButton jbuton8;
    private JButton jbuton9;
    private JButton jbutonAdd;
    private JButton jbutonSub;
    private JButton jbutonMult;
    private JButton jbutonDiv;
    private JButton jbutonErase;
    private JButton jbutonPoint;
    private JButton jbuttonRezult;
    private JLabel jlabelrez;
    
    public Calculator()
    {
        setTitle("Calculator");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setLocationByPlatform(true);
        addWindowStateListener(this::windowStateChanged); //Не позволяем развернуться
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints  gridbagcontaints = new GridBagConstraints(); 
        gridbagcontaints.fill = GridBagConstraints.HORIZONTAL; 
        gridbagcontaints.weightx = 1; 
        gridbagcontaints.weighty = 0.1; 
        //gridbagcontaints.insets =  new Insets(10, 5, 0, 5);
        gridbagcontaints.insets.right = 10;
        gridbagcontaints.insets.left = 5;
        gridbagcontaints.gridx = 0; 
        gridbagcontaints.gridy = 0; 
        //Панель окна ввода текста
        jpaneltext = new JPanel();
        add(jpaneltext,gridbagcontaints);
        
        jlabelrez = new JLabel(" ");
        jlabelrez.setFont(new Font("serif",Font.PLAIN,12));
        GridBagLayout layouttxt = new GridBagLayout();
        jpaneltext.setLayout(layouttxt);
        GridBagConstraints gridbagcontaintsTXT = new GridBagConstraints();
        gridbagcontaintsTXT.anchor = GridBagConstraints.EAST;
        gridbagcontaintsTXT.weightx = 1; 
        gridbagcontaintsTXT.weighty = 0.1; 
        //gridbagcontaintsTXT.weighty = 1;
        gridbagcontaintsTXT.gridx = 0; 
        gridbagcontaintsTXT.gridy = 0; 
        jpaneltext.add(jlabelrez,gridbagcontaintsTXT);
        jtextfield = new JFormattedTextField();
        jtextfield.setText("0");
        jtextfield.setEditable(false);
        jtextfield.setHorizontalAlignment(RIGHT);
        jtextfield.setFont(new Font("serif", Font.BOLD, 24));
        gridbagcontaintsTXT.fill = GridBagConstraints.BOTH; 
        gridbagcontaintsTXT.gridy = 1; 
        jpaneltext.add(jtextfield,gridbagcontaintsTXT);
        
        
        //Панель кнопок
        jpanelbuttons = new JPanel();
        gridbagcontaints.weightx = 1; 
        gridbagcontaints.weighty = 0.1;
        gridbagcontaints.insets.right = 5;
        gridbagcontaints.insets.left = 5;
        gridbagcontaints.gridx = 0; 
        gridbagcontaints.gridy = 1; 
        GridBagLayout layoutbuttonpanel = new GridBagLayout();
        jpanelbuttons.setLayout(layoutbuttonpanel);
        add(jpanelbuttons,gridbagcontaints);
        gridbagcontaints.gridy = 2; 
        jpanelrezbutton  = new JPanel();
        add(jpanelrezbutton,gridbagcontaints);
        GridBagLayout layoutrezultpanel = new GridBagLayout();
        jpanelrezbutton.setLayout(layoutrezultpanel);
        //Создаем кнопки
        InitButtons();
        //Расставим кнопки по местам
        PutBttons();
        
        
        //jbuton0.addActionListener(this.on);
        

    }
    
    
    
    public void windowStateChanged(final WindowEvent e) 
    {
        if (e.getNewState() == MAXIMIZED_BOTH) 
        {
            this.setExtendedState(NORMAL);
        }
    }
    public void InitButtons()
    {
        jbuton0 = new JButton("0");
        jbuton0.addActionListener(onButton0Click);
        jbuton1 = new JButton("1");
        jbuton1.addActionListener(onButton1Click);
        jbuton2 = new JButton("2");
        jbuton2.addActionListener(onButton2Click);
        jbuton3 = new JButton("3");
        jbuton3.addActionListener(onButton3Click);
        jbuton4 = new JButton("4");
        jbuton4.addActionListener(onButton4Click);
        jbuton5 = new JButton("5");
        jbuton5.addActionListener(onButton5Click);
        jbuton6 = new JButton("6");
        jbuton6.addActionListener(onButton6Click);
        jbuton7 = new JButton("7");
        jbuton7.addActionListener(onButton7Click);
        jbuton8 = new JButton("8");
        jbuton8.addActionListener(onButton8Click);
        jbuton9 = new JButton("9");
        jbuton9.addActionListener(onButton9Click);
        jbutonAdd = new JButton("+");
        jbutonAdd.addActionListener(onButtonAddClick);
        jbutonSub = new JButton("-");
        jbutonDiv = new JButton("/");
        jbutonMult = new JButton("*");
        jbutonErase = new JButton("CE");
        jbutonErase.addActionListener(onButtonErase);
        jbutonPoint = new JButton(".");
        jbutonPoint.addActionListener(onButtonPointClick);
        jbuttonRezult = new JButton("=");
        jbuttonRezult.addActionListener(onButtonRezult);
    }
    
    //public  void PutBttons(GridBagConstraints  gridbagcontaintsButton,GridBagConstraints  gridbagcontaintsButtonRez)
    public  void PutBttons()
    {
        GridBagConstraints  gridbagcontaintsButton = new GridBagConstraints();
        gridbagcontaintsButton.fill = GridBagConstraints.HORIZONTAL; 
        gridbagcontaintsButton.anchor = GridBagConstraints.NORTH;
        gridbagcontaintsButton.insets = new Insets(10, 0, 0, 5);
        gridbagcontaintsButton.weightx = 0.25; 
        gridbagcontaintsButton.weighty = 0;
        gridbagcontaintsButton.gridx = 0; 
        gridbagcontaintsButton.gridy = 0; 
        jpanelbuttons.add(jbuton7,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 1;
        jpanelbuttons.add(jbuton8,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 2;
        jpanelbuttons.add(jbuton9,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 3;
        jpanelbuttons.add(jbutonAdd,gridbagcontaintsButton);
        gridbagcontaintsButton.gridy = 1; 
        gridbagcontaintsButton.gridx = 0; 
        jpanelbuttons.add(jbuton4,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 1;
        jpanelbuttons.add(jbuton5,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 2;
        jpanelbuttons.add(jbuton6,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 3;
        jpanelbuttons.add(jbutonSub,gridbagcontaintsButton);
        gridbagcontaintsButton.gridy = 2; 
        gridbagcontaintsButton.gridx = 0; 
        jpanelbuttons.add(jbuton1,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 1;
        jpanelbuttons.add(jbuton2,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 2;
        jpanelbuttons.add(jbuton3,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 3;
        jpanelbuttons.add(jbutonMult,gridbagcontaintsButton);
        gridbagcontaintsButton.gridy = 3; 
        gridbagcontaintsButton.gridx = 0; 
        jpanelbuttons.add(jbutonErase,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 1; 
        jpanelbuttons.add(jbuton0,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 2; 
        jpanelbuttons.add(jbutonPoint,gridbagcontaintsButton);
        gridbagcontaintsButton.gridx = 3; 
        jpanelbuttons.add(jbutonDiv,gridbagcontaintsButton);
        GridBagConstraints gridbagcontaintsButtonRez = new GridBagConstraints();
        gridbagcontaintsButtonRez.fill = GridBagConstraints.BOTH; 
        gridbagcontaintsButtonRez.anchor = GridBagConstraints.NORTH;
        gridbagcontaintsButtonRez.insets = new Insets(0, 0, 0, 5);
        gridbagcontaintsButtonRez.weightx = 1; 
        gridbagcontaintsButtonRez.weighty = 1;
        gridbagcontaintsButtonRez.gridx = 0; 
        gridbagcontaintsButtonRez.gridy = 4; 
        jpanelrezbutton.add(jbuttonRezult,gridbagcontaintsButtonRez); 
    }
    
    private static double GetResult(String ch1,String ch2,String oper)
    {
        double d1 = Double.valueOf(ch1);
        double d2 = Double.valueOf(ch2);
        double dRez = 0;
        switch (oper)
        {
            case "+":
            dRez = d1+d2;
            break;
        }
        
        return dRez;
    }
    
    private ActionListener onButtonRezult = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
                if (!jlabelrez.getText().equals(" "))
                {
                    double drez = GetResult(jlabelrez.getText(), jtextfield.getText(), operation);
                    jlabelrez.setText(" ");
                    if (drez == (long)drez)
                       jtextfield.setText(String.format("%d", (long)drez));
                    else
                       jtextfield.setText(String.format("%s",drez));
                }
        }
    };
    
    private ActionListener onButtonErase = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
                jtextfield.setText("0");
                jlabelrez.setText(" ");
                operation = null;
        }
    };
    
    private ActionListener onButtonAddClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            operation = "+";
            
            jlabelrez.setText(jlabelrez.getText()+jtextfield.getText());
            jtextfield.setText("0");
        }
    };
    
    private ActionListener onButton0Click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (!jtextfield.getText().equals("0"))
                jtextfield.setText(jtextfield.getText()+"0");
        }
    };
    
     private ActionListener onButton1Click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jtextfield.setText(jtextfield.getText().equals("0") ? "1" : jtextfield.getText()+"1");
        }
    };
    
    private ActionListener onButton2Click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jtextfield.setText(jtextfield.getText().equals("0") ? "2" : jtextfield.getText()+"2");
        }
    };
    
     private ActionListener onButton3Click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jtextfield.setText(jtextfield.getText().equals("0") ? "3" : jtextfield.getText()+"3");
        }
    };
    
    private ActionListener onButton4Click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jtextfield.setText(jtextfield.getText().equals("0") ? "4" : jtextfield.getText()+"4");
        }
    };
    
    
     private ActionListener onButton5Click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jtextfield.setText(jtextfield.getText().equals("0") ? "5" : jtextfield.getText()+"5");
        }
    };
    
    private ActionListener onButton6Click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jtextfield.setText(jtextfield.getText().equals("0") ? "6" : jtextfield.getText()+"6");
        }
    }; 
     
    private ActionListener onButton7Click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jtextfield.setText(jtextfield.getText().equals("0") ? "7" : jtextfield.getText()+"7");
        }
    }; 
    
    private ActionListener onButton8Click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jtextfield.setText(jtextfield.getText().equals("0") ? "8" : jtextfield.getText()+"8");
        }
    }; 
    
    private ActionListener onButton9Click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jtextfield.setText(jtextfield.getText().equals("0") ? "9" : jtextfield.getText()+"9");
        }
    };   
    
    private ActionListener onButtonPointClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jtextfield.setText(jtextfield.getText().indexOf(".") == -1 ? jtextfield.getText()+"." : jtextfield.getText());
        }
    }; 
    
}
