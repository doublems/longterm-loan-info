package org.doublem.dailyreports.vo.loan.detail;

import lombok.Data;

@Data
public class BaseList {
    private String dcls_month;
    private String fin_co_no;
    private String fin_prdt_cd;
    private String kor_co_nm;
    private String fin_prdt_nm;
    private String join_way;
    private String loan_inci_expn;
    private String erly_rpay_fee;
    private String dly_rate;
    private String loan_lmt;
    private String dcls_strt_day;
    private String dcls_end_day;
    private String fin_co_subm_day;
}