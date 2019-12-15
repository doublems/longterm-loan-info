package org.doublem.dailyreports.vo.loan.detail;

import lombok.Data;

@Data
public class OptionList {
    private String dcls_month;
    private String fin_co_no;
    private String fin_prdt_cd;
    private String rpay_type;
    private String rpay_type_nm;
    private String lend_rate_type;
    private String lend_rate_type_nm;
    private Double lend_rate_min;
    private Double lend_rate_max;
    private Double lend_rate_avg;
}