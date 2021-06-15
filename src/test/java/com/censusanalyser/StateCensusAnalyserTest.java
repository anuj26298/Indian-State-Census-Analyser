package com.censusanalyser;

import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {

    @Test
    public void givenCSVFile_WhenCheckedForNumberOfEntries_ReturnTrueIfCorrectNumberOfEntries() throws StateCensusAnalyserExceptions {
        String STATE_CENSUS_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            Assert.assertEquals(29, stateCensusAnalyser.loadStateCensusData(STATE_CENSUS_FILE_PATH));
    }
        @Test
    public void givenPathName_WhenWrongFileGiven_ReturnWrongFileException() {
        String STATE_CENSUS_WRONG_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCensusData";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

        try {
            int numberOfEntries = stateCensusAnalyser.loadStateCensusData(STATE_CENSUS_WRONG_FILE_PATH);
        } catch (StateCensusAnalyserExceptions e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateCensusAnalyserExceptions.ExceptionType.WRONG_FILE, e.exceptionType);
        }
    }
    @Test
    public void givenFilePath_WhenWrongExtension_ReturnInvalidExtensionException() {
        String STATE_CENSUS_WRONG_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCensusData.xlsx";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            int numberOfEntries = stateCensusAnalyser.loadStateCensusData(STATE_CENSUS_WRONG_FILE_PATH);
        }catch (StateCensusAnalyserExceptions e){
            System.out.println(e.getMessage());
            Assert.assertEquals(StateCensusAnalyserExceptions.ExceptionType.INVALID_FILE_EXTENSION, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenContainWrongDelimited_ReturnWrongDelimiterException() {
        String STATE_CENSUS_WRONG_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            int numberOfEntries = stateCensusAnalyser.loadStateCensusData(STATE_CENSUS_WRONG_FILE_PATH);
        }catch (StateCensusAnalyserExceptions e){
            System.out.println(e.getMessage());
            Assert.assertEquals(StateCensusAnalyserExceptions.ExceptionType.CSV_FILE_PROBLEM, e.exceptionType);
        }
    }


    @Test
    public void givenFile_WhenContainWrongHeader_ReturnWrongHeaderException() {
        String STATE_CENSUS_WRONG_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            int numberOfEntries = stateCensusAnalyser.loadStateCensusData(STATE_CENSUS_WRONG_FILE_PATH);
        }catch (StateCensusAnalyserExceptions e){
            System.out.println(e.getMessage());
            Assert.assertEquals(StateCensusAnalyserExceptions.ExceptionType.CSV_FILE_PROBLEM, e.exceptionType);
        }
    }
}
