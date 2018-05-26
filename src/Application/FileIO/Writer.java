package Application.FileIO;

import Application.FileIO.api.WriterIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer implements WriterIO {
    private static final String NEW_LINE = System.lineSeparator();

    @Override
    public void write(String fileLocation, String content) {
        File file = new File(fileLocation);
        if (!file.exists()) {
            //TODO: log into errors_log.txt file
            System.out.println(file + " does not exist.");
            return;
        }

        System.out.println();

    }

    public void writeDefaultConfigFile(String fileLocation) {
        File file = new File(fileLocation);

        if (!file.exists()) {
            try (FileWriter fos = new FileWriter(fileLocation);
                 BufferedWriter writer = new BufferedWriter(fos)) {
                file.mkdirs();
                file.createNewFile();
                writer.write(defaultAutoConfigFileContent());
                System.out.println("Successfully wrote file content!");
            } catch (IOException e) {
                // TODO: log to errors_log.
                System.out.println("IOException thrown");
                e.printStackTrace();
            }

        }

    }

    private String defaultAutoConfigFileContent() {
        StringBuilder sb = new StringBuilder();

        sb.append("// Do not edit anything before you read the READ_ME file.").append(NEW_LINE).append(NEW_LINE)
                .append("-- AUTO GENERATED CONFIG FILE --").append(NEW_LINE)
                .append("#Menu").append(NEW_LINE)
                .append("disableMenu: false").append(NEW_LINE)
                .append("printLogo: true").append(NEW_LINE)
                .append("printHeader: true").append(NEW_LINE).append(NEW_LINE)
                .append("#WoW").append(NEW_LINE)
                .append("auto-start-up: true").append(NEW_LINE)
                .append("main-logIn-server: Gamer-District").append(NEW_LINE)
                .append("off-server: Warmane").append(NEW_LINE).append(NEW_LINE)
                .append("#error-logs").append(NEW_LINE)
                .append("show-errors-in-console: false").append(NEW_LINE)
                .append("make-errors-file: true").append(NEW_LINE)
                .append("errors-file-name: errors-log.txt").append(NEW_LINE).append(NEW_LINE)
                .append("-- END OF AUTO GENERATED CONFIG FILE --");

        return sb.toString();
    }

}
