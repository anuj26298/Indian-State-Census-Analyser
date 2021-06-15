package com.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
    @CsvBindByName(column = "State", required = true)
    String state;

    @CsvBindByName(column = "Population", required = true)
    String population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    String areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    String densityPerSqKm;

    @Override
    public String toString() {
        return "CSVStateCensus{" +
                "state='" + state + '\'' +
                ", population='" + population + '\'' +
                ", areaInSqKm='" + areaInSqKm + '\'' +
                ", densityPerSqKm='" + densityPerSqKm + '\'' +
                '}';
    }
}
