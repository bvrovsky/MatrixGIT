public class IntellectMatr {
    //переменная экземпляра
    private float[][] matr;//ссылка на прямоугольную матрицу
    public float summ;
    //конструктор
    public IntellectMatr(float[][] matr){
        this.matr = matr;
    }
    //геттер
    public float[][] getMatr(){return matr;}
    public void putMatr(){//вывод матрицы в окно терминала
        if ((matr == null) || (matr[0] == null)) return;//матрица пуста
        for (int i = 0; i < matr.length; i++){
            for (int j = 0; j < matr[0].length; j++)
                System.out.printf("% 7.2f", matr[i][j]);
            System.out.println();
        }//for i
    }//putMatr
    //вернуть сумму элементов главной диагонали матрицы
    public float sumDiagonal(){
        if ((matr == null) || (matr[0] == null)) return -1;//если матрица пуста
        int number = 0;
        float sum = 0;
        for (int i = 0; i<matr.length; i++) {
            sum += matr[i][i];
        }
        return sum;
    }//sumDiagonal
}
