package com.aries.crudwithretrofit.modul;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ReadDataResponse {

    @SerializedName("records")
    @Expose
    private List<Record> records = null;

    public ReadDataResponse(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

}

