package swing.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;

import swing.panels.MainPanel;

public class MainFrame extends JFrame {

	private MainPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 350);
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel);
		setTitle("Students Application");
	}
}
