package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LogInFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -2573383128105751255L;

	JPanel container;
	JTextField userName;
	JPasswordField userPassword;
	JLabel userNameLabel, userPasswordLabel, showPasswordLabel;
	JCheckBox showPassword;
	JButton submit, reset,goBack;
	
	
	public LogInFrame() {
		//frame properties
		this.setTitle("LogIn");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		//main Container properties
		container = new JPanel();
		container.setBorder(BorderFactory.createLineBorder(new Color(169, 184, 175),50));
		container.setLayout(null);
		
		//labels
		userNameLabel = new JLabel("Username:");
		userPasswordLabel = new JLabel("Password:");
		showPasswordLabel = new JLabel("show password");
		userNameLabel.setFont(new Font("MV Boli",Font.PLAIN,20));
		userPasswordLabel.setFont(new Font("MV Boli",Font.PLAIN,20));
		showPasswordLabel.setFont(new Font("Consolas",Font.ITALIC,15));
		userNameLabel.setBounds(75, 130, 100, userNameLabel.getFont().getSize());
		userPasswordLabel.setBounds(75,userNameLabel.getY()+userNameLabel.getHeight()+10,100,userPasswordLabel.getFont().getSize());
		
		//textFields
		userName = new JTextField();
		userPassword = new JPasswordField();
		userName.setBounds(userNameLabel.getX()+userNameLabel.getWidth()+15,userNameLabel.getY(),150,20);
		userName.setBorder(BorderFactory.createLineBorder(new Color(173,255,47), 1, true));
		userPassword.setBounds(userName.getX(),userPasswordLabel.getY(),150,20);
		
		//checkBox
		showPassword = new JCheckBox();
		showPassword.setBounds(userPassword.getX()-5,userPassword.getY()+userPassword.getHeight()+5, 20, 15);
		showPasswordLabel.setBounds(showPassword.getX()+showPassword.getWidth()+5,showPassword.getY()+5,200,15);
		showPassword.addActionListener(this);
		
		//buttons
		submit = new JButton("LogIn");
		reset = new JButton("Reset");
		goBack = new JButton("GoBack!");
		submit.setFont(new Font("MV Boli",Font.PLAIN,30));
		reset.setFont(new Font("MV Boli",Font.PLAIN,30));
		goBack.setFont(new Font("Consolas",Font.PLAIN,15));
		submit.setFocusable(false);
		reset.setFocusable(false);
		goBack.setFocusable(false);
		submit.setBounds(userNameLabel.getX(), showPassword.getY()+showPassword.getHeight()+30, 150, 75);
		reset.setBounds(submit.getX()+submit.getWidth()+15,submit.getY(),submit.getWidth(),submit.getHeight());
		goBack.setBounds(50, 50, 100, 20);
		submit.addActionListener(this);
		reset.addActionListener(this);
		goBack.addActionListener(this);
		
		
		container.add(userNameLabel);
		container.add(userPasswordLabel);
		container.add(showPasswordLabel);
		container.add(userName);
		container.add(userPassword);
		container.add(showPassword);
		container.add(submit);
		container.add(reset);
		container.add(goBack);
		this.add(container,BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==showPassword) {
			if(showPassword.isSelected()) {
			userPassword.setEchoChar((char)(0));
			}else {
				userPassword.setEchoChar('*');
			}
		}
		if(e.getSource()==submit) {
			if(!Database.isValid(userName.getText())) {
				userName.setText("");
				userPassword.setText("");
				JOptionPane.showMessageDialog(null,"Invalid Username!" );
			}else if(!Database.isValid(userName.getText(),String.valueOf(userPassword.getPassword()))) {
				userPassword.setText("");
				JOptionPane.showMessageDialog(null, "Password Incorrect!");				
			}else {
				JOptionPane.showMessageDialog(null, "LogIn Success");
				userName.setText("");
				userPassword.setText("");
				showPassword.setSelected(false);
				userPassword.setEchoChar('*');
			}
		}
		if(e.getSource()==reset) {
			userName.setText("");
			userPassword.setText("");
			showPassword.setSelected(false);
			userPassword.setEchoChar('*');
			Database.initData();
		}
		
		
		
		
		
		
		if(e.getSource()==goBack) {
			this.dispose();
			new SignUpOrLogIn();
		}
	}

}
