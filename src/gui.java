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
public class gui extends EvilCalculator{
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 600;
	private static final int BUTTON_WIDTH = 80;
	private static final int BUTTON_HEIGHT = 70;
	private static final int MARGIN_X = 210;
	private static final int MARGIN_Y = 60;
	
	private JFrame window; 
	private JComboBox levelCombo;
	private JTextField inText; 
	private JTextArea history;
	private JLabel tLabel;
	private JButton btnClear, btnEquals, btnPlusMin, btnOmega, btnTheta, 
	     	btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, 
	     	btnDot, nextLvlBtn;
	private JButton[] buttons = new JButton[14];
	public gui() {
		window = new JFrame("EvilCalculator");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocationRelativeTo(null); 

        int[] x = {MARGIN_X, MARGIN_X + 90, 390, 480, 570};
        int[] y = {MARGIN_Y, MARGIN_Y + 100, MARGIN_Y + 180, MARGIN_Y + 260, MARGIN_Y + 340, MARGIN_Y + 420};
        
        nextLvlBtn = new JButton("Next Level->");
        nextLvlBtn.setBounds(MARGIN_X, y[5], 350, BUTTON_HEIGHT);
        nextLvlBtn.setFont(new Font("Tahoma", Font.PLAIN, 28));
        nextLvlBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        inText = new JTextField("");
        inText.setBounds(x[0], y[0], 350, 70);
        inText.setHorizontalAlignment(SwingConstants.RIGHT);
        inText.setEditable(false);
        inText.setBackground(Color.WHITE);
        inText.setFont(new Font("Tahoma", Font.PLAIN, 33));
        window.add(inText);
        
        tLabel = new JLabel();
        tLabel.setBounds(WINDOW_WIDTH/2+20, 10, 1000, 70);
        tLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        window.add(tLabel);
        
        levelCombo = new JComboBox();
        levelCombo.setBounds(20, 30, 60, 25);
        levelCombo.setToolTipText("Level");
        levelCombo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        levelCombo.addActionListener(levelSwitch);
        window.add(levelCombo);
        
        history = new JTextArea();
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
        });
        
        btn8 = initBtn("8",x[1],y[1], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("8");
        	} else {
        		inText.setText(inText.getText() + "8");
        	}
        });
        
        btn9 = initBtn("9",x[2],y[1], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("9");
        	} else {
        		inText.setText(inText.getText() + "9");
        	}
        });
        
        btnOmega = initBtn("Ω",x[3],y[1], event -> {
        	
        		inText.setText("Ω" + inText.getText() );
        	
        });
        
        btn4 = initBtn("4",x[0],y[2], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("4");
        	} else {
        		inText.setText(inText.getText() + "4");
        	}
        });
        
        btn5 = initBtn("5",x[1],y[2], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("5");
        	} else {
        		inText.setText(inText.getText() + "5");
        	}
        });
        
        btn6 = initBtn("6",x[2],y[2], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("6");
        	} else {
        		inText.setText(inText.getText() + "6");
        	}
        });
        
        btnTheta = initBtn("Θ",x[3],y[2], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("Θ");
        	} else {
        		inText.setText(inText.getText() + "Θ");
        	}
        });
        
        btn1 = initBtn("1",x[0],y[3], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("1");
        	} else {
        		inText.setText(inText.getText() + "1");
        	}
        });
        
        btn2 = initBtn("2",x[1],y[3], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("2");
        	} else {
        		inText.setText(inText.getText() + "2");
        	}
        });
        
        btn3 = initBtn("3",x[2],y[3], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("3");
        	} else {
        		inText.setText(inText.getText() + "3");
        	}
        });
        
        btnPlusMin = initBtn("±",x[3],y[3], event -> {
        	if(Pattern.matches("^Ω[0-9]+",inText.getText())) {
        		inText.setText("Ω-" +inText.getText().substring(1));
        		//inText.setText(inText.getText().substring(1));
        	} else if(Pattern.matches("^Ω-[0-9]+",inText.getText())) {
        		inText.setText("-Ω" +inText.getText().substring(2));
        	} else if(Pattern.matches("^-Ω[0-9]+",inText.getText())) {
        		inText.setText("-Ω-" +inText.getText().substring(2));
        	} else if(Pattern.matches("^-Ω-[0-9]+",inText.getText())) {
        		inText.setText("Ω" +inText.getText().substring(3));
        	} else if(Pattern.matches("^-.*",inText.getText())){
        		inText.setText(inText.getText().substring(1));
        	} else{
        		inText.setText("-" + inText.getText());
        	}
        });
        
        btnDot = initBtn(".",x[0],y[4], event -> {
        	if(Pattern.matches("[^.]*",inText.getText())) {
        		inText.setText(inText.getText()+".");
        	} else if (Pattern.matches("",inText.getText())) {
        		inText.setText(inText.getText()+".");
        	}
        });
        
        btn0 = initBtn("0",x[1],y[4], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("0");
        	} else {
        		inText.setText(inText.getText() + "0");
        	}
        });
        
        ActionListener nextLvl = event -> {
        	setLevel(nextLvl());
        	inText.setText("");
        	history.setText("");
        	levelCombo.setSelectedIndex(currentLevel-1);
        };
        
        nextLvlBtn.addActionListener(nextLvl);
        nextLvlBtn.setFocusable(false);
        window.add(nextLvlBtn);
        
        btnEquals = initBtn("=",x[2],y[4], event -> {
        	//if(Pattern.matches("\\-*(Ω)+\\.*\\-*\\d+",inText.getText())) {
        	if(Pattern.matches(".*[Ω]+.*[\\d]+",inText.getText())) {
	        	float result = Float.parseFloat(this.compute(inText.getText()));
	        	if(result % 1 == 0) {
	        		history.append(inText.getText() + " = " + (int)result + "\n");
	            	inText.setText((int)result+"");
	        	} else {
	        		history.append(inText.getText() + " = " + result + "\n");
	            	inText.setText(result+"");
	        	}
	        	if(result == this.returnTar()) {
	        		tLabel.setBackground(Color.GREEN);
	        		tLabel.setText("COMPLETE!");
	        		nextLvlBtn.setVisible(true);
	        	}
        	}
        });
        
        btnClear = initBtn("C",x[3],y[4], event -> {
        	if(Pattern.matches("[0]*",inText.getText())) {
        		inText.setText("");
        	} else {
        		inText.setText("");
        	}
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
        buttons[13] = btnDot;

        window.setLayout(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
	}
	public void disable(int[] keys) {
		nextLvlBtn.setVisible(false);
		tLabel.setBackground(Color.BLACK);
		for (int i = 0; i < buttons.length; i++) buttons[i].setEnabled(true);
		for(int i = 0; i < keys.length; i++) buttons[keys[i]].setEnabled(false);
			
		
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
	private ActionListener levelSwitch = event -> {
		String selectedLevel =  (String)levelCombo.getSelectedItem();
		setLevel(returnLvl(selectedLevel));
		inText.setText("");
    	history.setText("");
    	
	};
	
	public void setLevel(level l) {
		//remove action listening before adding to prevent duplicate levels added
		levelCombo.removeActionListener(levelSwitch);
		if(l.lvl > levelCombo.getItemCount()) 
			if(levelCombo.getItemCount()==0) for(int i = 1; i <= l.lvl; i++) levelCombo.addItem(String.valueOf(i));
			else levelCombo.addItem(String.valueOf(l.lvl));
		levelCombo.addActionListener(levelSwitch);
		levelCombo.setSelectedIndex(l.lvl-1);
		disable(l.disableKeys);
		tLabel.setText("Target: "+(int)l.target);
	}
}




































