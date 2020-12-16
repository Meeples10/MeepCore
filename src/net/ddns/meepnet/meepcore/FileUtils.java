package net.ddns.meepnet.meepcore;

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

public class FileUtils {
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
            if(out != null) try {
                out.close();
            } catch(IOException ignore) {}
        }
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