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
        try{//1 - контролируем исключения ввода-вывода
            //Открываем поток ввода
            //Могут возникнуть исключения FileNotFoundException, IOException
            inp = new BufferedReader(new FileReader(fileName));
            //Далее - считываем мтрицу - вводим строки из файла
            //Привводе может возникнуть исключение IOException
            //Пропускаем в начале файла пустые строки или строки с одними пробелами
            while ((line = inp.readLine()) != null) if (!line.trim().equals("")) break;
            //Сначала нужно ввести число строк и число столбцов
            try{//2 - контролируем соответствие файла спецификации
                //и исключения, возникающие при преобразовании из String в число
                if (line == null)//если считан конец файла
                    //генерируем искючение MyException
                    throw new MyException(String.format("File %s is empty ", fileName));
                numbers = line.trim().split("\\s+");//разбор строки на отдельные слова
                if (numbers.length < 2)//не задано число столбцов матрицы
                    //генерируем исключение MyException
                    throw new MyException(String.format(
                            "The number of matrix  columns isn't specified in the file %s ", fileName));
                //может возникнуть исключение NumberFormatException
                n = Integer.parseInt(numbers[0]); m = Integer.parseInt(numbers[1]);
                if ((n <= 0) || (m <= 0))//неправильно задано число строки или столбцов
                    //генерируем исключение MyException
                    throw new MyException(String.format(
                            "The number of rows or columns in the file %s is not set correctly",
                            fileName));
                matr = new float[n][m];//создаем матрицу-приемник
                //считываем строки матрицы из файла
                //при вводе может возникнуть исключение IOException
                while ((line = inp.readLine()) != null){//ввод очередной строки
                    //если строка пустая или состоит из одних пробелов
                    //пропускаем её
                    line = line.trim();
                    if (line.equals("")) continue;
                    //разбор строки на отдельные слова(числа)
                    numbers = line.split("\\s+");
                    if (numbers.length < m)//в строке меньше m чисел,
                        //а должно быть m(или больше) чисел (лишние игнорируются)
                        //генирируем исключение IOException
                        throw new MyException(String.format(
                                "Not enough numbers in the row %d from the file %s ", i, fileName));
                    //далее может возникнуть исключение NumberFormatException
                    for (int j = 0; j < m; j++) matr[i][j] = Float.parseFloat(numbers[j]);
                    i++;//увеличиваем номер введенной строки
                    if (i == n) break;//введено указанное в файле число строк
                    //если в файле еще есть строки - они игнорируются
                }//while
                if (i < n)//введено меньше строк, чем заявлено в первой непустой строке файла
                    //генерируем исключение MyException
                    throw new MyException(String.format(
                            "Missing lines in file %s ", fileName));
            }//try 2
            //здесь порядок следования обработчиков catch роли не играет
            catch (MyException e){
                //обработчик исключения для try 2 (неправильная структура файла)
                System.out.println(e); return null;}
            catch (NumberFormatException e){
                //обработчик исключения для try 2 (ошибка преобразования данных)
                System.out.printf("In line %d of matrix from file %s", i, fileName);
                System.out.println(
                        " Invalid character sequence found");
                return null;}
        }//try 1
        //порядок следования блоков catch для try 1 определяется тем, что
        //класс FileNotFoundException является подклассом IOException
        catch (FileNotFoundException e){
            //файл не найден - обработчик для try 1
            System.out.printf("File %s not found\n", fileName);
            return null;}
        catch (IOException e){
            //ошибка ввода данных - обработчик для try 1
            System.out.printf("Error when entering data from a file %s\n",
                    fileName);
            return null;}
        finally{ if (inp != null) inp.close();//закрываем поток
            //При закрытии может возникнуть исключение IOException,
            //которое в этой части программы не перехватывается и не
            //обрабатывается, поэтому в заголовке метода inpMatr
            //должно присутствовать предложение throws IOException
        }//finally
        return matr;
    }
}//class IO
