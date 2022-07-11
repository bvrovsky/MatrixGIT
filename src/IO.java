import java.io.*;

public class IO {
    //методы класса - статические (их можно использовать
    //без создания объектов этого класса)
    public static float[][] inpMatr(String fileName) throws IOException{
        //ввод матрицы из текстового файла с именем fileName
        float[][] matr;//матрица-приемник
        String line;//строка, считанная из файла
        int i = 0;//номер строки матрицы
        String[] numbers;//ссылка на массив слов, найденных в строке
        int n;//число строк матрицы
        int m;//число столбцов матрицы
        BufferedReader inp = null;//ссылка на входной поток

