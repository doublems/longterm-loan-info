package org.doublem.dailyreports.vo.loan.detail;

import lombok.Data;

@Data
class Result {
    private String prdt_div;
    private String total_count;
    private String max_page_no;
    private String now_page_no;
    private String err_cd;
    private String err_msg;
    BaseList[] baseList;
    OptionList[] optionList;
}