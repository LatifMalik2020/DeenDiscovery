package com.provisionTechAdvisors.DeenDiscovery.DTO;

import java.util.List;

public class SurahApiResponse {
    private int code;
    private String status;
    private List<SurahDTO> data;

    // Getters and setters

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SurahDTO> getData() {
        return data;
    }

    public void setData(List<SurahDTO> data) {
        this.data = data;
    }
}
