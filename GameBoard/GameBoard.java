import javax.lang.model.util.AbstractAnnotationValueVisitor6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.io.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.GenericArrayType;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.border.Border;






public class GameBoard implements ActionListener
{
    
    // Add in variable declarations

        //Instantiate the panels and the main mframe     
        JFrame mframe = new JFrame("CodeBreaker!");
        JPanel mpanel = new JPanel();
        JPanel panel01 = new JPanel();
        JPanel panel02 = new JPanel();
        JPanel panel03 = new JPanel();
        JPanel scorePanel = new JPanel();

        //Create the arrays for the score and empty buttons
        JButton[] emptyButtons = new JButton[28];
        JButton[] colorButtons = new JButton[8];
        JButton[] scoreButtons = new JButton[55];
        JButton[] scorebuttons1 = new JButton[55];

        //Instantiate each colour button 
        JButton redButton = new JButton();
        JButton blueButton = new JButton();
        JButton greenButton = new JButton();
        JButton yellowButton = new JButton();
        JButton orangeButton = new JButton();
        JButton violetButton = new JButton();
        JButton emptyButton = new JButton();


        //Instantiate a variable with the right icon 
        Picture red = new Picture("icons/Colour_0.png");
        Picture orange = new Picture("icons/Colour_1.png");
        Picture violet = new Picture("icons/Colour_6.png");
        Picture purple = new Picture("icons/Colour_5.png");
        Picture yellow = new Picture("icons/Colour_2.png");
        Picture green = new Picture("icons/Colour_3.png");
        Picture emp = new Picture("icons/Empty.png");
        Picture score = new Picture("icons/Empty.png");

        


    // Create class Constructor and

    public GameBoard() 
    {


        //Add the icons to each Colour Button 
        blueButton.setIcon(purple);
        redButton.setIcon(red);
        greenButton.setIcon(green);
        yellowButton.setIcon(yellow);
        orangeButton.setIcon(orange);
        violetButton.setIcon(violet);
        emptyButton.setIcon(emp);

        //Add an action Listener to each Button 
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        violetButton.addActionListener(this);
        greenButton.addActionListener(this);
        orangeButton.addActionListener(this);

        //Create a border for each Color Button
        redButton.setBorder(BorderFactory.createEmptyBorder());
        yellowButton.setBorder(BorderFactory.createEmptyBorder());
        blueButton.setBorder(BorderFactory.createEmptyBorder());
        greenButton.setBorder(BorderFactory.createEmptyBorder());
        orangeButton.setBorder(BorderFactory.createEmptyBorder());
        violetButton.setBorder(BorderFactory.createEmptyBorder());

        //Set the right dimensions for each button 
        redButton.setPreferredSize( new Dimension (80, 80));
        blueButton.setPreferredSize( new Dimension (80, 80));
        orangeButton.setPreferredSize( new Dimension (80, 80));
        greenButton.setPreferredSize( new Dimension (80, 80));
        yellowButton.setPreferredSize( new Dimension (80, 80));
        violetButton.setPreferredSize( new Dimension (80, 80));
        
        
        //Just messing about really 
        redButton.setEnabled(true);
        blueButton.setEnabled(true);
        //Set the background of each Button to be a custom Brown
        redButton.setBackground(new Color(148, 92, 40));
        greenButton.setBackground(new Color(148, 92, 40));
        orangeButton.setBackground(new Color(148, 92, 40));
        yellowButton.setBackground(new Color(148, 92, 40));
        violetButton.setBackground(new Color(148, 92, 40));

            //Instantiating layouts for the panels
            GridLayout lay = new GridLayout(15,4);
            GridLayout la = new GridLayout(9, 2);
            //Setting the layout for the panel
            panel03.setLayout(la);


        //Add the colour Buttons onto the mpanel
        panel02.add(redButton);
        panel02.add(blueButton);
        panel02.add(greenButton);
        panel02.add(yellowButton);
        panel02.add(orangeButton);
        panel02.add(violetButton);

        
        for(int i = 0; i < 4; i++)
        {   emptyButtons[i] = new JButton(String.valueOf(i));
            //Set the emptyButtons Icon
            emptyButtons[i].setIcon(emp);
            //Set the size of the Buttons
            emptyButtons[i].setPreferredSize( new Dimension (71, 71));
            emptyButtons[i].setFocusable(false);
            //Add the Buttons onto the main panel
            mpanel.add(emptyButtons[i]);


        }
        //Iterate through the empty button array
        for(int i = 0; i < 35; i++)
        {
            scoreButtons[i] = new JButton(String.valueOf(i));
            scoreButtons[i].setFocusable(false);
            //Set the Icon of each of the Buttons
            scoreButtons[i].setIcon(emp);
            //Set the size of each Button
            scoreButtons[i].setPreferredSize(new Dimension (70, 70));
            //Add the buttons onto the panel
            panel01.add(scoreButtons[i]);

        }
        //Iterate through the score buttons array and add them to the mpanel
        for(int i = 0; i < 18; i++)
        {
            scoreButtons[i] = new JButton(String.valueOf(i));
            scoreButtons[i].setFocusable(false);
            //Set the Icon of the buttons 
            scoreButtons[i].setIcon(emp);
            //Set the size of the buttons
            scoreButtons[i].setPreferredSize( new Dimension (71, 71));
            //Add the Buttons onto the panel
            panel03.add(scoreButtons[i]);

        }
        

        //Set the mframe'slayout and size 
        mframe.setLayout(new BorderLayout());
        //Set the Default Close Operation
        mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the size of the frame
        mframe.setSize(50, 50);

        //Set the layout of the panel
        panel02.setLayout(new FlowLayout());
        //Set the border and color of the panel border 
        mpanel.setBorder(BorderFactory.createLineBorder(new Color(148, 92, 40)));
        //Set the size of the panel
        mpanel.setSize(100, 100);
        panel01.setBorder(BorderFactory.createLineBorder(new Color(148, 92, 40)));
        panel02.setBorder(BorderFactory.createLineBorder(new Color(148, 92, 40)));
        panel03.setBorder(BorderFactory.createLineBorder(new Color(148, 92, 40)));

        //Make the panels Visible
        mpanel.setVisible(true);
        panel01.setVisible(true);
        panel02.setVisible(true);
        panel03.setVisible(true);

        //Set the Background Color of the panels 
        mpanel.setBackground(new Color(148, 92, 40));
        //Slightly different shade of Custom Brown for effect!
        panel01.setBackground(new Color(148, 96, 40));
        panel02.setBackground(new Color(148, 96, 40));
        panel03.setBackground(new Color(148, 96, 40));

        //Make the Panel Visible 
        panel02.setVisible(true);
        panel03.setVisible(true);
       //BorderLayout layout = new BorderLayout();

        //Setting the region for each panel on the frame 
        mframe.add(panel02, BorderLayout.SOUTH);
        mframe.add(panel01, BorderLayout.CENTER);
        mframe.add(panel03, BorderLayout.EAST);
        //Packing everything onto the frame
        mframe.pack();
        //Make the frame Visible
        mframe.setVisible(true);
    }
   
    // Create Main method
    public static void main(String[] args) {
        //Call the GameBoard Class
        new GameBoard();
        


    }
    //Method for Action Listener 
    @Override
    public void actionPerformed(ActionEvent e)
    {    //What to print to the console if a button is pressed
        if(e.getSource() == redButton)

        {   //Prints the String out the the console upon the condition being met
            System.out.println("redbutton");

        }

        if(e.getSource() == blueButton)
        {   //Prints the String out the the console upon the condition being met
            System.out.println("bluebutton");



        }

        if(e.getSource() == yellowButton)
        {   //Prints the String out the the console upon the condition being met
            System.out.println("Will this work??");
            emptyButtons[0].setIcon(yellow);

        }
        if(e.getSource() == violetButton)
        {   //Prints the String out the the console upon the condition being met
            System.out.println("VioletButton");

        }

        if(e.getSource() == greenButton)

        {   //Prints the String out the the console upon the condition being met
            System.out.println("Green Button");


        }
    


    }
}
    

    
    