import java.util.*;

import CustomException.WrongLoginException;
import CustomException.WrongPasswordException;


public class Task {
    private final static String SYMBOLS = "(\\w+\\d+)|(\\d+\\w+)";

    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
       input();

    }
    public static void input() throws WrongLoginException, WrongPasswordException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.next();
        

        logCheck(login);

        System.out.println("Введите пароль");
        String password = scanner.next();
        scanner.close();

        passCheck(password);

        System.out.println("Подтвердите пароль");
        String confpass = scanner.next();

        confPassCheck(password, confpass);

        System.out.println("Регистрация прошла успешно!)");
    }
    public static void logCheck(String login)  throws WrongLoginException{
       
        if (login.length() > 21){
            throw new WrongLoginException("Длина логина должна быть меньше 20 символов!");

        }
        if (!login.matches(SYMBOLS)){
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания!");
        }
    }

    public static void passCheck(String password) throws WrongPasswordException {
        if(password.length() > 21){
            throw new WrongPasswordException("Длина пароля должна быть меньше 20 символов!");
        }
        
        if(!password.matches(SYMBOLS)) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания!");
        }
    }

    public static void confPassCheck(String password, String confpass) throws WrongPasswordException {
        if(!password.equals(confpass)){
            throw new WrongPasswordException(confpass);

        }
        
    }
   
    
}  