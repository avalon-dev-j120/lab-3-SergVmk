package windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import javax.swing.*;
import javax.swing.GroupLayout.Group;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.*;

public class PalleteWindow extends JFrame{
        private static class Constants {
        static final int WIDTH = 600;
        static final int HEIGHT = 300;
    }
        private JPanel jpanelColor;
        private JPanel jpanel;
        private JSlider sliderR;
        private JSlider sliderG;
        private JSlider sliderB;
        
    public PalleteWindow()
    {
        setTitle("Color picker");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setLocationByPlatform(true);
        GridLayout layout = new GridLayout(0,2);
        setLayout(layout);
        jpanel = new JPanel(); 
        jpanel.setSize(new Dimension(150,300));
        jpanelColor = new JPanel();
        Dimension dm = new Dimension(200  , 200);
        jpanelColor.setBackground(new Color(125,125,125));
        sliderR = new JSlider(0, 255, 125);
        sliderG = new JSlider(0, 255, 125);
        sliderB = new JSlider(0, 255, 125);
        for (JSlider js : new JSlider[] {sliderR, sliderG, sliderB}) {
          js.setPaintTicks(true);
          js.setPaintLabels(true);
          js.addChangeListener(this::onSliderChanged);
        }    
        Map<Integer,JLabel> map = new HashMap<Integer,JLabel>();
        map.put(0, new JLabel("Red"));
        sliderR.setLabelTable(map);
         
        
        jpanelColor.setSize(dm);
        add(jpanelColor);
        add(jpanel);
        jpanel.add(sliderR);
        jpanel.add(sliderG);
        jpanel.add(sliderB);
        
        //layout.setVerticalGroup(layout.createSequentialGroup().addComponent(sliderR).addComponent(sliderG).addComponent(sliderB));
      
        
        //jpanel.add(jpanelColor);

       // jpanel.add(sliderR);
       // jpanel.add(sliderG);
       // jpanel.add(sliderB);

    }
    
        private void onSliderChanged(ChangeEvent evt) {
        jpanelColor.setBackground(new Color(sliderR.getValue(),sliderG.getValue(),sliderB.getValue()));
    }
    
    private static String GetTooltipText(int r, int g, int b)
    {
        return("#"+Integer.toString(r,16)+Integer.toString(g,16)+Integer.toString(b,16));
    }
    
    
}
