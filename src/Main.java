import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("calculator");
        window.setSize(300, 300);
        window.setLayout(new GridLayout(3, 2));
        window.setVisible(true);

        JPanel textboxPanel = new JPanel(new FlowLayout());
        JLabel text = new JLabel("Welcome, in this game you have to try to guess the secret number between 1 and 100!");
        text.setSize(200, 75);
        text.setFont(new Font("Arial", Font.BOLD, 40));
        textboxPanel.add(text);
        window.add(textboxPanel);

        JPanel numberPanel = new JPanel(new FlowLayout());
        JTextField textBox = new JTextField(20);
        textBox.setFont(new Font("Arial", Font.BOLD, 40));
        numberPanel.add(textBox);
        window.add(numberPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton enter = new JButton("Enter guess");
        JButton quit = new JButton("Quit");
        enter.setFont(new Font("Arial", Font.BOLD, 50));
        quit.setFont(new Font("Arial", Font.BOLD, 50));
        buttonPanel.add(enter);
        buttonPanel.add(quit);
        window.add(buttonPanel);
        window.pack();
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;

        enter.addActionListener(new ActionListener() {
            int tries = 0;
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(textBox.getText());
                tries++;
                checkNum(num,randomNumber,text, tries);

                    }
                });

        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText("You have successfully quit the game!");
                System.exit(0);
            }
        });
        }

        public static void checkNum(double num,int randomNumber, JLabel text, int tries){
            if (num == randomNumber) {
                text.setText("Bravo! You guessed the number!");
            } else if (num < randomNumber) {
                text.setText("Your guess is too small, choose a bigger number! This is your " + tries + " guess.");
            } else {
                text.setText("Your guess is too high, choose a smaller number! This is your " + tries + " guess.");
            }
        }
        }

