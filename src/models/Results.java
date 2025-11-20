package models;

public class Results {
    

    private int simpleSize;
    private String funtionName;
    private double timeResult;
    public Results(int simpleSize, String funtionName, double timeResult) {
        this.simpleSize = simpleSize;
        this.funtionName = funtionName;
        this.timeResult = timeResult;
    }
    public int getSimpleSize() {
        return simpleSize;
    }
    public void setSimpleSize(int simpleSize) {
        this.simpleSize = simpleSize;
    }
    public String getFuntionName() {
        return funtionName;
    }
    public void setFuntionName(String funtionName) {
        this.funtionName = funtionName;
    }
    public double getTimeResult() {
        return timeResult;
    }
    public void setTimeResult(int timeResult) {
        this.timeResult = timeResult;
    }
    @Override
    public String toString() {
        return "La funcion: " + funtionName + " ejecutada " + simpleSize + " veces, tuvo una duracion de " + timeResult + " segundos";
    }

    
}
