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

    public static void main(String[] args) throws IOException {
        String fileName;//имя файла
        String line = "";//приемник строки
        String flag = "";//для выхода из цикла ввода с терминала
        float[][] matr;//ссылка на матрицу-приемник
        //определим поток для терминального ввода
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        do{
            System.out.println("Enter the name of the matrix");
            fileName = (br.readLine()).trim();//после ввода имени файла в
            //окно терминала читаем его и обрезаем пробелы в начале и в конце
            matr = IO.inpMatr(fileName);//ввод матрицы из файла
            if (matr != null){
                System.out.println("Matrix entered successfully");
                //создаем объект класса Интеллектуальная матрица на базе введенной матрицы
                IntellectMatr imatr = new IntellectMatr(matr);
                //выводим исходную матрицу в окно терминала
                System.out.println("Matrix introduced:");
                imatr.putMatr();
                //обрабатываем матрицу методами класса
                //Интеллектуальная матрица и выводим промежуточные
                //результаты обработки в окно терминала
                System.out.println("Number of negative elements in matrix rows:");
                putArr(imatr.negativeCntVector());
                System.out.println("Sum of the elements of the main diagonal:");
                System.out.println(imatr.sumDiagonal());
                IntellectMatr imatr2 = new IntellectMatr(matr);
                System.out.println("Determinant of matrix is:");
                IntellectMatr imatr3 = new IntellectMatr(matr);
                returnValue(imatr3.getValue());
                System.out.println("Transposed matrix :");
                IntellectMatr imatr4 = new IntellectMatr(matr);
                putMatr(imatr4.TranspMatr());
            }
            System.out.println("Continue?: Yes - <Enter>, No - <n>");
            flag = br.readLine().trim();
        } while (!flag.equals("n"));//пока с терминала не введен символ n
    }
    //ввод с терминала буферизированный, т.е. происходит при нажатии Enter
}
