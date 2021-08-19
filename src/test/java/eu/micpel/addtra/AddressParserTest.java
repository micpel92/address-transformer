package eu.micpel.addtra;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AddressParserTest {

    @ParameterizedTest(name = "In address ''{0}'' street is ''{1}'' and house number is ''{2}''")
    @CsvSource(delimiter = ':', value = {
            "Winterallee 3:Winterallee:3",
            "Musterstrasse 45:Musterstrasse:45",
            "Blaufeldweg 123B:Blaufeldweg:123B",
            "Am Bächle 23:Am Bächle:23",
            "Auf der Vogelwiese 23 b:Auf der Vogelwiese:23 b",
            "4, rue de la revolution:rue de la revolution:4",
            "200 Broadway Av:Broadway Av:200",
            "Calle Aduana, 29:Calle Aduana:29",
            "Calle 39 No 1540:Calle 39:1540"
    })
    void testParseAddress(String address, String street, String housenumber) {
        // given
        var underTest = new AddressParser();

        // when
        var result = underTest.parseAddress(address);

        // then
        assertThat(result.getStreet()).isEqualTo(street);
        assertThat(result.getHousenumber()).isEqualTo(housenumber);
    }

}
