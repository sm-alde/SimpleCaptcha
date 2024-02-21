package captchaGenerator;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	private JButton button;
	private JTextField textField;
	private static JLabel success;
	public String cName;

	MyFrame(){
		this.setLayout(new BorderLayout());
		
		JFrame frame = new JFrame("Captcha Verification");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 500);
		frame.setLayout(new BorderLayout(20,20));
		frame.setVisible(true);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		panel1.setBackground(Color.blue);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		panel4.setBackground(Color.blue);
		panel5.setBackground(Color.white);

		
		panel1.setPreferredSize(new Dimension(100,50));
		panel2.setPreferredSize(new Dimension(100,100));
		panel3.setPreferredSize(new Dimension(100,100));
		panel4.setPreferredSize(new Dimension(100,100));
		panel5.setPreferredSize(new Dimension(100,100));
		
		//PANEL 1 //
		JLabel header = new JLabel();
		header.setPreferredSize(new Dimension(200, 20));
		header.setFont(new Font("Arial", Font.PLAIN, 25));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
		header.setForeground((Color.white));
		header.setText("Verification");
		
		// PANEL 4 //
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250,40));
		textField.setFont(new Font("Arial", Font.PLAIN, 25));
		textField.setText("enter captcha");
		textField.setEditable(true);
		
		button = new JButton("Verify");
		button.addActionListener(this);
		
		success = new JLabel("");
		success.setPreferredSize(new Dimension(50,50));
		
       // PANEL 5 //
	    CaptchaMain captchaMain = new CaptchaMain();
        CaptchaImage captchaImage = captchaMain.generate();
        cName = captchaMain.getCaptchaName();
        JLabel captchaLabel = new JLabel(new ImageIcon(captchaImage.getImage()));
  
        captchaLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(captchaLabel);
        panel5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS)); // Set BoxLayout for vertical alignment
        panel1.add(Box.createVerticalGlue()); // Top glue for vertical centering
        panel1.add(header); // Add the centered label
        panel1.add(Box.createVerticalGlue()); // Top glue for vertical centering

		panel4.add(button, BorderLayout.WEST);
		panel4.add(textField, BorderLayout.CENTER);
		panel4.add(success, BorderLayout.SOUTH);
		panel5.add(captchaLabel, BorderLayout.CENTER);

		// add panels to frame w/ border layout orientations
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel2,BorderLayout.WEST);
		frame.add(panel3,BorderLayout.EAST);
		frame.add(panel4,BorderLayout.SOUTH);
		frame.add(panel5,BorderLayout.CENTER);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(cName);
		//System.out.println(textField.getText());
		
		if(cName.equals(textField.getText())) {
			success.setText("Verified.");
		}
		else {
			success.setText("Denied.");
		}
	}
}