import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import java.awt.Font;

public class Viewer {

    private JTextField textField;
    private JTextField textFieldExspression;	
    private Controller controller;

    private JButton buttonOne;
    private JButton buttonTwo;
    private JButton buttonThree;
    private JButton buttonFour;
    private JButton buttonFive;
    private JButton buttonSix;
    private JButton buttonSeven;
    private JButton buttonEight;
    private JButton buttonNine;
    private JButton buttonZero;

    private boolean checkBlockButtons;

    public Viewer() {

	controller = new Controller(this);	
	
	JPanel panel = getPanel();
	panel.setBounds(0, 0, 390, 550);

	JFrame frame = new JFrame("Calculator Intern Labs 3.0");
	frame.setSize(390, 550);
	frame.setLocation(200, 150);
	frame.setLayout(null);

	frame.add(panel);

	frame.setVisible(true);

	checkBlockButtons = false;

    }
   
    public void updateExspression(String temp) {
    	textFieldExspression.setText(temp); 
    }

    public boolean getcheckBlockButtons() {
    	return checkBlockButtons;
    }

    public void setBlockEnabledButtons() {
    	buttonOne.setEnabled(false);
    	buttonTwo.setEnabled(false);
    	buttonThree.setEnabled(false);
    	buttonFour.setEnabled(false);
    	buttonFive.setEnabled(false);
    	buttonSix.setEnabled(false);
    	buttonSeven.setEnabled(false);
    	buttonEight.setEnabled(false);
    	buttonNine.setEnabled(false);
    	buttonZero.setEnabled(false);

	checkBlockButtons = true;
    }

    public void setOpenEnabledButtons() {
        buttonOne.setEnabled(true);
    	buttonTwo.setEnabled(true);
    	buttonThree.setEnabled(true);
    	buttonFour.setEnabled(true);
    	buttonFive.setEnabled(true);
    	buttonSix.setEnabled(true);
    	buttonSeven.setEnabled(true);
    	buttonEight.setEnabled(true);
    	buttonNine.setEnabled(true);
    	buttonZero.setEnabled(true);

	checkBlockButtons = false;

    }


    public void update(String temp) {
    	textField.setText(temp); 
    }


    private JPanel getPanel() {
	//TextField initialization
	Font fontTexfField = new Font("TimesRoman", Font.BOLD, 22);
	Font fontTexfFieldExpression = new Font("TimesRoman", Font.BOLD, 15);
	Font fontButton = new Font("TimesRoman", Font.BOLD, 20);

    	textFieldExspression = new JTextField();
	textFieldExspression.setBounds(12, 10, 355, 40);
	textFieldExspression.setEditable(false);
	textFieldExspression.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	//textFieldExspression.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	textFieldExspression.setFont(fontTexfFieldExpression);

	textField = new JTextField();
	textField.setBounds(12, 60, 355, 50);
	textField.setEditable(false);
	textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	textField.setFont(fontTexfField);
	update("0");
	//textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

	//Button initialization
	JButton buttonPercent = new JButton("%");
	buttonPercent.setBounds(10, 115, 85, 60);	
	buttonPercent.setActionCommand("Percent");
	buttonPercent.addActionListener(controller);	
	buttonPercent.setFont(fontButton);	        

	JButton buttonCE = new JButton("CE");
	buttonCE.setBounds(10, 180, 85, 60);	
	buttonCE.setActionCommand("Clear");
	buttonCE.addActionListener(controller);	
	buttonCE.setFont(fontButton);	        

	buttonSeven = new JButton("7");
	buttonSeven.setBounds(10, 245, 85, 60);	
	buttonSeven.setActionCommand("Seven");
	buttonSeven.addActionListener(controller);	
	buttonSeven.setFont(fontButton);	        

	buttonFour = new JButton("4");
	buttonFour.setBounds(10, 310, 85, 60);	
	buttonFour.setActionCommand("Four");
	buttonFour.addActionListener(controller);	
	buttonFour.setFont(fontButton);	        

	buttonOne = new JButton("1");
	buttonOne.setBounds(10, 375, 85, 60);
	buttonOne.setActionCommand("One");
	buttonOne.addActionListener(controller);	
	buttonOne.setFont(fontButton);	        

	JButton buttonPlusOrMinus = new JButton("+-");
	buttonPlusOrMinus.setBounds(10, 440, 85, 60);	
	buttonPlusOrMinus.setActionCommand("Plus or minus");
	buttonPlusOrMinus.addActionListener(controller);
	buttonPlusOrMinus.setFont(fontButton);	        

//	

	JButton buttonSqrt = new JButton("\u221A");
	buttonSqrt.setBounds(100, 115, 85, 60);	
	buttonSqrt.setActionCommand("Sqrt");
	buttonSqrt.addActionListener(controller);	
	buttonSqrt.setFont(fontButton);	        

	JButton buttonC = new JButton("C");
	buttonC.setBounds(100, 180, 85, 60);	
	buttonC.setActionCommand("Clear All");
	buttonC.addActionListener(controller);	
	buttonC.setFont(fontButton);	        


	buttonEight = new JButton("8");
	buttonEight.setBounds(100, 245, 85, 60);	
	buttonEight.setActionCommand("Eight");
	buttonEight.addActionListener(controller);	
	buttonEight.setFont(fontButton);	        

	buttonFive = new JButton("5");
	buttonFive.setBounds(100, 310, 85, 60);	
	buttonFive.setActionCommand("Five");
	buttonFive.addActionListener(controller);	
	buttonFive.setFont(fontButton);	        

	buttonTwo = new JButton("2");
	buttonTwo.setBounds(100, 375, 85, 60);
	buttonTwo.setActionCommand("Two");
	buttonTwo.addActionListener(controller);	
	buttonTwo.setFont(fontButton);	        

	buttonZero = new JButton("0");
	buttonZero.setBounds(100, 440, 85, 60);	
	buttonZero.setActionCommand("Zero");
	buttonZero.addActionListener(controller);
	buttonZero.setFont(fontButton);	        

//	


	JButton buttonSquare = new JButton("X\u00B2");
	buttonSquare.setBounds(190, 115, 85, 60);
	buttonSquare.setActionCommand("Square");
	buttonSquare.addActionListener(controller);	
	buttonSquare.setFont(fontButton);	        

	JButton buttonDelete = new JButton("\u2326");
	buttonDelete.setBounds(190, 180, 85, 60);	
	buttonDelete.setActionCommand("Delete");
	buttonDelete.addActionListener(controller);	
	buttonDelete.setFont(fontButton);	        


	buttonNine = new JButton("9");
	buttonNine.setBounds(190, 245, 85, 60);	
	buttonNine.setActionCommand("Nine");
	buttonNine.addActionListener(controller);	
	buttonNine.setFont(fontButton);	        


	buttonSix = new JButton("6");
	buttonSix.setBounds(190, 310, 85, 60);	
        buttonSix.setActionCommand("Six");
	buttonSix.addActionListener(controller);	
	buttonSix.setFont(fontButton);	        

	buttonThree = new JButton("3");
	buttonThree.setBounds(190, 375, 85, 60);
        buttonThree.setActionCommand("Three");
	buttonThree.addActionListener(controller);	
	buttonThree.setFont(fontButton);	        

	JButton buttonComma = new JButton(".");
	buttonComma.setBounds(190, 440, 85, 60);		
        buttonComma.setActionCommand("Comma");
	buttonComma.addActionListener(controller);	
	buttonComma.setFont(fontButton);	        

//

	JButton buttonXDivOne = new JButton("1/x");
	buttonXDivOne.setBounds(280, 115, 85, 60);	
        buttonXDivOne.setActionCommand("X div one");
	buttonXDivOne.addActionListener(controller);	
	buttonXDivOne.setFont(fontButton);	        

	JButton buttonDiv = new JButton("/");
	buttonDiv.setBounds(280, 180, 85, 60);	
        buttonDiv.setActionCommand("Div");
	buttonDiv.addActionListener(controller);	
	buttonDiv.setFont(fontButton);	        

	JButton buttonMultiple = new JButton("*");
	buttonMultiple.setBounds(280, 245, 85, 60);	
        buttonMultiple.setActionCommand("Multiple");
	buttonMultiple.addActionListener(controller);	
	buttonMultiple.setFont(fontButton);	        

	JButton buttonMinus = new JButton("-");
	buttonMinus.setBounds(280, 310, 85, 60);	
        buttonMinus.setActionCommand("Minus");
	buttonMinus.addActionListener(controller);	
	buttonMinus.setFont(fontButton);	        

	JButton buttonPlus = new JButton("+");
	buttonPlus.setBounds(280, 375, 85, 60);
        buttonPlus.setActionCommand("Plus");
	buttonPlus.addActionListener(controller);	
	buttonPlus.setFont(fontButton);	        

	JButton buttonEqual = new JButton("=");
	buttonEqual.setBounds(280, 440, 85, 60);	
        buttonEqual.setActionCommand("Equal");
	buttonEqual.addActionListener(controller);
	buttonEqual.setFont(fontButton);	        
	//End button initialization	

	
	JPanel panel = new JPanel();
	panel.setLayout(null);

	panel.add(textField);
	panel.add(textFieldExspression);	

	panel.add(buttonPercent);
	panel.add(buttonCE);
	panel.add(buttonSeven);
	panel.add(buttonFour);
	panel.add(buttonOne);
	panel.add(buttonPlusOrMinus);
	
	panel.add(buttonSqrt);
	panel.add(buttonC);
        panel.add(buttonEight);
        panel.add(buttonFive);
        panel.add(buttonTwo);
        panel.add(buttonZero);


        panel.add(buttonSquare);
	panel.add(buttonDelete);
	panel.add(buttonNine);
	panel.add(buttonSix);
	panel.add(buttonThree);
	panel.add(buttonComma);


	panel.add(buttonXDivOne);
	panel.add(buttonDiv);
	panel.add(buttonMultiple);
	panel.add(buttonMinus);
	panel.add(buttonPlus);
	panel.add(buttonEqual);

	return panel;
	
    }

}