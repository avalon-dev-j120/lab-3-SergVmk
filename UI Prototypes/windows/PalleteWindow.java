package windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Dictionary;
import javax.swing.*;
import javax.swing.GroupLayout.Group;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.*;
import sun.swing.MenuItemLayoutHelper;


public class PalleteWindow extends JFrame{
        private static class Constants {
        static final int WIDTH = 600;
        static final int HEIGHT = 300;
    }
        private JPanel jpanelColor;
        private JPanel jpanelslider;
        
        private JSlider sliderR;
        private JSlider sliderG;
        private JSlider sliderB;

    public PalleteWindow()
    {
        setTitle("Color picker");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setLocationByPlatform(true);
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        //Панель цвета
        jpanelColor = new JPanel();
        jpanelColor.setBackground(new Color(125,125,125));   
        GridBagConstraints collColor = new GridBagConstraints(); 
        collColor.fill = GridBagConstraints.BOTH; 
        collColor.weightx = 1; 
        collColor.weighty = 1;
        collColor.insets.bottom = 20;
        collColor.insets.right = 50;
        collColor.insets.left = 20;
        collColor.insets.top = 20;
        collColor.gridx = 0; 
        collColor.gridy = 0; 
        add(jpanelColor,collColor);

        jpanelslider = new JPanel(); 
        GridBagLayout layoutpaneslider =new GridBagLayout(); 
        jpanelslider.setLayout(layoutpaneslider);
        JLabel redlabel = new JLabel("Red:");
        JLabel greenlabel = new JLabel("Green:");
        JLabel bluelabel = new JLabel("Blue:");
        sliderR = new JSlider(0, 255, 125);
        sliderR.setName("Red");
        sliderG = new JSlider(0, 255, 125);
        sliderG.setName("Green");
        sliderB = new JSlider(0, 255, 125);
        sliderB.setName("Blue");
        for (JSlider js : new JSlider[] {sliderR, sliderG, sliderB}) {
          js.setPaintTicks(true);
          js.setMinorTickSpacing(22);
          js.setMajorTickSpacing(255);
          js.setToolTipText(js.getName());
          js.addChangeListener(this::onSliderChanged);
        }    
        GridBagConstraints colpanelSlider = new GridBagConstraints(); 
        colpanelSlider.fill = GridBagConstraints.BOTH; 
        add(jpanelslider,colpanelSlider);
        GridBagConstraints collabel = new GridBagConstraints(); 
        collabel.fill = GridBagConstraints.BOTH; 
        collabel.weightx = 0.15; 
        collabel.weighty = 0.0;
        collabel.insets.bottom = 30;
        collabel.anchor = GridBagConstraints.WEST;
        collabel.gridx = 0; 
        collabel.gridy = 0; 
        jpanelslider.add(redlabel,collabel);
        collabel.gridy = 1;
        jpanelslider.add(greenlabel,collabel);
        collabel.gridy = 2;
        jpanelslider.add(bluelabel,collabel);
        GridBagConstraints colslider = new GridBagConstraints(); 
        colslider.fill = GridBagConstraints.BOTH; 
        colslider.weightx = 0.85; 
        colslider.gridx = 1; 
        colslider.gridy = 0; 
        colslider.weighty = 0.5;
        colslider.insets.right=15;
        jpanelslider.add(sliderR,colslider);
        colslider.gridy = 1;
        jpanelslider.add(sliderG,colslider);
        colslider.gridy = 2;
        jpanelslider.add(sliderB,colslider);
        jpanelColor.setToolTipText("#"+Integer.toString(sliderR.getValue(),16)+Integer.toString(sliderG.getValue(),16)+Integer.toString(sliderB.getValue(),16));
    }
    
    private void onSliderChanged(ChangeEvent evt) 
    {
        jpanelColor.setBackground(new Color(sliderR.getValue(),sliderG.getValue(),sliderB.getValue()));
        jpanelColor.setToolTipText("#"+Integer.toString(sliderR.getValue(),16)+Integer.toString(sliderG.getValue(),16)+Integer.toString(sliderB.getValue(),16));
    }
    
}
