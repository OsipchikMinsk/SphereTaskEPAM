package by.epam.sphere.exception;

public class NotSphereException extends Exception {

    private static final long serialVersionUID = 1L;
    public NotSphereException(){
        super();
    }
    public NotSphereException(String message){
        super(message);
    }
    public NotSphereException(String message, Exception e){
        super(message,e);
    }
    public NotSphereException(Exception e) {
        super(e);
    }
}
