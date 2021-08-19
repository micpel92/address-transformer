package eu.micpel.addtra;

public class AddressParser {

    public Address parseAddress(String value) {
        var numberFirstTransformer = new AddressTransformer("^(?<housenumber>\\d+),*(?<street>\\s*[a-zA-Z]*\\s+.*)$");
        var numberLastTransformer = new AddressTransformer("^(?<street>.+?),?(?:No)?\\s+(?<housenumber>\\d+\\s*[a-zA-Z]*)$");

        return Transformation
                .tryUsing(numberFirstTransformer)
                .thenUsing(numberLastTransformer)
                .givenInput(value);
    }

}
