package virtualKeyboard;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class virtualKeyboard {
	private JFrame frame;
	private JTextArea textArea;

	virtualKeyboard() {
		// create a frame and set the title for project
		frame = new JFrame("Typing tutor");
		frame.setLayout(null);

		// create labels for hints and place it to a panel
		JPanel pnlHint = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel(
				"Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed. ");
		pnlHint.add(label);
		label = new JLabel("Note: Clicking the buttons with your mouse will not pdrform any action.");
		pnlHint.add(label);
		pnlHint.setBounds(10, 5, 700, 40);
		// create a text area for display what it's typing
		textArea = new JTextArea();
		textArea.setBounds(10, 55, 680, 183);
		// add those to the frame
		frame.add(pnlHint);
		frame.add(textArea);

		// first line of the keyboard
		makeButton("~", 10, 260, 50, KeyEvent.VK_BACK_QUOTE);
		makeButton("1", 55, 260, 50, KeyEvent.VK_1);
		makeButton("2", 100, 260, 50, KeyEvent.VK_2);
		makeButton("3", 145, 260, 50, KeyEvent.VK_3);
		makeButton("4", 190, 260, 50, KeyEvent.VK_4);
		makeButton("5", 235, 260, 50, KeyEvent.VK_5);
		makeButton("6", 280, 260, 50, KeyEvent.VK_6);
		makeButton("7", 325, 260, 50, KeyEvent.VK_7);
		makeButton("8", 370, 260, 50, KeyEvent.VK_8);
		makeButton("9", 415, 260, 50, KeyEvent.VK_9);
		makeButton("0", 460, 260, 50, KeyEvent.VK_0);
		makeButton("-", 505, 260, 50, KeyEvent.VK_MINUS);
		makeButton("+", 550, 260, 50, KeyEvent.VK_EQUALS);
		makeButton("Backspace", 595, 260, 100, KeyEvent.VK_BACK_SPACE);

		// second line of the keyboard
		makeButton("TAB", 10, 305, 78, KeyEvent.VK_TAB);
		makeButton("Q", 83, 305, 50, KeyEvent.VK_Q);
		makeButton("W", 128, 305, 50, KeyEvent.VK_W);
		makeButton("E", 173, 305, 50, KeyEvent.VK_E);
		makeButton("R", 218, 305, 50, KeyEvent.VK_R);
		makeButton("T", 263, 305, 50, KeyEvent.VK_T);
		makeButton("Y", 308, 305, 50, KeyEvent.VK_Y);
		makeButton("U", 353, 305, 50, KeyEvent.VK_U);
		makeButton("I", 398, 305, 50, KeyEvent.VK_I);
		makeButton("O", 443, 305, 50, KeyEvent.VK_O);
		makeButton("P", 488, 305, 50, KeyEvent.VK_P);
		makeButton("[", 533, 305, 50, KeyEvent.VK_OPEN_BRACKET);
		makeButton("]", 578, 305, 50, KeyEvent.VK_CLOSE_BRACKET);
		makeButton("\\", 623, 305, 50, KeyEvent.VK_BACK_SLASH);

		// third line of the keyboard
		makeButton("Caps", 10, 350, 78, KeyEvent.VK_CAPS_LOCK);
		makeButton("A", 83, 350, 50, KeyEvent.VK_A);
		makeButton("S", 128, 350, 50, KeyEvent.VK_S);
		makeButton("D", 173, 350, 50, KeyEvent.VK_D);
		makeButton("F", 218, 350, 50, KeyEvent.VK_F);
		makeButton("G", 263, 350, 50, KeyEvent.VK_G);
		makeButton("H", 308, 350, 50, KeyEvent.VK_H);
		makeButton("J", 353, 350, 50, KeyEvent.VK_J);
		makeButton("K", 398, 350, 50, KeyEvent.VK_K);
		makeButton("L", 443, 350, 50, KeyEvent.VK_L);
		makeButton(":", 488, 350, 50, KeyEvent.VK_SEMICOLON);
		makeButton("\"", 533, 350, 50, KeyEvent.VK_QUOTE);
		makeButton("Enter", 578, 350, 95, KeyEvent.VK_ENTER);

		// fourth line of the keyboard
		makeButton("Shift", 10, 395, 100, KeyEvent.VK_SHIFT);
		makeButton("Z", 105, 395, 50, KeyEvent.VK_Z);
		makeButton("X", 150, 395, 50, KeyEvent.VK_X);
		makeButton("C", 195, 395, 50, KeyEvent.VK_C);
		makeButton("V", 240, 395, 50, KeyEvent.VK_V);
		makeButton("B", 285, 395, 50, KeyEvent.VK_B);
		makeButton("N", 330, 395, 50, KeyEvent.VK_N);
		makeButton("M", 375, 395, 50, KeyEvent.VK_M);
		makeButton(",", 420, 395, 50, KeyEvent.VK_COMMA);
		makeButton(".", 465, 395, 50, KeyEvent.VK_PERIOD);
		makeButton("?", 510, 395, 50, KeyEvent.VK_SLASH);
		makeButton("\u2191", 578, 395, 50, KeyEvent.VK_UP);

		// fifth line of the keyboard
		makeButton(" ", 185, 440, 310, KeyEvent.VK_SPACE);
		makeButton("\u2190", 533, 440, 50, KeyEvent.VK_LEFT);
		makeButton("\u2193", 578, 440, 50, KeyEvent.VK_DOWN);
		makeButton("\u2192", 623, 440, 50, KeyEvent.VK_RIGHT);

		frame.setSize(700, 530);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// attack a button to the frame, and create an event handler for the
	// keypress /keyrelease
	void makeButton(String label, int x, int y, int w, int keyEvent) {

		JButton btn = new JButton(label);
		// set the position
		btn.setBounds(x, y, w, 50);
		// place the button to the frame
		frame.add(btn);

		// add key listener event driven
		textArea.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// decide if the key is pressing
				if (e.getKeyCode() == keyEvent) {
					btn.setOpaque(true);
					btn.setBackground(Color.YELLOW);// highlighting
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// when the key release
				if (e.getKeyCode() == keyEvent) {
					btn.setOpaque(true);
					btn.setBackground(frame.getBackground());// set back the
																// background
				}
			}
		});
	}

	// main method
	public static void main(String args[]) {
		new virtualKeyboard();
	}

}
