package com.mitsko.xml_parsing.parser.stax;

import com.mitsko.xml_parsing.entity.Tariff;
import com.mitsko.xml_parsing.parser.TariffParam;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class StAXParser {
    private ArrayList<Tariff> tariffs;
    private XMLInputFactory xmlInputFactory;

    public StAXParser() {
        tariffs = new ArrayList<>();
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    public ArrayList<Tariff> getTariffs() {
        return tariffs;
    }

    public void parse(String fileName) {
        XMLStreamReader reader;

        try(FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            reader = xmlInputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if(type == XMLStreamConstants.START_ELEMENT) {
                    String name = reader.getLocalName();
                    if(TariffParam.valueOf(name.toUpperCase()) == TariffParam.TARIFF) {
                        Tariff tariff = build(reader);
                        tariffs.add(tariff);
                    }
                }
            }
        } catch (XMLStreamException ex) {

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    private Tariff build(XMLStreamReader reader) throws XMLStreamException {
        Tariff.Builder builder = new Tariff.Builder();
        String temp;
        ArrayList<String> numbers = new ArrayList<>();

        temp = reader.getAttributeValue(null, TariffParam.NAME.getValue());
        builder.withName(temp);

        temp = reader.getAttributeValue(null, TariffParam.OPERATOR_NAME.getValue());
        builder.withOperatorName(temp);

        while(reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    temp = reader.getLocalName();
                    switch (TariffParam.valueOf(temp.toUpperCase())) {
                        case PAYROLL:
                            builder.withPayroll(getXMLText(reader));
                            break;
                        case INSIDE:
                            builder.withInCallPrice(getXMLText(reader));
                            break;
                        case OUTSIDE:
                            builder.withOutCallPrice(getXMLText(reader));
                            break;
                        case HOME_PHONE:
                            builder.withHomePhoneCallPrice(getXMLText(reader));
                            break;
                        case SMS_PRICE:
                            builder.withSMSPrice(getXMLText(reader));
                            break;
                        case FAVORITE_NUMBER:
                            numbers.add(getXMLText(reader));
                            break;
                        case CHARGING:
                            builder.withCharging(getXMLText(reader));
                            break;
                        case CONNECTION_PRICE:
                            builder.withConnectionPrice(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    temp = reader.getLocalName();
                    if (TariffParam.valueOf(temp.toUpperCase()) == TariffParam.TARIFF) {
                        builder.withFavoriteNumbers(numbers);
                        return builder.build();
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Flower");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
