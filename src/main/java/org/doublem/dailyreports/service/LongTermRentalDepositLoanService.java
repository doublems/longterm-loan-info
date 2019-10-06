package org.doublem.dailyreports.service;

import org.doublem.dailyreports.vo.LongTermRentalDepositLoanVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class LongTermRentalDepositLoanService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public LongTermRentalDepositLoanVO getCurrentInfo(String lawXMLData) {
        return this.from(lawXMLData);
    }

    private LongTermRentalDepositLoanVO from(String lawXMLData) {

        LongTermRentalDepositLoanVO result = new LongTermRentalDepositLoanVO();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(lawXMLData));
            Document document = documentBuilder.parse(inputSource);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            document.getDocumentElement().normalize();

            logger.info("Document's Root : {}", document.getDocumentElement().getNodeName());

            NodeList nList = document.getElementsByTagName("item");

            for (int i = 0; i < nList.getLength(); i++) {
                NodeList item = nList.item(i).getChildNodes();
                LongTermRentalDepositLoanVO.Item resultItem = new LongTermRentalDepositLoanVO.Item();

                for (int j = 0; j < item.getLength(); j++) {

                    String n = item.item(j).getNodeName();
                    String v = item.item(j).getTextContent();

                    if (n.equals(LongTermRentalDepositLoanVO.ItemName.bssYmdStart.getXmlKeyName())) {
                        resultItem.setBssYmdStart(LocalDate.parse(v, DateTimeFormatter.BASIC_ISO_DATE));
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.bssYmdEnd.getXmlKeyName())) {
                        resultItem.setBssYmdEnd(LocalDate.parse(v, DateTimeFormatter.BASIC_ISO_DATE));
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.organId.getXmlKeyName())) {
                        resultItem.setOrganId(v);
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.callCenter.getXmlKeyName())) {
                        resultItem.setCallCenter(v);
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.interest1_1.getXmlKeyName())) {
                        resultItem.setInterest1_1(Double.parseDouble(v));
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.interest1_2.getXmlKeyName())) {
                        resultItem.setInterest1_2(Double.parseDouble(v));
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.interest2_1.getXmlKeyName())) {
                        resultItem.setInterest2_1(Double.parseDouble(v));
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.interest2_2.getXmlKeyName())) {
                        resultItem.setInterest2_2(Double.parseDouble(v));
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.interest3_1.getXmlKeyName())) {
                        resultItem.setInterest3_1(Double.parseDouble(v));
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.interest3_2.getXmlKeyName())) {
                        resultItem.setInterest3_2(Double.parseDouble(v));
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.interest4_1.getXmlKeyName())) {
                        resultItem.setInterest4_1(Double.parseDouble(v));
                    } else if (n.equals(LongTermRentalDepositLoanVO.ItemName.interest4_2.getXmlKeyName())) {
                        resultItem.setInterest4_2(Double.parseDouble(v));
                    }
                }

                result.getItems().add(resultItem);

                logger.debug("Document's resultItem : {}", resultItem);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return result;
    }

}