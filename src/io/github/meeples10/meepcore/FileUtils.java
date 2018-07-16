package io.github.meeples10.meepcore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;

public class FileUtils {
    /**
     * @param directory
     *            The directory the file is in
     * @param name
     *            The name of the file, including the extension
     * @return The lines of the file, joined by '\n'
     * @deprecated Since 1.1.4, see {@link #read(File)}
     */
    @Deprecated
    public static String loadFile(File directory, String name) throws FileNotFoundException, IOException {
        File f = new File(directory, name);
        return ChatColor.translateAlternateColorCodes('&', String.join("\n", FileUtils.readLines(f)));
    }

    /**
     * @deprecated Since 1.2.3
     * @param file
     *            The output file
     * @param data
     *            The string to write to the file
     * @see #write(File, String)
     */
    public static void writeFile(File file, String data) throws IOException {
        write(file, data);
    }

    /**
     * @param file
     *            The output file
     * @param data
     *            The string to write to the file
     */
    public static void write(File file, String data) throws IOException {
        FileWriter out = null;
        try {
            out = new FileWriter(file);
            out.write(data);
        } catch(IOException e) {
            throw new IOException(e);
        } finally {
            if(out != null)
                try {
                    out.close();
                } catch(IOException ignore) {}
        }
    }

    /**
     * @param file
     *            The input file
     * @return The lines of the file
     * @deprecated Since 1.1.4, replaced by {@link #read(File)}
     */
    @Deprecated
    public static String[] readLines(File file) throws FileNotFoundException, IOException {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while((line = in.readLine()) != null) {
            data.add(line);
        }
        in.close();
        String[] output = data.toArray(new String[data.size()]);

        return output;
    }

    /**
     * @param file
     *            The input file
     * @return The lines of the file
     */
    public static ArrayList<String> read(File file) throws FileNotFoundException, IOException {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while((line = in.readLine()) != null) {
            data.add(line);
        }
        in.close();
        return data;
    }

    /**
     * @param path
     *            The path to the file
     * @param obj
     *            The object to write to the file
     */
    public static void writeBinaryFile(String path, Object obj) throws FileNotFoundException, IOException {
        FileOutputStream out = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(obj);
        oos.close();
    }

    /**
     * @param path
     *            The path to the file
     * @return The object stored in the file
     */
    public static Object readBinaryFile(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}