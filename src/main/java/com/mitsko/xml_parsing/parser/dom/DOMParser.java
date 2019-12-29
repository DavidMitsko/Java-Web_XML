package com.mitsko.xml_parsing.parser.dom;

import com.mitsko.xml_parsing.entity.Tariff;
import com.mitsko.xml_parsing.parser.TariffParam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class DOMParser {
    private ArrayList<Tariff> tariffs = new ArrayList<>();

    public ArrayList<Tariff> getTariffs() {
        return tariffs;
    }

    public void parse(Document document) {
        Element root = document.getDocumentElement();
        Element tariffElement;

        NodeList tariffsList = root.getElementsByTagName(TariffParam.TARIFF.getValue());
        System.out.println(tariffsList.getLength());
        for(int i = 0; i < tariffsList.getLength(); i++) {
            tariffElement = (Element) tariffsList.item(i);
            tariffs.add(buildTariff(tariffElement));
            System.out.println(tariffs.get(i).toString());
        }
    }

    private Tariff buildTariff(Element tariffElement) {
        Tariff.Builder tariff = new Tariff.Builder();
        String tempSting;
        NodeList temp;

        tempSting = tariffElement.getAttribute(TariffParam.NAME.getValue());
        tariff.withName(tempSting);

        tempSting = tariffElement.getAttribute(TariffParam.OPERATOR_NAME.getValue());
        tariff.withOperatorName(tempSting);

        tempSting = getElementTextContent(tariffElement, TariffParam.PAYROLL.getValue());
        tariff.withPayroll(tempSting);

        tempSting = getElementTextContent(tariffElement,TariffParam.INSIDE.getValue());
        tariff.withInCallPrice(tempSting);

        tempSting = getElementTextContent(tariffElement,TariffParam.OUTSIDE.getValue());
        tariff.withOutCallPrice(tempSting);

        tempSting = getElementTextContent(tariffElement,TariffParam.HOME_PHONE.getValue());
        tariff.withHomePhoneCallPrice(tempSting);

        tempSting = getElementTextContent(tariffElement,TariffParam.SMS_PRICE.getValue());
        tariff.withSMSPrice(tempSting);

        temp = tariffElement.getElementsByTagName(TariffParam.FAVORITE_NUMBER.getValue());
        ArrayList<String> numbers = new ArrayList<>();
        for(int i = 0; i < temp.getLength(); i++){
            tempSting = getElementTextContent(tariffElement,TariffParam.FAVORITE_NUMBER.getValue());
            numbers.add(tempSting);
        }
        tariff.withFavoriteNumbers(numbers);

        tempSting = getElementTextContent(tariffElement,TariffParam.CHARGING.getValue());
        tariff.withCharging(tempSting);

        tempSting = getElementTextContent(tariffElement,TariffParam.CONNECTION_PRICE.getValue());
        tariff.withConnectionPrice(tempSting);

        return tariff.build();
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
