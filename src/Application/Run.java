package Application;

import Application.Controller.MainController;

import java.io.IOException;

public class Run {
    public static void main(String[] args) {
        MainController controller = new MainController();

        try {
            controller.startApplication();
        } catch (IOException e) {
            // TODO: log to error file.
            e.printStackTrace();
        }

    }
}
