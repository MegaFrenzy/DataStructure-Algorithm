package l1_sparsearray;

import org.junit.Test;

/**
 * @Description: 打印
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 11:26
 */
public class ArrayUtils {
    public static void printArr(int[][] arrIn) {
        for (int[] row : arrIn) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();

        }
        System.out.println("-------------");
    }
/*
    public static String save (int[][] arrIn) throws IOException {
        File file = new File("sav/record.txt");
        String path=file.getAbsolutePath();

        FileWriter fw = null;

            fw = new FileWriter(file);
            for(int i=0;i<arrIn.length;i++){
                for (int j = 0; j < arrIn[0].length; j++) {
                    fw.write(arrIn[i][j]+"\t");
                }
                fw.write("\n");
            }
            fw.close();


        return path;
    }
*/
    @Test
    public void testSave(){

        String path =ArrayUtils.class.getResource("").getFile();
        System.out.println(path);
    }



}
