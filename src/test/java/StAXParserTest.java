import com.mitsko.xml_parsing.entity.Tariff;
import com.mitsko.xml_parsing.parser.stax.StAXParser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StAXParserTest {

    @Test
    void parse() {
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("8 800 555 35 35");
        Tariff tariff1 = new Tariff.Builder("123", "MTS", "2500", "100",
                "500", "400", "25",
                numbers, "minute", "10").build();

        StAXParser parser = new StAXParser();
        parser.parse("src/main/resources/tariff.xml");

        ArrayList<Tariff> actual = parser.getTariffs();

        Assert.assertEquals(tariff1, actual.get(0));
    }
}