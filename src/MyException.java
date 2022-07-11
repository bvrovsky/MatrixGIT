public class MyException extends Exception{
    private String msg;//переменная экземпляра; сообщение об оишбке
    public MyException(String s){//конструктор
        msg = s;
    }
    //переопределим метод предка toString(),
    //возвращающий строку описания объекта-исключения
    public String toString(){
        return msg;
    }
}