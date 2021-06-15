package com.censusanalyser;

public class StateCensusAnalyserExceptions extends Exception {
    public ExceptionType exceptionType;

    public enum ExceptionType{
        WRONG_FILE("Wrong file path");

        public String message;
        ExceptionType(String message){
            this.message = message;
        }
    }

    public StateCensusAnalyserExceptions(ExceptionType exceptionType) {
        super(exceptionType.message);
        this.exceptionType = exceptionType;
    }
}
