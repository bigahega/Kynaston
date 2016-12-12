package Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by berkinguler on 20/11/2016.
 */
public class Utilities {

    public static ArrayList<String> readLinesToArrayList(String file) {
        ArrayList<String> list = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(file))) {
            stream.forEach(list::add);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
        if(c != null && string != null) {
            try {
                return Enum.valueOf(c, string.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}
