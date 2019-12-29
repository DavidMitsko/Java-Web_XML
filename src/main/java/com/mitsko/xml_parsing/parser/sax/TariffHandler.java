package com.mitsko.xml_parsing.parser.sax;

import com.mitsko.xml_parsing.entity.Tariff;
import com.mitsko.xml_parsing.parser.TariffParam;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.EnumSet;

public class TariffHandler extends DefaultHandler {
    private ArrayList<Tariff> tariffs;
    private ArrayList<String> numbers;
    private TariffParam tariffParam;
    private Tariff.Builder builder;
    private EnumSet<TariffParam> paramRange;

    public TariffHandler() {
        tariffs = new ArrayList<>();
        numbers = new ArrayList<>();
        paramRange = EnumSet.range(TariffParam.TARIFF, TariffParam.CONNECTION_PRICE);
    }

    @Override
    public void startDocument() {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if(TariffParam.TARIFF.getValue().equals(localName)) {
            builder = new Tariff.Builder();

            builder.withName(attrs.getValue(0));
            builder.withOperatorName(attrs.getValue(1));


        } else {
            TariffParam temp = TariffParam.valueOf(localName.toUpperCase());
            if(paramRange.contains(temp)) {
                tariffParam = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(TariffParam.TARIFF.getValue().equals(localName)) {
            builder.withFavoriteNumbers(numbers);
            Tariff tariff = builder.build();
            tariffs.add(tariff);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();

        if(tariffParam != null) {
            switch (tariffParam) {
                case PAYROLL:
                    builder.withPayroll(s);
                    break;
                case INSIDE:
                    builder.withInCallPrice(s);
                    break;
                case OUTSIDE:
                    builder.withOutCallPrice(s);
                    break;
                case HOME_PHONE:
                    builder.withHomePhoneCallPrice(s);
                    break;
                case SMS_PRICE:
                    builder.withSMSPrice(s);
                    break;
                case FAVORITE_NUMBER:
                    numbers.add(s);
                    break;
                case CHARGING:
                    builder.withCharging(s);
                    break;
                case CONNECTION_PRICE:
                    builder.withConnectionPrice(s);
                    break;
            }
        }
        tariffParam = null;
    }

    public ArrayList<Tariff> getTariffs() {
        return tariffs;
    }
}
