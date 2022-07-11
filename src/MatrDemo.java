import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrDemo {
    public static void returnValue (float m) {
        System.out.println(m);
    }

    public static void putArr(int[] X) //статический метод вывода вектора в терминал
    {
        for (int i = 0; i < X.length; i++)
            System.out.printf("%d ", X[i]);
        System.out.println();
    }

    public static void putMatr(float[][] Y) {//вывод матрицы в окно терминала
        for (int i = 0; i < Y.length; i++) {
            for (int j = 0; j < Y[0].length; j++)
                System.out.printf("% 7.2f", Y[i][j]);
            System.out.println();
        }
    }
}
