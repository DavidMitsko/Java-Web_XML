import com.mitsko.xml_parsing.entity.Tariff;
import com.mitsko.xml_parsing.parser.dom.DOMParser;
import org.junit.Assert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

class DOMParserTest {
    private DocumentBuilder documentBuilder;
    private DocumentBuilderFactory documentBuilderFactory;

    @org.junit.jupiter.api.Test
    void parse() throws SAXException, ParserConfigurationException {
        DOMParser domParser = new DOMParser();

        Document document = null;
        try {
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();

            document = documentBuilder.parse("src/main/resources/tariff.xml");
        } catch (IOException ex) {
            System.out.println("File not found");
        }

        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("8 800 555 35 35");
        Tariff tariff1 = new Tariff.Builder("123", "MTS", "2500", "100",
                "500", "400", "25",
                numbers, "minute", "10").build();

        domParser.parse(document);

        ArrayList<Tariff> actual = domParser.getTariffs();

        Assert.assertEquals(tariff1, actual.get(0));
    }
}