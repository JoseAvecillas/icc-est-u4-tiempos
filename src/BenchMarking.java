
import java.util.concurrent.Callable;

import models.Results;

public class BenchMarking {
    public static Results medir_tiempo(Callable func, int simpleSize, String funcionName){
        try {
            long inicio = System.nanoTime();
            func.call();
            long fin = System.nanoTime();
            Results result =new Results(simpleSize,
                                        funcionName,
                                        (fin - inicio) / 1_000_000_000.0);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error midiendo tiempo", e);
        }
    }
}
