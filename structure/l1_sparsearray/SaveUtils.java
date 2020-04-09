package l1_sparsearray;

import java.io.*;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 13:25
 */
public class SaveUtils {
    private static String filename = "map.data";

    public static File saveArray(SparseArray arr) {
        String path = SaveUtils.class.getResource("").getFile();
        File file = new File(path, filename);
        ObjectOutputStream oos = null;
        try {
            if (!file.exists()) {
                boolean b = file.createNewFile();
            }
            System.out.println("file path = " + file.getAbsolutePath());
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(arr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return file;


    }

    public static SparseArray readArray() {
        String path = SaveUtils.class.getResource("").getFile();
        File file = new File(path, filename);
        System.out.println("load path->" + file.getAbsolutePath());
        if (!file.exists()) {
            throw new RuntimeException("file doesn't exist");
        }
        ObjectInputStream ois = null;
        SparseArray sa = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            sa = (SparseArray) ois.readObject();
            System.out.println("loading...");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sa;
    }


}
