package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.oracle.tools.packager.IOUtils.copyFile;

public class FilesUtils {

    public static void copy(File file, String pathTo) {
        try {
            copyFile(file, new File(pathTo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String path) {
        String text = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            text = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }
}