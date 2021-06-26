/*
 *shogi Java
 * adding function
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

// main class
public class ChessTest{
	public static void main(String args[]){
		new ChessMainFrame("shogi battle");
	}
}

//Main frame class
class ChessMainFrameTest extends JFrame implements ActionListener,MouseListener,Runnable{
	// chess
	JLabel play[] = new JLabel[16];
	//JLabel play[] = new JLabel[32];
	//board
	JLabel image;
	//frame
	Container con;
	//tools
	JToolBar jmain;
	//restart
	JButton anew;
	//Regret chess
	JButton repent;
	//exit
	JButton exit;
	//current infor
	JLabel text;

	//Save current operation
	Vector Var;

	//Rule class object (for calling methods)
	ChessRule rule;

	/**
	** Click the chess piece
	** chessManClick = true  Flash the chess pieces and respond to the thread
	** chessManClick = false take the pawn, stop blinking, and respond to the thread
	 * * */
	boolean chessManClick;





	/**
	** Control the player to move
	** chessPlayClick=1 up player can play
	** chessPlayClick=2 down player can play default
	** chessPlayClick=3 Neither side can play chess
	*/
	int chessPlayClick=2;

	//The thread that controls the flickering of the chess pieces
	Thread tmain;
	//Give the thread a response to the first click of the chess piece
	static int Man,i;

	ChessMainFrameTest(){
		new ChessMainFrame("ShoGi");
	}

	/**
	** Constructor
	 ** Initialize the graphical user interface
	*/
	ChessMainFrameTest(String Title){
	//	Change the system default font
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		//Quotation
		con = this.getContentPane();
		con.setLayout(null);
		//Instantiate rule class
		rule = new ChessRule();
		Var = new Vector();

		//Create toolbar
		jmain = new JToolBar();
		text = new JLabel("welcome to use ShoGi");
		//Display information when the mouse is placed
		text.setToolTipText("information");
		anew = new JButton(" New Game ");
		anew.setToolTipText("restart new game ");
		exit = new JButton(" exit");
		exit.setToolTipText("exit");
		repent = new JButton(" go back to the last stage");
		repent.setToolTipText("confirm");

		//Add components to the toolbar
		jmain.setLayout(new GridLayout(0,4));
		jmain.add(anew);
		jmain.add(repent);
		jmain.add(exit);
		jmain.add(text);
		jmain.setBounds(0,0,800,30);
		con.add(jmain);

		//Add a piece tag
		drawChessMan();

		//Register button monitor
		anew.addActionListener(this);
		repent.addActionListener(this);
		exit.addActionListener(this);

		//Register chess move monitor
		for (int i=0;i<16;i++){
			con.add(play[i]);
			play[i].addMouseListener(this);
		}
		/**
		for (int i=0;i<32;i++){
			con.add(play[i]);
			play[i].addMouseListener(this);
		}
		*/
		//Add checkerboard label
		con.add(image = new JLabel(new ImageIcon("image\\shogiBoard.jpg")));
		image.setBounds(0,30,800,1050);
		image.addMouseListener(this);

		//Registration form closed listener
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent we){
					System.exit(0);
				}
			}
		);

		//Center the form
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();

		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}

		this.setLocation((screenSize.width - frameSize.width) / 2 - 280 ,(screenSize.height - frameSize.height ) / 2 - 350);

		//setting
		//this.setIconImage(new ImageIcon("image\\�콫.GIF").getImage());
		this.setResizable(true);
		this.setTitle(Title);
		this.setSize(850,1050);
		this.show();
	}

	/**
	** Method of adding pieces
	*/
	public void drawChessMan(){
		//���̿���
		int i,k;
		//ͼ��
		Icon in;

		//��ɫ����

		//��

		/// up player

		in = new ImageIcon("image\\catUp.png");
		for (i=0,k=40;i<2;i++,k+=500){
			play[i] = new JLabel(in);
			play[i].setBounds(k,150,200,200);
			play[i].setName("1");
		}


		in = new ImageIcon("image\\dogUp.png");
		for (i=4,k=180;i<6;i++,k+=240){
			play[i] = new JLabel(in);
			play[i].setBounds(k,150,200,200);
			play[i].setName("1");
		}

		in = new ImageIcon("image\\lionUp.png");
		for (i=14,k=300;i<15;i++,k+=180){
			play[i] = new JLabel(in);
			play[i].setBounds(k,150,200,200);
			play[i].setName("1");
		}


		in = new ImageIcon("image\\chickenUp.png");
		for (i=8,k=180;i<11;i++,k+=120){
			play[i] = new JLabel(in);
			play[i].setBounds(k,380,200,200);
			play[i].setName("1");
		}



		//// down player

		in = new ImageIcon("image\\catDown.png");
		for (i=2,k=40;i<4;i++,k+=500){
			play[i] = new JLabel(in);
			play[i].setBounds(k,770,200,200);
			play[i].setName("2");
		}

		in = new ImageIcon("image\\dogDown.png");
		for (i=6,k=180;i<8;i++,k+=240){
			play[i] = new JLabel(in);
			play[i].setBounds(k,770,200,200);
			play[i].setName("2");
		}


		in = new ImageIcon("image\\lionDown.png");
		for (i=15,k=300;i<16;i++,k+=180){
			play[i] = new JLabel(in);
			play[i].setBounds(k,770,200,200);
			play[i].setName("2");
		}

		in = new ImageIcon("image\\chickenDown.png");
		for (i=11,k=180;i<14;i++,k+=120){
			play[i] = new JLabel(in);
			play[i].setBounds(k,530,200,200);
			play[i].setName("2");
		}



	}

	/**
	** Thread method to control the flicker of chess pieces
	*/
	public void run(){
		while (true){
			//Click the chess piece to start blinking for the first time
			if (chessManClick){
				play[Man].setVisible(false);

				//ʱ�����
				try{
					tmain.sleep(200);
				}
				catch(Exception e){
				}

				play[Man].setVisible(true);

			}

			//Flash the current prompt information so that the user does not see it
			else {
				text.setVisible(false);

				//ʱ�����
				try{
					tmain.sleep(250);
				}
				catch(Exception e){
				}

				text.setVisible(true);
			}

			try{
				tmain.sleep(350);
			}
			catch (Exception e){
			}
		}
	}
	
	/**
	** �������ӷ���
	*/
	public void mouseClicked(MouseEvent me){
		System.out.println("Mouse");
		
		//��ǰ����
		int Ex=0,Ey=0;
		
		//�����߳�
		if (tmain == null){
			tmain = new Thread(this);
			tmain.start();
		}
		
		//��������(�ƶ�����)
		if (me.getSource().equals(image)){
			//�ú��������ʱ��
			if (chessPlayClick == 2 && play[Man].getName().charAt(0) == '2'){
				Ex = play[Man].getX();
				Ey = play[Man].getY();

				//moving chicken
				if (Man >= 8 && Man < 14){
					rule.chickenRule(Man,play[Man],me);
				}
				//moving cat
				if (Man >= 0 && Man < 4){
					rule. catRule(Man,play[Man],me);
				}

				/**
				//moving lion
				if (Man >= 14 && Man < 16){
					rule.lionRule(Man,play[Man],me);
				}

				//moving dog
				if (Man >= 4 && Man < 8){
					rule.dogRule(Man,play[Man],me);
				}



*/
			}//if
			
			//�ú��������ʱ��
			else if (chessPlayClick == 1 && play[Man].getName().charAt(0) == '1'){
				Ex = play[Man].getX();
				Ey = play[Man].getY();


				//moving chicken
				if (Man >= 8 && Man < 14){
					rule.chickenRule(Man,play[Man],me);
				}

				//moving cat
				if (Man >= 0 && Man < 4){
					rule. catRule(Man,play[Man],me);
				}

/**
				//moving lion
				if (Man >= 14 && Man < 16){
					rule.lionRule(Man,play[Man],me);
				}

				//moving dog
				if (Man >= 4 && Man < 8){
					rule.dogRule(Man,play[Man],me);
				}


*/
			}//else if		
			
			//��ǰû�в���(ֹͣ��˸)
			chessManClick=false;
			
		}//if
		
		//��������
		else{
			//��һ�ε�������(��˸����)
			if (!chessManClick){
				for (int i=0;i<16;i++){
					//������������
					if (me.getSource().equals(play[i])){
						//�����߳��ø�������˸
						Man=i;
						//��ʼ��˸
						chessManClick=true;
						break;
					}
				}//for
			}//if
			
			//�ڶ��ε�������(������)
			else if (chessManClick){
				//��ǰû�в���(ֹͣ��˸)
				chessManClick=false;
				
				for (i=0;i<16;i++){
					//�ҵ����Ե�����
					if (me.getSource().equals(play[i])){
						//�ú�������ʱ��
						System.out.print("man is "+ Man);

						if (chessPlayClick == 2 && play[Man].getName().charAt(0) == '2'){
							Ex = play[Man].getX();
							Ey = play[Man].getY();
							
							// chicken rule
							if (Man >= 8 && Man < 14){
								rule.chickenRule(play[Man],play[i]);
							}
/**
							// cat rule
							if (Man >= 0 && Man < 4){
								rule.catRule(0,play[Man],play[i],play,me);
							}
*/
							/**
							//�ڳԹ���
							else if (Man > 25 && Man < 30){
								rule.cannonRule(0,play[Man],play[i],play,me);
							}
							
							//���Թ���
							else if (Man >=0 && Man < 4){
								rule.cannonRule(1,play[Man],play[i],play,me);
							}
							
							//��Թ���
							else if (Man > 3 && Man < 8){
								rule.horseRule(play[Man],play[i],play,me);	
							}
							
							//�ࡢ��Թ���
							else if (Man > 7 && Man < 12){
								rule.elephantRule(play[Man],play[i],play);
							}
							
							//ʿ���˳������
							else if (Man > 11 && Man < 16){
								rule.chapRule(Man,play[Man],play[i],play);
							}
							
							//����˧�������
							else if (Man == 30 || Man == 31){
								rule.willRule(Man,play[Man],play[i],play);
								play[Man].setVisible(true);	
							}

							*/
							//�Ƿ��������(�Ƿ���ԭ��û�ж�)
							if (Ex == play[Man].getX() && Ey == play[Man].getY()){
								text.setText("               ��������");
								chessPlayClick=2;
								break;
							}
														
							else{
								text.setText("               ��������");
								chessPlayClick=1;
								break;
							}	
							
						}//if
						
						//�ú�������ʱ��
						else if (chessPlayClick == 1 && play[Man].getName().charAt(0) == '1'){
							Ex = play[Man].getX();
							Ey = play[Man].getY();
													
							//��Թ���
							if (Man >= 8 && Man < 14){
								rule.chickenRule(play[Man],play[i]);
							}
							/**
							//�ڳԹ���
							else if (Man > 25 && Man < 30){
								rule.cannonRule(0,play[Man],play[i],play,me);
							}
							
							//���Թ���
							else if (Man >=0 && Man < 4){
								rule.cannonRule(1,play[Man],play[i],play,me);	
							}
							
							//��Թ���
							else if (Man > 3 && Man < 8){
								rule.horseRule(play[Man],play[i],play,me);
							}
							
							//�ࡢ��Թ���
							else if (Man > 7 && Man < 12){
								rule.elephantRule(play[Man],play[i],play);
							}
							
							//ʿ���˳������
							else if (Man > 11 && Man < 16){
								rule.chapRule(Man,play[Man],play[i],play);
							}
							
							//����˧�������
							else if (Man == 30 || Man == 31){
								rule.willRule(Man,play[Man],play[i],play);
								play[Man].setVisible(true);			
							}
							*/
							//�Ƿ��������(�Ƿ���ԭ��û�ж�)
							if (Ex == play[Man].getX() && Ey == play[Man].getY()){
								text.setText("               ��������");
								chessPlayClick=1;
								break;
							}
				
							else {
								text.setText("               ��������");
								chessPlayClick=2;	
								break;
							}
														
						}//else if 
						
					}//if
					
				}//for
				
				
				//�Ƿ�ʤ��
				if (!play[15].isVisible()){
					JOptionPane.showConfirmDialog(
						this,"����ʤ��","���һʤ��",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					//˫������������������
					chessPlayClick=3;
					text.setText("  ����ʤ��");
					
				}//if 

				else if (!play[14].isVisible()){
					JOptionPane.showConfirmDialog(
						this,"����ʤ��","��Ҷ�ʤ��",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					chessPlayClick=3;
					text.setText("  ����ʤ��");
				}//else if	
				
			}//else
			
		}//else
		
	}
	
	public void mousePressed(MouseEvent me){
	}
	public void mouseReleased(MouseEvent me){
	}
	public void mouseEntered(MouseEvent me){
	}
	public void mouseExited(MouseEvent me){
	}
	
	/**
	** ���尴ť���¼���Ӧ
	*/
	public void actionPerformed(ActionEvent ae) {
		//���¿�ʼ��ť
		if (ae.getSource().equals(anew)){
			int i,k;
			//��������ÿ�����ӵ�λ��
			//��ɫ����

			//��
			for (i=0,k=24;i<2;i++,k+=456){
				play[i].setBounds(k,56,55,55);
			}

			//��
			for (i=4,k=81;i<6;i++,k+=342){
				play[i].setBounds(k,56,55,55);
			}

			//��
			for (i=8,k=138;i<10;i++,k+=228){
				play[i].setBounds(k,56,55,55);
			}

			//ʿ
			for (i=12,k=195;i<14;i++,k+=114){
				play[i].setBounds(k,56,55,55);
			}

			//��
			for (i=16,k=24;i<21;i++,k+=114){
				play[i].setBounds(k,227,55,55);
			}

			//��
			for (i=26,k=81;i<28;i++,k+=342){
				play[i].setBounds(k,170,55,55);
			}

			//��
			play[30].setBounds(252,56,55,55);

			//��ɫ����
			//��
			for (i=2,k=24;i<4;i++,k+=456){
				play[i].setBounds(k,569,55,55);
			}

			//��
			for (i=6,k=81;i<8;i++,k+=342){
				play[i].setBounds(k,569,55,55);
			}

			//��
			for (i=10,k=138;i<12;i++,k+=228){
				play[i].setBounds(k,569,55,55);
			}

			//ʿ
			for (i=14,k=195;i<16;i++,k+=114){
				play[i].setBounds(k,569,55,55);
			}

			//��
			for (i=21,k=24;i<26;i++,k+=114){
				play[i].setBounds(k,398,55,55);
			}

			//��
			for (i=28,k=81;i<30;i++,k+=342){
				play[i].setBounds(k,455,55,55);
			}

			//˧
			play[31].setBounds(252,569,55,55);



			chessPlayClick = 2;
			text.setText("               ��������");

			for (i=0;i<32;i++){
				play[i].setVisible(true);
			}
			//���Vector�е�����
			Var.clear();

		}

		//���尴ť
		else if (ae.getSource().equals(repent)){
			try{
				//���setVisible����ֵ
				String S = (String)Var.get(Var.size()-4);
				//���X����
				int x = Integer.parseInt((String)Var.get(Var.size()-3));
				//���Y����
				int y = Integer.parseInt((String)Var.get(Var.size()-2));
				//�������
				int M = Integer.parseInt((String)Var.get(Var.size()-1));

				//��������
				play[M].setVisible(true);
				play[M].setBounds(x,y,55,55);

				if (play[M].getName().charAt(1) == '1'){
					text.setText("               ��������");
					chessPlayClick = 1;
				}
				else{
					text.setText("               ��������");
					chessPlayClick = 2;
				}

				//ɾ���ù�������
				Var.remove(Var.size()-4);
				Var.remove(Var.size()-3);
				Var.remove(Var.size()-2);
				Var.remove(Var.size()-1);

				//ֹͣ������˸
				chessManClick=false;
			}

			catch(Exception e){
			}
		}

		//�˳�
		else if (ae.getSource().equals(exit)){
			int j=JOptionPane.showConfirmDialog(
				this,"���Ҫ�˳���?","�˳�",
				JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);

			if (j == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}

	/*�����й�����������*/
	class ChessRule {
		/**���ӵ��ƶ�����*/
		public void chickenRule(int Man,JLabel play,MouseEvent me){
			//��������
			if (Man < 11){
				//�����ƶ����õ��յ������ģ���ɺϷ�������
				System.out.println("play.getY()"+play.getY());
				System.out.println("me.getY()"+me.getY());
				if ((me.getY()-play.getY()) > 62 && (me.getY()-play.getY()) < 186 )
					/**	&& (me.getX()-play.getX()) < 180 && (me.getX()-play.getX()) > 62)*/{

				//if ((me.getY()-play.getY()) > 27 && (me.getY()-play.getY()) < 86 && (me.getX()-play.getX()) < 55 && (me.getX()-play.getX()) > 0){
					

					play.setBounds(play.getX(),play.getY()+124,200,200);
				}
				/**
				//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������				
				else if (play.getY() > 284 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112){
					play.setBounds(play.getX()+57,play.getY(),55,55);	
				}

				//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������
				else if (play.getY() > 284 && (play.getX() - me.getX()) >= 2 && (play.getX() - me.getX()) <=58){
					//ģ������
					play.setBounds(play.getX()-57,play.getY(),55,55);
				}
				 */
			}

			
			//��������
			else{

				System.out.println("play.getY()"+play.getY());
				System.out.println("me.getY()"+me.getY());
				if ((play.getY()-me.getY()) > 62 && (play.getY()-me.getY()) < 186 )
					/**	&& (me.getX()-play.getX()) < 180 && (me.getX()-play.getX()) > 62)*/{

					//if ((me.getY()-play.getY()) > 27 && (me.getY()-play.getY()) < 86 && (me.getX()-play.getX()) < 55 && (me.getX()-play.getX()) > 0){


					play.setBounds(play.getX(),play.getY()-124,200,200);
				}

				/**
				//�����ƶ����õ��յ������ģ���ɺϷ�������
				if ((me.getX()-play.getX()) >= 0 && (me.getX()-play.getX()) <= 55 && (play.getY()-me.getY()) >27 && play.getY()-me.getY() < 86){
					play.setBounds(play.getX(),play.getY()-57,55,55);
				}
				
				//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������
				else if (play.getY() <= 341 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112){
					play.setBounds(play.getX()+57,play.getY(),55,55);
				}				
				
				//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������
				else if (play.getY() <= 341 && (play.getX() - me.getX()) >= 3 && (play.getX() - me.getX()) <=58){
					play.setBounds(play.getX()-57,play.getY(),55,55);
				}
				*/
			}
		}//���ƶ�����

		/**��������*/
		public void chickenRule(JLabel play1,JLabel play2){

			System.out.println("play1.getY()"+play1.getY());
			System.out.println("play2.getY())"+play2.getY());

			if ((play2.getY()-play1.getY()) > 100 && (play2.getY()-play1.getY()) < 170 )
				//this is for tolerance of algorithm deviation
				if(play2.getX() - play1.getX() <= 20 || (play2.getX() - play1.getX() )>= 20){
			/**	&& (me.getX()-play.getX()) < 180 && (me.getX()-play.getX()) > 62)*/{

					play2.setVisible(false);
					//got the place from another chess
					play1.setBounds(play2.getX(), play2.getY(), 200, 200);
				}

			}

			if ((play1.getY()-play2.getY()) > 100 && (play1.getY()-play2.getY()) < 170 )
				//this is for tolerance of algorithm deviation
				if(play2.getX() - play1.getX() <= 20 ||(play2.getX() - play1.getX() )>= 20){
					/**	&& (me.getX()-play.getX()) < 180 && (me.getX()-play.getX()) > 62)*/{

						play2.setVisible(false);
						//got the place from another chess
						play1.setBounds(play2.getX(), play2.getY(), 200, 200);
					}

				}


			/**
			//������
			if ((play2.getX() - play1.getX()) <= 112 && (play2.getX() - play1.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1)){
				//����Ҫ���Ӳ����ҳ���
				if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)){

					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);
				}
				
				//����Ҫ���Ӳ����ܳ���
				else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1)){
					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);				
				}
			}

			
			//������
			else if ((play1.getX() - play2.getX()) <= 112 && (play1.getX() - play2.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1)){
				//����Ҫ���Ӳ��������
				if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)){
					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);
				}
				
				//����Ҫ���Ӳ����ҳ���
				else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1)){
					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);				
				}
			}
			
			//������
			else if (play1.getX() - play2.getX() >= -22 && play1.getX() - play2.getX() <= 22 && play1.getY() - play2.getY() >= -112 && play1.getY() - play2.getY() <= 112){
				//���岻�����ϳ���
				if (play1.getName().charAt(1) == '1' && play1.getY() < play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1)){
					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);
				}
				
				//���岻�����³���
				else if (play1.getName().charAt(1) == '2' && play1.getY() > play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1)){
					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);
				}
			 */



		}//��Խ���
		
		/**�ڡ����ƶ�����*/
		public void catRule(int Man,JLabel play,MouseEvent me){
			System.out.println("play.getY()"+play.getY());
			System.out.println("me.getY()"+me.getY());
			System.out.println("play.getX()"+play.getX());
			System.out.println("me.getX()"+me.getX());

			/**up right and up left */
			if (Man < 2) {

				// the cat is going down at beginning
				if ((me.getY() - play.getY()) > 62 && (me.getY() - play.getY()) < 186) {
					System.out.println("111111111111111111111111");

					if ((me.getX()-play.getX()) < 150 && (me.getX()-play.getX()) > 90){

						play.setBounds(play.getX()+125, play.getY()+125 , 200, 200);
						return ;
					}

					if ((play.getY()-me.getY()) > 90 && (play.getY()-me.getY()) < 150 ) {

						play.setBounds(play.getX()-125, play.getY()+125 , 200, 200);
						return ;
					}
				}


			} else{
				System.out.println("222222222222222222222222222222");
				//the cat is going up at beginning
				if ((play.getY()-me.getY()) > 62 && (play.getY()-me.getY()) < 186 ) {

					if ((me.getX()-play.getX()) < 150 && (me.getX()-play.getX()) > 90){

						play.setBounds(play.getX()+125, play.getY()-125 , 200, 200);
						return ;
					}

					if ((play.getY()-me.getY()) > 90 && (play.getY()-me.getY()) < 150 ) {

						play.setBounds(play.getX()-125, play.getY()-125, 200, 200);
						return ;
					}

				}

			}


			/**up and down  rule*/
			System.out.println("3333333333333333333333333333333");
			if ((me.getY() - play.getY()) > 62 && (me.getY() - play.getY()) < 186) {

				play.setBounds(play.getX(), play.getY() + 124, 200, 200);
				return ;
			}

			if ((play.getY()-me.getY()) > 62 && (play.getY()-me.getY()) < 186 ) {

				play.setBounds(play.getX(), play.getY() - 124, 200, 200);
				return ;
			}

			/**left and right*/

			System.out.println("444444444444444444444444444444444");
			if ((me.getX()-play.getX()) < 150 && (me.getX()-play.getX()) > 90){

				play.setBounds(play.getX()+125, play.getY() , 200, 200);
				return ;
			}

			if ((play.getY()-me.getY()) > 90 && (play.getY()-me.getY()) < 150 ) {

				play.setBounds(play.getX()-125, play.getY() , 200, 200);
				return ;
			}




		}//�ڡ����ƶ���������

		
	}//������
	
}//�������