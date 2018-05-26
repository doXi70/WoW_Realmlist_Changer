package Application.FileIO;

import java.io.*;

public class ReaderIO implements Application.FileIO.api.ReaderIO {

    @Override
    public void read(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            // TODO: log into errors_log.txt
            System.out.println(file + " does not exists!");
        }

        try (FileReader fr = new FileReader(file);
             BufferedReader reader = new BufferedReader(fr)) {

            String line = reader.readLine();
            while (!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
            }


        } catch (FileNotFoundException e) {
            // TODO: Log to errors_log.txt
            System.out.println("File not found!");
        } catch (IOException e) {
            // TODO: Log to errors_log.txt
            System.out.println("Insufficient permissions!");
        }
    }
}
