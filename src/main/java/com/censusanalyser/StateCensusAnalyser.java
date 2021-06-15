package com.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
/*
    loadStateCensusData() method load the given csvFile
    located at csvFilePath and count the number of
    entries in the csv file.
 */
    public int loadStateCensusData(String csvFilePath) throws StateCensusAnalyserExceptions{
        int numberOfEntries = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStateCensus> csvStateCensusIterator = csvToBean.iterator();
            while (csvStateCensusIterator.hasNext()){
                numberOfEntries++;
                csvStateCensusIterator.next();
            }
        }catch (IOException e) {
            throw new StateCensusAnalyserExceptions(StateCensusAnalyserExceptions.ExceptionType.WRONG_FILE);
        }
        return numberOfEntries;
    }
}
