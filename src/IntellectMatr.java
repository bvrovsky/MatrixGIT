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

    //транспонирование матрицы
    public float[][] TranspMatr() {
        for (int i = 0; i < matr.length; i++) {
            for (int j = i + 1; j < matr.length; j++) {
                float temp = (float) matr[i][j];
                matr[i][j] = matr[j][i];
                matr[j][i] = temp;
            }
        }
        return matr;
    }

    public float getValue() {
        getReduction(matr);
        return this.summ;

    }//getValue
    //Выисление значения определителя матрицы
    private void getReduction(float [][] subMinor) {
        if (subMinor.length > 1){
            float [][] tmpMinor = new float[subMinor.length - 1][subMinor[0].length - 1];//создаем массив
            for (int c = 0; c < subMinor[0].length; c++) {
                for (int i = 1; i < subMinor.length; i++) {
                    for (int j = 0; j < subMinor[0].length; j++) {
                        if (j < c)
                            tmpMinor[i - 1][j] = subMinor[i][j];
                        else if (j > c)
                            tmpMinor[i - 1][j - 1] = subMinor[i][j];
                    }
                }
                float paramForSub = (float) Math.pow(-1,c+2)*subMinor[0][c]*1;
                getReduction(tmpMinor);
            }
        }
        else
            this.summ += 1 * subMinor[0][0];
    }//getReduction
    public int[] negativeCntVector(){
        //возращает вектор, i-ый элемент которого равен количеству отрицательных
        //элементов в i-ой строке матрицы (без параметров)
        int X[] = new int[matr.length];//создаем массив Х
        //состоящий из matr.length элементов типа float
        for (int i = 0; i<matr.length; i++){
            X[i] = 0;//начальное значение счетчика отрицательных элементов
            for (int j=0; j<matr[0].length; j++)
                if (matr[i][j] < 0) X[i]++;//инкрементируем счетчик
        }//for i
        return X;//возвращаем ссылку на массив X
    }// negativeCntVector
}
