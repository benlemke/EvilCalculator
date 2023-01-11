import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.*;
import java.lang.Math;
import javax.swing.*;
public class gui {
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 600;
	private static final int BUTTON_WIDTH = 80;
	private static final int BUTTON_HEIGHT = 70;
	private static final int MARGIN_X = 210;
	private static final int MARGIN_Y = 60;
	
	private JFrame window; // Main window
	private JComboBox<String> level;
	private JTextField inText; // Input
	private JTextArea history;
	private JButton btnClear, btnEquals, btnPlusMin, btnOmega, btnTheta, 
	     	btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot;
	private JButton[] buttons = new JButton[13];
	
	
	private char opt = ' '; // Save the operator
	private boolean go = true; // For calculate with Opt != (=)
	//private boolean addWrite = true; // Connect numbers in display
	private double val = 0; // Save the value typed for calculation
	public gui() {
		window = new JFrame("EvilCalculator");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocationRelativeTo(null); // Move window to center

        
        int[] x = {MARGIN_X, MARGIN_X + 90, 390, 480, 570};
        int[] y = {MARGIN_Y, MARGIN_Y + 100, MARGIN_Y + 180, MARGIN_Y + 260, MARGIN_Y + 340, MARGIN_Y + 420};

        inText = new JTextField("0");
        inText.setBounds(x[0], y[0], 350, 70);
        inText.setHorizontalAlignment(SwingConstants.RIGHT);
        inText.setEditable(false);
        inText.setBackground(Color.WHITE);
        inText.setFont(new Font("Tahoma", Font.PLAIN, 33));
        window.add(inText);
        
        history = new JTextArea("Ω3");
        history.setBounds(20, y[0], MARGIN_X-40, WINDOW_HEIGHT-2*MARGIN_Y);
        history.setEditable(false);
        history.setBackground(Color.WHITE);
        history.setFont(new Font("Tahoma", Font.PLAIN, 15));
        window.add(history);
        
        btn7 = initBtn("7",x[0],y[1], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("7");
        	} else {
        		inText.setText(inText.getText() + "7");
        	}
        	go = true;
        });
        
        btn8 = initBtn("8",x[1],y[1], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("8");
        	} else {
        		inText.setText(inText.getText() + "8");
        	}
        	go = true;
        });
        
        btn9 = initBtn("9",x[2],y[1], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("9");
        	} else {
        		inText.setText(inText.getText() + "9");
        	}
        	go = true;
        });
        
        btnOmega = initBtn("Ω",x[3],y[1], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("Ω");
        	} else {
        		inText.setText("Ω" + inText.getText() );
        	}
        	go = true;
        });
        
        btn4 = initBtn("4",x[0],y[2], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("4");
        	} else {
        		inText.setText(inText.getText() + "4");
        	}
        	go = true;
        });
        
        btn5 = initBtn("5",x[1],y[2], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("5");
        	} else {
        		inText.setText(inText.getText() + "5");
        	}
        	go = true;
        });
        
        btn6 = initBtn("6",x[2],y[2], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("6");
        	} else {
        		inText.setText(inText.getText() + "6");
        	}
        	go = true;
        });
        
        
        btnTheta = initBtn("Θ",x[3],y[2], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("Θ");
        	} else {
        		inText.setText(inText.getText() + "Θ");
        	}
        	go = true;
        });
        
        btn1 = initBtn("1",x[0],y[3], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("1");
        	} else {
        		inText.setText(inText.getText() + "1");
        	}
        	go = true;
        });
        
        btn2 = initBtn("2",x[1],y[3], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("2");
        	} else {
        		inText.setText(inText.getText() + "2");
        	}
        	go = true;
        });
        
        btn3 = initBtn("3",x[2],y[3], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("3");
        	} else {
        		inText.setText(inText.getText() + "3");
        	}
        	go = true;
        });
        
        btnPlusMin = initBtn("±",x[3],y[3], event -> {
        	
        	if(Pattern.matches("^Ω.*",inText.getText())) {
        		inText.setText("-" +inText.getText());
        		//inText.setText(inText.getText().substring(1));
        	} else if(Pattern.matches("^-Ω[^-].*",inText.getText())) {
        		inText.setText("Ω-" +inText.getText().substring(2));
        	} else if(Pattern.matches("^Ω-.*",inText.getText())) {
        		inText.setText("-Ω-" +inText.getText().substring(2));
        	} else if(Pattern.matches("^-Ω-.*",inText.getText())) {
        		inText.setText("Ω" +inText.getText().substring(3));
        	} else if(Pattern.matches("^-.*",inText.getText())){
        		inText.setText(inText.getText().substring(1));
        	} else{
        		inText.setText("-" + inText.getText());
        	}
        	go = true;
        });
        
        btnDot = initBtn(".",x[0],y[4], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText(".");
        	} else if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText(inText.getText() + "0.");
        	}
        	go = true;
        });
        
        btn0 = initBtn("0",x[1],y[4], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("0");
        	} else {
        		inText.setText(inText.getText() + "0");
        	}
        	go = true;
        });
        
        btnEquals = initBtn("=",x[2],y[4], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("7");
        	} else {
        		inText.setText("7");
        	}
        	go = true;
        });
        
        btnClear = initBtn("C",x[3],y[4], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("0");
        	} else {
        		inText.setText("0");
        	}
        	go = true;
        });
        
        buttons[0] = btn0;
        buttons[1] = btn1;
        buttons[2] = btn2;
        buttons[3] = btn3;
        buttons[4] = btn4;
        buttons[5] = btn5;
        buttons[6] = btn6;
        buttons[7] = btn7;
        buttons[8] = btn8;
        buttons[9] = btn9;
        buttons[10] = btnOmega;
        buttons[11] = btnTheta;
        buttons[12] = btnPlusMin;

        window.setLayout(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button clicked? = End The process
        window.setVisible(true);
	}
	//private final JButton buttons[] = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnTheta, btnOmega};
	//btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnTheta, btnOmega
	public void disable(int[] keys) {
		for(int i = 0; i < keys.length; i++) {
			buttons[keys[i]].setEnabled(false);
			/*
			switch(keys[i]) {
				case 1:
					btn0.setEnabled(false);
					break;
			}
			*/
		}
	}
	private JButton initBtn(String label, int x, int y, ActionListener event) {
        JButton btn = new JButton(label);
        btn.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        btn.setFont(new Font("Tahoma", Font.PLAIN, 28));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(event);
        btn.setFocusable(false);
        window.add(btn);
        
        return btn;
    }
	
	
}




































