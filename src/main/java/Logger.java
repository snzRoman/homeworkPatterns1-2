import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    protected int num = 1;

    private static Logger instance = null;

    public void log(String message) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");

        System.out.println("[" + dateFormat.format(date) + " " + num++ + "] " + message);
    }

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }
}
