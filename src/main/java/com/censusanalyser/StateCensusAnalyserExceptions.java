package com.censusanalyser;

public class StateCensusAnalyserExceptions extends Exception {
    public ExceptionType exceptionType;

    public enum ExceptionType{
        WRONG_FILE("Wrong file path"),
        INVALID_FILE_EXTENSION("Invalid file extension: Please provide file with .csv extension");

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
