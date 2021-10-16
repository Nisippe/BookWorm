package Exception;

import javax.servlet.ServletException;

//creo questa classe perchè dato che i metodi doGet e doPost già fanno il throw di ServletException, per non aggiungere altri
//valori nel throw, aggiungo i miei errori estendendo la classe ServletException, in modo che sia già gestita dai metodi esistenti
// senza dover aggiungere nulla;
//i costruttori che richiamo non fanno che altro che chiamare il costruttore della classe padre;


public class MyServletException extends ServletException {
    public MyServletException() {
    }

    public MyServletException(String message) {
        super(message);
    }

    public MyServletException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public MyServletException(Throwable rootCause) {
        super(rootCause);
    }
}
