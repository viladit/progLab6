package utils;

/**
 * Вспомогательный класс с методами для вывода в терминал
 */
public class IOHandler {
    public static void println(Object o){
        System.out.println(o);
    }
    public static void print(Object o){
        System.out.print(o);
    }

    public static void serverError(Object o) {
        System.out.println(o);
    }
}
