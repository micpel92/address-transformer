package eu.micpel.addtra;

public class App {
    public static void main(String[] args) {
        var parser = new AddressParser();

        for (var item : args) {
            try {
                System.out.println(parser.parseAddress(item).toJson());
            } catch (Exception e) {
                System.err.println("Unable to process entry: " + item);
            }
        }
    }
}
