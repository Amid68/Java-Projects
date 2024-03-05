public class Language {
    protected String name;
    protected int numSpeakers;
    protected String regionsSpoken;
    protected String wordOrder;

    Language(String name, int numSpeakers, String regionsSpoken, String wordOrder) {
        this.name = name;
        this.numSpeakers = numSpeakers;
        this.regionsSpoken = regionsSpoken;
        this.wordOrder = wordOrder;
    }

    public void getInfo() {
        System.out.println(name + " is spoken by " + numSpeakers + " people mainly in " + regionsSpoken + ".");
        System.out.println("The language follows the word order: " + wordOrder);
    }
    public static void main(String[] args) {
        Language English = new Language("English", 1452000000, "North America", "Subject, verb, object");
        English.getInfo();
        Language chontal = new Mayan("Chontal", 36810);
        chontal.getInfo();
        Language mandarin = new SinoTibetan("Mandarin Chinese", 920000000);
        mandarin.getInfo();
        Language burmese = new SinoTibetan("Burmese", 36000000);
        burmese.getInfo();
    }
}