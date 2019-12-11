package exchange_task2.exeption;

public class DaoException extends Exception {
    public DaoException(){
        super();
    }
    public DaoException(String message){
        super(message);
    }
    public DaoException(String message, Exception e){
        super(message,e);
    }
    public DaoException(Exception e) {
        super(e);
    }
}
