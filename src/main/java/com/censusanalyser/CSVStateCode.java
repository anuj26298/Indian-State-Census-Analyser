package com.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCode {
    @CsvBindByName(column = "SrNo", required = true)
    int srNo;

    @CsvBindByName(column = "StateName", required = true)
    String stateName;

    @CsvBindByName(column = "TIN", required = true)
    String tin;

    @CsvBindByName(column = "StateCode", required = true)
    String stateCode;

    @Override
    public String toString() {
        return "CSVStateCode{" +
                "srNo=" + srNo +
                ", stateName='" + stateName + '\'' +
                ", tin='" + tin + '\'' +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
