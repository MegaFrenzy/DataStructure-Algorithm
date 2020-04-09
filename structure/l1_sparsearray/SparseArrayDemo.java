package l1_sparsearray;

import java.io.File;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 13:52
 */
public class SparseArrayDemo {
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        ArrayUtils.printArr(chessArr);

        SparseArray arr = new SparseArray(chessArr);
        int[][] midArr = arr.getSparseArray();
        ArrayUtils.printArr(midArr);

        int[][] NormalArr = arr.getNormalArray();
        ArrayUtils.printArr(NormalArr);

        File savedFile = SaveUtils.saveArray(arr);

        SparseArray savArray = SaveUtils.readArray();
        ArrayUtils.printArr(savArray.getSparseArray());

    }

}
