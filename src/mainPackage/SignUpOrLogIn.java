package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpOrLogIn extends JFrame implements ActionListener{

	private static final long serialVersionUID = -4968651795797070751L;
	
	JPanel containerPanel;
	JButton signUp,logIn;
	JLabel welcomeText;
	
	public SignUpOrLogIn() {
		
		//frame properties
		this.setTitle("Welcom to OskuDa.com");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);

		//container properties
		containerPanel = new JPanel();
		containerPanel.setBounds(50,150,400,200);
		containerPanel.setLayout(new GridLayout(1,2,20,10));

		welcomeText = new JLabel("Welcome!");
		welcomeText.setFont(new Font("MV Boli",Font.BOLD,50));
		welcomeText.setBounds(150,25,300,100);
		welcomeText.setForeground(Color.ORANGE);
		welcomeText.setOpaque(true);
		
		//buttons
		signUp = new JButton("SignUp!");
		logIn = new JButton("LogIn!");
		signUp.setFocusable(false);
		logIn.setFocusable(false);
		signUp.addActionListener(this);
		logIn.addActionListener(this);
		signUp.setFont(new Font("Ink Free",Font.ITALIC,35));
		logIn.setFont(new Font("Ink Free",Font.ITALIC,35));
		
		
		containerPanel.add(signUp);
		containerPanel.add(logIn);
		
		this.add(welcomeText);
		this.add(containerPanel);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logIn) {
			this.dispose();
			new LogInFrame();
			
		}else if(e.getSource()==signUp) {
			this.dispose();
			new SignUpFrame();
		}
	}
	
	
}
