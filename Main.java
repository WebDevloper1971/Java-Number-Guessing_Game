import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Main extends JFrame{
    
    private static JFrame frame;
    private static JLabel result;
    private static JLabel computerChoice;
    private static JTextField userField;

    public static void main(String[] args) {

        frame = new JFrame();
        frame.getContentPane().setBackground(Color.white);

        JLabel title = new JLabel("🤔 Guess The Number 🤔",SwingConstants.CENTER);
        title.setBounds(0,10,486,70);
        title.setFont(new Font("Serif",Font.BOLD,40));

        result = new JLabel("Enter a number between 1 and 5",SwingConstants.CENTER);
        result.setBounds(0,90,486,50);
        result.setFont(new Font("Serif",Font.BOLD,24));

        computerChoice = new JLabel("?",SwingConstants.CENTER);
        computerChoice.setBounds(150,150,150,150);
        computerChoice.setFont(new Font("Serif",Font.BOLD,150));

        userField = new JTextField();
        userField.setBounds(150,310,150,50);
        userField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        userField.setFont(new Font("Serif",Font.BOLD,28));
        userField.setHorizontalAlignment(JTextField.CENTER);


        JButton guess = new JButton("Guess");
        guess.setBounds(150,380,150,50);
        guess.setFont(new Font("Verdana",Font.BOLD,18));
        guess.setBackground(Color.cyan);
        guess.setBorder(BorderFactory.createEmptyBorder());
        guess.setFocusPainted(false);
        guess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                try {
                    Random rand = new Random();

                    int compChoice = rand.nextInt(5);
                    int userChoice = Integer.parseInt(userField.getText());

                    if(userChoice == compChoice){
                        computerChoice.setText(String.valueOf(compChoice));
                        result.setText("You Win !! Are You A Mind Reader");
                        userField.setText("");
                    }else{
                        computerChoice.setText(String.valueOf(compChoice));
                        result.setText("Sorry, You Didn't Guess Correctly");
                        userField.setText("");
                    }
                        
                    
                       
                } catch (Exception ex) {
                    String message = "Please Enter A Number";
                    JOptionPane.showMessageDialog(frame,message);
                }
			}
		});


        frame.add(title);
        frame.add(result);
        frame.add(computerChoice);
        frame.add(userField);
        frame.add(guess);

        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
}
