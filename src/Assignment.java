
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Assignment extends JFrame
{
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGTH = 700;
	
	 //create the main panel for buttons
	private JPanel mainPanel;
	//create the bottom panel for color info
	private JPanel southPanel;
	
	//create the 5 panels to populate the mainPanel and southPanel
	private JPanel westPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel infoPanel = new JPanel();
	private JPanel colorShowPanel = new JPanel();
	
	//create 3 button arrays for the 3 colors
	private JButton [] redButtonArray;
	private JButton [] greenButtonArray;
	private JButton [] blueButtonArray;
	
	//create integers for 3 color values initialized to 0
	private int redVal;
	private int greenVal;
	private int blueVal;
	
	//create the label for the color info panel
	public JLabel label = new JLabel();
	
	
    public Assignment(String aStr)
    {
    	//declare the button array length
    	redButtonArray = new JButton[256];
    	greenButtonArray = new JButton[256];
    	blueButtonArray = new JButton[256];
    	
    	//set 2 main panels in grid layout and assign rows and columns
    	mainPanel = new JPanel(new GridLayout(1, 3));
    	southPanel = new JPanel(new GridLayout(1, 2));
    	
    	//set grid layout on westPanel (red buttons), assign grid values and border settings
    	westPanel = new JPanel(new GridLayout(13, 20));
    	westPanel.setBorder(new EmptyBorder(10, 10, 10, 10) );
    	
    	//set grid layout on centerPanel (green buttons), assign grid values and border settings
    	centerPanel = new JPanel(new GridLayout(13, 20));
    	centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10) );
    	
    	//set grid layout on eastPanel (blue buttons), assign grid values and border settings
    	eastPanel = new JPanel(new GridLayout(13, 20));
    	eastPanel.setBorder(new EmptyBorder(10, 10, 10, 10) );
    	
    	//set dimensions of the southPanel (color information)
    	southPanel.setPreferredSize(new Dimension(20, 30));
    
    	//add the main panel and south panels to the content pane and position them
    	getContentPane().add(mainPanel, BorderLayout.CENTER);
    	getContentPane().add(southPanel, BorderLayout.SOUTH);
    	
    	
    	//////////////////////////////////
    	//loop to create the red buttons//
    	//////////////////////////////////
    	for(int i = 0; i < redButtonArray.length; i++)
    	{
    		redButtonArray[i] = new JButton();
    		redButtonArray[i].setOpaque(true);
    		redButtonArray[i].setBorder(new EtchedBorder());
    		redButtonArray[i].setBackground(new Color( i, 0, 0));
    		westPanel.add(redButtonArray[i]);
    		
    		//add action listener for on click
    		redButtonArray[i].addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent e)
    			{
    				for(int i = 0; i < redButtonArray.length; i++)
    				{
    					if (e.getSource().equals(redButtonArray[i])) 
    					{
    						//change the color on the colorShowPanel
    						colorShowPanel.setBackground(new Color(i, greenVal, blueVal));
    						
    						//set a value for red for other button click to access
    						redVal = i;
    						
    						//set the RGB label
    						label.setText("Selected colour was R:" + redVal + " G:" + greenVal + " B:" + blueVal);
    					}
    				}
    			}
    		});
    	}  
    	
    	
    	////////////////////////////////////
    	//loop to create the green buttons//
    	////////////////////////////////////
    	for(int i = 0; i < greenButtonArray.length; i++)
    	{
    		greenButtonArray[i] = new JButton();
    		greenButtonArray[i].setOpaque(true);
    		greenButtonArray[i].setBorder(new EtchedBorder());
    		greenButtonArray[i].setBackground(new Color( 0, i, 0));
    		centerPanel.add(greenButtonArray[i]);
    		
    		//add action listener for on click
    		greenButtonArray[i].addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent e)
    			{
    				for(int i = 0; i < greenButtonArray.length; i++)
    		    	{
		    		    if (e.getSource().equals(greenButtonArray[i])) 
		    		    {
		    		    	//change the color on the colorShowPanel
		    		    	colorShowPanel.setBackground(new Color(redVal, i, blueVal));
		    		    	
		    		    	//set a value for green for other button click to access
		    		    	greenVal = i;
		    		    	
		    		    	//set the RGB label
		    		    	label.setText("Selected colour was R:" + redVal + " G:" + greenVal + " B:" + blueVal);
		    		    }
    		    	}
    			}
    		});	
    	} 
    	
    	
    	///////////////////////////////////
    	//loop to create the blue buttons//
    	///////////////////////////////////
    	for(int i = 0; i < blueButtonArray.length; i++)
    	{
    		blueButtonArray[i] = new JButton();
    		blueButtonArray[i].setOpaque(true);
    		blueButtonArray[i].setBorder(new EtchedBorder());
    		blueButtonArray[i].setBackground(new Color( 0, 0, i));
    		eastPanel.add(blueButtonArray[i]);
    		
    		//add action listener for on click
    		blueButtonArray[i].addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent e)
    			{
    				for(int i = 0; i < blueButtonArray.length; i++)
    				{
    					if (e.getSource().equals(blueButtonArray[i])) 
    					{
    						//change the color on the colorShowPanel
    						colorShowPanel.setBackground(new Color(redVal, greenVal, i));
    						
    						//set a value for blue for other button click to access
    						blueVal = i;
    						
    						//set the RGB label
    						label.setText("Selected colour was R:" + redVal + " G:" + greenVal + " B:" + blueVal);
    					}
    				}
    			}
    		});
    	}
    	
    	
    	
    	//set initial label with RGB values at 0
    	label.setText("Selected colour was R:" + redVal + " G:" + greenVal + " B:" + blueVal);
    	infoPanel.add(label);
    	
    	//set initial colorPanel with RGB values at 0
    	colorShowPanel.setBackground(new Color(redVal, greenVal, blueVal));

    	//add etched border to the 3 color panels
    	westPanel.setBorder(new EtchedBorder());
    	centerPanel.setBorder(new EtchedBorder());
    	eastPanel.setBorder(new EtchedBorder());
    	
    	//add the 3 color panels to the main panel
    	mainPanel.add(westPanel);
    	mainPanel.add(centerPanel);
    	mainPanel.add(eastPanel);
    	
    	//add the color identifier panels to the south panel
    	southPanel.add(infoPanel, BorderLayout.WEST);
    	southPanel.add(colorShowPanel, BorderLayout.EAST);
    	
    	//set size and visibility
    	setSize(FRAME_WIDTH, FRAME_HEIGTH);
    	setVisible(true);
	}
	
    
    
    public static void main(String args[]) 
    {
    	//call the main class
    	new Assignment("Colour Creator");
    }
}
