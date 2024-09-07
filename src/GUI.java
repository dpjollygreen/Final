import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class GUI extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Hot Potato");
    LinkedList<String> playersList = new LinkedList<>();
    JLabel playerList = new JLabel();
    JMenuBar menuBar = new JMenuBar();
    int players = 0;
    //Random rand = new Random();
    Guess toguess = new Guess();
    LastGuess lastGuess = new LastGuess();
    OldestGuess oldestGuess = new OldestGuess();
    Boolean firstTurn = true;



    public GUI() {

        frame.setSize(750, 500);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void playerList(String player) {
        String gamePlay = playerList.getText();
        gamePlay += player + " ";

        playerList.setText(gamePlay);
        players++;
        //JLabel playerList = new JLabel(players);
        frame.add(playerList);
        frame.repaint();
    }

    public void addStartButton() {
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < players; i++) {
                    int check = players - 1;
                    int guess = 0;
                    //System.out.println(check);
                    if (i == check) { i = 0;}
                    try {
                        guess = Integer.parseInt(JOptionPane.showInputDialog(playersList.get(i) + " guess a number:"));
                    } catch (NumberFormatException c) {
                    } catch (IndexOutOfBoundsException c) {
                    }
                    if (guess == toguess.getNum()) {
                        System.out.println("You win");
                    } else if (firstTurn) {
                       lastGuess = new LastGuess(guess, guess + "Incorrect");
                       firstTurn = false;
                       System.out.println(lastGuess.getHotncold());

                    } else if (!firstTurn) {
                        int variance = Math.abs(toguess.getNum() - guess);
                        int newvariance = Math.abs(toguess.getNum() - lastGuess.getNum());
                        //Math.abs()
                        if (variance < newvariance) {
                            lastGuess = new LastGuess(guess, guess + "Hot");
                            System.out.println(lastGuess.getHotncold());
                        }
                        else if (variance > newvariance) {
                            lastGuess = new LastGuess(guess, guess + "Cold");
                            oldestGuess = new OldestGuess(lastGuess);
                            System.out.println(lastGuess.getHotncold());
                            System.out.println(oldestGuess.getHotncold());
                        } else if (variance == newvariance) {
                            lastGuess = new LastGuess(guess, guess + "Leukwarm");
                            oldestGuess = new OldestGuess(lastGuess);
                            System.out.println(lastGuess.getHotncold());
                            System.out.println(oldestGuess.getHotncold());

                        }
                    }

                }//end for loop
            }
        });
        frame.add(startButton);
        frame.repaint();

    }

    public void addMenu() {

        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);
        JMenuItem newGameMenuItem = new JMenuItem("Add Player");

        gameMenu.add(newGameMenuItem);
        menuBar.add(gameMenu);
        frame.setJMenuBar(menuBar);

        newGameMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                players += 1;
                String name = JOptionPane.showInputDialog("Enter your Name:");
                playerList(name);
                playersList.add(name);
                //currentPlayers[players] = new Players(name);

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
