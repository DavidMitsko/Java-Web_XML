package com.mitsko.xml_parsing.parser.sax;

import com.mitsko.xml_parsing.entity.Tariff;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

public class SAXParser {
    private ArrayList<Tariff> tariffs = new ArrayList<>();
    private XMLReader xmlReader;
    private TariffHandler tariffHandler;

    @Deprecated
    public SAXParser() {
        tariffHandler = new TariffHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(tariffHandler);
        } catch (SAXException ex) {

        }
    }

    public void parse(String fileName) {
        try {
            xmlReader.parse(fileName);

        } catch (SAXException e) {

        } catch (IOException e) {

        }
        tariffs = tariffHandler.getTariffs();
    }

    public ArrayList<Tariff> getTariffs() {
        return tariffs;
    }
}
