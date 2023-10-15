package com.digitalsouag.portfolio.common;

import lombok.Data;

import java.util.List;

@Data
public class DataResponse<T> {
    private List<T> data;
    private int totalData;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }
}
