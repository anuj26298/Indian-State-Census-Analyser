package com.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCodeAnalyser {
    /*
    loadStateCodeData() method load the given csvFile
    located at csvFilePath contains state code and TIN and count the number of
    entries in the csv file.
 */

    public int loadStateCodeData(String csvFilePath) throws StateCensusAnalyserExceptions {
        int numberOfEntries = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBean<CSVStateCode> csvToBean = new CsvToBeanBuilder<CSVStateCode>(reader)
                    .withType(CSVStateCode.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStateCode> csvStateCodeIterator = csvToBean.iterator();
            while (csvStateCodeIterator.hasNext()){
                numberOfEntries++;
                csvStateCodeIterator.next();
            }
        }catch (IOException e) {
            if (!(csvFilePath.contains(".csv")))
                throw new StateCensusAnalyserExceptions(StateCensusAnalyserExceptions.ExceptionType.INVALID_FILE_EXTENSION);
            throw new StateCensusAnalyserExceptions(StateCensusAnalyserExceptions.ExceptionType.WRONG_FILE);
        }catch (RuntimeException e){
            throw new StateCensusAnalyserExceptions(StateCensusAnalyserExceptions.ExceptionType.CSV_FILE_PROBLEM);
        }
        return numberOfEntries;
    }
}
