package Application.Controller;

import Application.FileIO.Writer;
import Application.Menu.MainMenu;
import Application.Settings.Configs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class MainController {


    public void startApplication() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MainMenu mainMenu = new MainMenu(false, false);


        String userInput = "   ";
        while (!isInputCorrect(userInput, 2) && !userInput.isEmpty()) {
            mainMenu.printMenu();
            userInput = reader.readLine();
        }

        switch (userInput) {
            case "1":
                autoConfigure();
                break;
            case "2":
                logToOffServer();
                break;
            default:
                logToMainServer();
                break;

        }

    }

    private void logToMainServer() {

    }

    private void logToOffServer() {

    }

    private void autoConfigure() {
        Writer writer = new Writer();
        writer.writeDefaultConfigFile(Configs.configFileLocation);
    }

    private boolean isInputCorrect(String input, int countOfOptions) {
        List<String> correctInputs = new LinkedList<>();

        for (int i = 1; i <= countOfOptions; i++) {
            correctInputs.add(String.valueOf(i));
        }

        return correctInputs.contains(input);
    }
}
