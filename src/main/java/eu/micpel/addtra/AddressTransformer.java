package eu.micpel.addtra;

import java.util.Optional;
import java.util.regex.Pattern;

public class AddressTransformer implements Transformer<String, Address> {

    private Pattern pattern;

    public AddressTransformer(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public Optional<Address> tryToTransform(String source) {
        var matcher = pattern.matcher(source);

        if (!matcher.matches()) {
            return Optional.empty();
        }

        if (matcher.groupCount() != 2) {
            throw new IllegalStateException("Unexpected count of groups found by regular expression");
        }

        var address = new Address();
        address.setStreet(matcher.group("street").trim());
        address.setHousenumber(matcher.group("housenumber").trim());
        return Optional.of(address);
    }

}
