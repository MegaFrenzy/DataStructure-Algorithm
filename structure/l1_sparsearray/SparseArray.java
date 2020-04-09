package l1_sparsearray;


import java.io.Serializable;


/**
 * @Description: 稀疏数组代码实现
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 09:26
 */
public class SparseArray implements Serializable {

    public static final long serialVersionUID =945498786L;
    private int[][] sparseArray;

    public int[][] getSparseArray() {
        return sparseArray;
    }

    public int[][] getNormalArray() {
        if (sparseArray != null) {
            return convert2OrigArray(sparseArray);
        }
        return null;
    }

    public SparseArray(int[][] origArray) {
        this.sparseArray = convert2SparseArray(origArray);
    }

    public static int[][] convert2SparseArray(int[][] arrIn) {
        int cnt = 0;
        int row = arrIn.length;
        int col = arrIn[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arrIn[i][j] != 0) {
                    cnt++;
                }
            }
        }
        int[][] sparseArr = new int[cnt + 1][3];
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = cnt;
        int nmb = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arrIn[i][j] != 0) {
                    sparseArr[nmb][0] = i;
                    sparseArr[nmb][1] = j;
                    sparseArr[nmb][2] = arrIn[i][j];
                    nmb++;
                }
            }
        }
        return sparseArr;
    }


    public static int[][] convert2OrigArray(int[][] arrIn) {

        int oriArr[][] = new int[arrIn[0][0]][arrIn[0][1]];
        for (int i = 1; i < arrIn.length; i++) {
            oriArr[arrIn[i][0]][arrIn[i][1]] = arrIn[i][2];
        }
        return oriArr;

    }


}
