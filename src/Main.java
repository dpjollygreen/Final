import javax.swing.*;
import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            GUI gui = new GUI();
        String playerList = "Players: ";
           gui.addMenu();
           gui.addStartButton();
           gui.playerList(playerList);

    }
}