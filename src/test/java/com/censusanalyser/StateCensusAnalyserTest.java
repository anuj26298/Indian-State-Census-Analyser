package com.censusanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {

    @Test
    public void givenCSVFile_WhenCheckedForNumberOfEntries_ReturnTrueIfCorrectNumberOfEntries(){
        String STATE_CENSUS_FILE_PATH = "C:\\Users\\ANUJ\\IdeaProjects\\Indian State Census Analyser" +
                "\\src\\main\\resources\\StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        Assert.assertEquals(29, stateCensusAnalyser.loadStateCensusData(STATE_CENSUS_FILE_PATH));
    }
}
