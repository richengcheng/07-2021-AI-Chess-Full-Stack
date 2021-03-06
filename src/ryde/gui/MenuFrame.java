package ryde.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 *
 *
 */
public class MenuFrame extends JFrame implements ActionListener {
	JPanel contentPane,pane,helpPanel;
	JButton playSingalButton,playDoubleButton,helpButton,exitButton;
	static MenuFrame  menuFrame;

	static MainPlayFrame mainPlayFrame;
	public MenuFrame(){
		contentPane = new JPanel();
		contentPane.setLayout(null);
		// adding button
		playSingalButton=new JButton("fight for human");
		helpButton =new JButton("help");
		exitButton=new JButton("exit");
		addButton(playSingalButton,150, 150, 150, 30);
	//	addButton(playDoubleButton,200, 200, 100, 30);
		addButton(helpButton,150, 250, 150, 30);
		addButton(exitButton,150, 300, 150, 30);
		setContentPane(contentPane);
		setSize(510, 620);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public void addButton(JButton b,int x,int y,int width,int hight){
		b.setBounds(x, y, width, hight);
		b.addActionListener(this);
		contentPane.add(b);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playSingalButton) {
			setVisible(false);
			mainPlayFrame = new MainPlayFrame(false, true);
			//ChessBoardPanel.coverPanel.setVisible(false);
		} else if (e.getSource() == playDoubleButton) {

//			contentPane.revalidate();
//			repaint();

			this.setVisible(false);
			
		
		}else if (e.getSource()==helpButton) {
			JOptionPane.showMessageDialog(contentPane, "nothing could help");
		}else if (e.getSource()==exitButton) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		menuFrame=new MenuFrame();
	}
}
