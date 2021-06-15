package com.censusanalyser;

import org.junit.Assert;
import org.junit.Test;

public class StateCodeAnalyserTest {
    @Test
    public void givenCSVFile_WhenCheckedForNumberOfEntries_ReturnTrueIfCorrect() throws StateCensusAnalyserExceptions {
        String STATE_CODE_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCode.csv";
        StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
        int numberOfEntries = stateCodeAnalyser.loadStateCodeData(STATE_CODE_FILE_PATH);
        Assert.assertEquals(37, numberOfEntries);
    }
    @Test
    public void givenPath_WhenWrongFileGiven_ReturnWrongFileException(){
        String STATE_CODE_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCode1.csv";
        StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
        try {
            int numberOfEntries = stateCodeAnalyser.loadStateCodeData(STATE_CODE_FILE_PATH);
        }catch (StateCensusAnalyserExceptions e){
            System.out.println(e.getMessage());
            Assert.assertEquals(StateCensusAnalyserExceptions.ExceptionType.WRONG_FILE, e.exceptionType);
        }

    }

    @Test
    public void givenFilePath_WhenWrongExtension_ReturnInvalidFileException(){
        String STATE_CODE_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCode.xlsx";
        StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
        try {
            int numberOfEntries = stateCodeAnalyser.loadStateCodeData(STATE_CODE_FILE_PATH);
        }catch (StateCensusAnalyserExceptions e){
            System.out.println(e.getMessage());
            Assert.assertEquals(StateCensusAnalyserExceptions.ExceptionType.INVALID_FILE_EXTENSION, e.exceptionType);
        }

    }

    @Test
    public void givenCSVFile_WhenWrongDelimeter_ReturnInternalFileException(){
        String STATE_CODE_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCode.csv";
        StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
        try {
            int numberOfEntries = stateCodeAnalyser.loadStateCodeData(STATE_CODE_FILE_PATH);
        }catch (StateCensusAnalyserExceptions e){
            System.out.println(e.getMessage());
            Assert.assertEquals(StateCensusAnalyserExceptions.ExceptionType.CSV_FILE_PROBLEM, e.exceptionType);
        }

    }

    @Test
    public void givenPath_WhenWrongHeader_ReturnInternalFileException(){
        String STATE_CODE_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCode.csv";
        StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
        try {
            int numberOfEntries = stateCodeAnalyser.loadStateCodeData(STATE_CODE_FILE_PATH);
        }catch (StateCensusAnalyserExceptions e){
            System.out.println(e.getMessage());
            Assert.assertEquals(StateCensusAnalyserExceptions.ExceptionType.CSV_FILE_PROBLEM, e.exceptionType);
        }

    }
}
