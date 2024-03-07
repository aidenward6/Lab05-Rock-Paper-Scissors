import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    private JPanel mainPnl, topPnl, middlePnl, bottomPnl;
    private JLabel titleLbl, userWins, compWins, ties;
    private JTextField userWinsText, compWinsText, tiesText;
    private TextArea textArea;
    private JScrollPane scroller;
    private JButton rockBut, paperBut, scissorBut, quitBut;

    private int playerChoice;
    private int userScore;
    private int computerScore;
    private int tiesScore;

    public RockPaperScissorsFrame() {

        // Titles with icon
        ImageIcon icon = new ImageIcon("src/rockpaperscissorsicon.png");
        Image image = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);

        titleLbl = new JLabel("Rock Paper Scissors", resizedIcon, JLabel.CENTER);
        Font titleFont = new Font("Arial", Font.BOLD, 36);
        titleLbl.setFont(titleFont);

        // Stats panel
        Font scoreboardFont = new Font("Arial", Font.BOLD, 20);
        Font scoreTFont = new Font("Aharoni", Font.BOLD, 25);

        userWins = new JLabel("    Your Wins");
        userWins.setFont(scoreboardFont);
        userWinsText = new JTextField();
        userWinsText.setFont(scoreTFont);

        compWins = new JLabel("    Computer's Wins");
        compWins.setFont(scoreboardFont);
        compWinsText = new JTextField();
        compWinsText.setFont(scoreTFont);


        ties = new JLabel("    Ties");
        ties.setFont(scoreboardFont);
        tiesText = new JTextField();
        tiesText.setFont(scoreTFont);


        // Declaring JTextArea and JScrollPane
        textArea = new TextArea(1, 35);
        scroller = new JScrollPane(textArea);
        Font taFont = new Font("Serif", Font.BOLD, 12);
        textArea.setFont(taFont);

        // JButton Icons
        ImageIcon rockIcon1 = new ImageIcon("src/rock.png");
        Image rock = rockIcon1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon rockIcon = new ImageIcon(rock);

        ImageIcon paperIcon1 = new ImageIcon("src/papericon.png");
        Image paper = paperIcon1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon paperIcon = new ImageIcon(paper);

        ImageIcon scissorsIcon1 = new ImageIcon("src/scissorsicon.jpeg");
        Image scissors = scissorsIcon1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scissorsIcon = new ImageIcon(scissors);

        ImageIcon quitIcon1 = new ImageIcon("src/quitIcon.jpg");
        Image quit = quitIcon1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon quitIcon = new ImageIcon(quit);

        // JButtons
        rockBut = new JButton(rockIcon);
        rockBut.addActionListener((ActionEvent ae) -> {
            playerChoice = 1;
            playGame();
        });

        paperBut = new JButton(paperIcon);
        paperBut.addActionListener((ActionEvent ae) -> {
            playerChoice = 2;
            playGame();
        });

        scissorBut = new JButton(scissorsIcon);
        scissorBut.addActionListener((ActionEvent ae) -> {
            playerChoice = 3;
            playGame();
        });

        quitBut = new JButton(quitIcon);
        quitBut.addActionListener((ActionEvent ae) -> System.exit(0));

        // Panels
        mainPnl = new JPanel();
        topPnl = new JPanel();
        middlePnl = new JPanel();
        bottomPnl = new JPanel();

        add(mainPnl);

        mainPnl.setLayout(new BorderLayout());

        mainPnl.add(topPnl, BorderLayout.NORTH);
        topPnl.add(titleLbl);
        topPnl.setLayout(new GridLayout(2, 1));


        mainPnl.add(middlePnl, BorderLayout.CENTER);
        middlePnl.setLayout(new GridLayout(4, 2));
        middlePnl.add(userWins);
        middlePnl.add(userWinsText);
        middlePnl.add(compWins);
        middlePnl.add(compWinsText);
        middlePnl.add(ties);
        middlePnl.add(tiesText);
        middlePnl.add(scroller);


        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        bottomPnl.setLayout(new GridLayout(1, 4));
        bottomPnl.add(rockBut);
        bottomPnl.add(paperBut);
        bottomPnl.add(scissorBut);
        bottomPnl.add(quitBut);




        setSize(1080, 1920);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void playGame() {
        Random rnd = new Random();
        int computerChoice = rnd.nextInt(1, 4);

        if (playerChoice == 1 && computerChoice == 2) {
            textArea.append("You chose Rock. Paper covers Rock. You lose! \n");
            computerScore++;
        } else if (playerChoice == 1 && computerChoice == 1) {
            textArea.append("You both chose rock. Tie! \n");
            tiesScore++;
        } else if (playerChoice == 1 && computerChoice == 3) {
            textArea.append("You chose Rock. Rock smashes Scissors. You win! \n");
            userScore++;
        } else if (playerChoice == 2 && computerChoice == 1) {
            textArea.append("You chose Paper. Paper covers Rock. You Win! \n");
            userScore++;
        } else if (playerChoice == 2 && computerChoice == 3) {
            textArea.append("You chose Paper. Scissors cut Paper. You Lose! \n");
            computerScore++;
        } else if (playerChoice == 2 && computerChoice == 2) {
            textArea.append("You both chose Paper. Tie! \n");
            tiesScore++;
        } else if (playerChoice == 3 && computerChoice == 1) {
            textArea.append("You chose Scissors. Rock smashes Scissors. You lose! \n");
            computerScore++;
        } else if (playerChoice == 3 && computerChoice == 2) {
            textArea.append("You chose Scissors. Scissors cuts Paper. You win! \n");
            userScore++;
        } else if (playerChoice == 3 && computerChoice == 3) {
            textArea.append("You both chose Scissors. Tie! \n");
            tiesScore++;
        }
        userWinsText.setText(String.valueOf(userScore));
        compWinsText.setText(String.valueOf(computerScore));
        tiesText.setText(String.valueOf(tiesScore));

    }

}
