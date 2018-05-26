package Application.RealmlistFinder;

import Application.Settings.Configs;

import java.io.File;
import java.util.ArrayDeque;

public class RealmlistFinder {

    public boolean search(String localDisc) {
        File root = new File(localDisc);
        if (!root.exists()) {
            return false;
        }

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            File currFile = queue.poll();
            File[] nestedFiles = currFile.listFiles();
            if (!(nestedFiles == null)) {
                if (containsRealmlist(nestedFiles)) {
                    Configs.pathToRealmlist = getRealmlistPath(nestedFiles);
                    return true;
                } else {
                    addNestedDirectories(nestedFiles, queue);
                }
            }
        }

        return false;
    }

    private void addNestedDirectories(File[] nestedFiles, ArrayDeque<File> queue) {
        for (File nestedFile : nestedFiles) {
            if (nestedFile == null) {
                continue;
            }

            if (nestedFile.isDirectory()) {
                queue.add(nestedFile);
            }
        }
    }

    private boolean containsRealmlist(File[] files) {
        if (files.length == 0) {
            return false;
        }

        for (File file : files) {
            if (file == null) {
                continue;
            }

            if (file.getName().equals(Configs.RealmlistFileName)) {
                return true;
            }

        }

        return false;
    }

    private String getRealmlistPath(File[] files) {
        for (File file : files) {
            if (file.getName().equals(Configs.RealmlistFileName)) {
                return file.getAbsolutePath();
            }
        }

        return null;
    }
}
