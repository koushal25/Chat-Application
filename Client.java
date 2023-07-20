//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Font;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;

package chatApplication;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class Client implements ActionListener{

private static final long serialVersionUID = 1L;
	JTextField text;
	static JPanel textarea;
	static Box vertical = Box.createVerticalBox();
	static DataOutputStream dout;
	static JFrame f = new JFrame();

	Client()
	{	
		
		f.setLayout(null);
		
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(7,94,56));
		p1.setBounds(0,0,450,70);
		p1.setLayout(null);
		f.add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
		
		Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); 
		JLabel back = new JLabel(i3);
		back.setBounds(5,20,25,25);
		p1.add(back);
		
		back.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent ae)
					{
						System.exit(0);
					}
				});
		
		back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                f.setCursor(Cursor.getDefaultCursor());
            }
        });
		
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
		
		Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5); 
		JLabel profile = new JLabel(i6);
		profile.setBounds(45,10,50,50);
		p1.add(profile);
		
		
		 ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
			
			Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
			ImageIcon i9 = new ImageIcon(i8); 
			JLabel video = new JLabel(i9);
			video.setBounds(300,20,30,30);
			p1.add(video);
			
			
			
			 ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
				
				Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
				ImageIcon i12 = new ImageIcon(i11); 
				JLabel phone = new JLabel(i12);
				phone.setBounds(350,20,35,30); //image position , image size ---> parameters
				p1.add(phone);
				
				 ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
					
					Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
					ImageIcon i15 = new ImageIcon(i14); 
					JLabel morevert = new JLabel(i15);
					morevert.setBounds(430,20,10,25); //image position , image size ---> parameters
					p1.add(morevert);
		
		
		//JLable used to write anything on a frame 
					
					
		JLabel name = new JLabel(" TUM ");
		name.setBounds(110,20,100,18);
		name.setForeground(Color.white);
		name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		p1.add(name);
					
		
		JLabel status = new JLabel("Active Now");
		status.setBounds(110,40,100,18);
		status.setForeground(Color.white);
		status.setFont(new Font("SAN_SERIF",Font.BOLD,14));
		p1.add(status);
		
		
		//Creating a new panel
		
		
		textarea = new JPanel();
		textarea.setBounds(5,75 , 440, 570);		
		f.add(textarea);
		
		text = new JTextField();
		text.setBounds(5,655,310,40);
		text.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		f.add(text);
		
		
		JButton send = new JButton("Send");
		send.setBounds(320,655,123,40);
		send.setBackground(new Color (7,94,84));
		send.setForeground(Color.white);
		send.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		
		
		send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                f.setCursor(Cursor.getDefaultCursor());
            }
        });
		send.addActionListener(this);
		
			
		f.add(send);
					
		
		f.setSize(450,700);
		
		f.setLocation(800,50);
		f.setUndecorated(true); // to remove the header
		f.getContentPane().setBackground(Color.WHITE);
		
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		try {
			String out=text.getText();
			
			JPanel p2 = formatLabel(out);
		
			
			textarea.setLayout(new BorderLayout());
			
			JPanel right= new JPanel(new BorderLayout());
			right.add(p2,BorderLayout.LINE_END);
			
			vertical.add(right);
			vertical.add(Box.createVerticalStrut(15));
			
			textarea.add(vertical,BorderLayout.PAGE_START);
			
			dout.writeUTF(out); //Protocol
			
			text.setText("");
			
			f.repaint();
			f.invalidate();
			f.validate();
			
		} catch( Exception e)
		{
			e.printStackTrace();
		}
//			JScrollPane scrollPane = new JScrollPane(textarea);
//	        textarea.add(scrollPane, BorderLayout.CENTER);
	}
	
	
	public static JPanel formatLabel (String out)
	{
		JPanel panel=new JPanel();
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JLabel output = new JLabel("<html><p style=\"width:150px\">" + out +  "</p></html>");
		
		output.setFont(new Font("Tahoma",Font.PLAIN,20));
		output.setBackground(new Color(37,211,102));
		output.setOpaque(true);
		output.setBorder(new EmptyBorder(15,15,15,50));
		
		panel.add(output);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		JLabel time = new JLabel();
		time.setText(sdf.format(cal.getTime()));
		
		panel.add(time);
		
		return panel;
	}
	
	
	public static void main(String[] args)
	{
		new Client();  //ANONYMOUS OBJ
		
		try {
			
			Socket s = new Socket("127.0.0.1" , 6001);
			DataInputStream din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			while(true)
			{
				// To read received messages
				textarea.setLayout(new BorderLayout());
				String msg = din.readUTF();
				
				// After reading and getting message in msg we have to put in  the  frame using panel
				JPanel panel = formatLabel(msg);
				
				JPanel left = new JPanel(new BorderLayout());
				left.add(panel,BorderLayout.LINE_START);
				vertical.add(left);
				
				vertical.add(Box.createVerticalStrut(15));
				textarea.add(vertical,BorderLayout.PAGE_START);
				
				f.validate(); // for refreshing the frame after getting each message
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}