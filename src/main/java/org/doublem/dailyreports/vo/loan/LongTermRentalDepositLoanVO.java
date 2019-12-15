package org.doublem.dailyreports.vo.loan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LongTermRentalDepositLoanVO {

    private List<Item> items = new ArrayList<>();
    private int numOfRows;
    private int pageNo;
    private int totalCount;

    @Getter
    @Setter
    @ToString
    public static class Item {


        private LocalDate bssYmdStart;
        private LocalDate bssYmdEnd;

        @JsonProperty("bankName")
        private String organId;
        @JsonProperty("bankCallCenter")
        private String callCenter;

        @JsonProperty("benchmark1")
        private double interest1_1;
        @JsonProperty("benchmark2")
        private double interest1_2;

        @JsonProperty("partialGuarantee1")
        private double interest2_1;
        @JsonProperty("partialGuarantee2")
        private double interest2_2;

        @JsonProperty("spread1")
        private double interest3_1;
        @JsonProperty("spread2")
        private double interest3_2;

        @JsonProperty("resultRate1")
        private double interest4_1;
        @JsonProperty("resultRate2")
        private double interest4_2;

    }

    @Getter
    public static enum ItemName {

        bssYmdStart("bssYmdStart", "bssYmdStart", "기준년월시작"),
        bssYmdEnd("bssYmdEnd", "bssYmdEnd", "기준년월종료"),
        organId("organId", "bankName", "은행명"),
        callCenter("callCenter", "bankCallCenter", "고객센터"),
        interest1_1("interest1_1", "benchmark1", "부분보증비율1"),
        interest1_2("interest1_2", "benchmark2", "부분보증비율2"),
        interest2_1("interest2_1", "partialGuarantee1", "기준금리1"),
        interest2_2("interest2_2", "partialGuarantee2", "기준금리2"),
        interest3_1("interest3_1", "spread1", "가산금리1"),
        interest3_2("interest3_2", "spread2", "가산금리2"),
        interest4_1("interest4_1", "resultRate1", "적용금리1"),
        interest4_2("interest4_2", "resultRate2", "적용금리2");

        private String xmlKeyName;
        private String voName;
        private String description;

        ItemName(String xmlKeyName, String voName, String description) {
            this.xmlKeyName = xmlKeyName;
            this.voName = voName;
            this.description = description;
        }
    }

}
