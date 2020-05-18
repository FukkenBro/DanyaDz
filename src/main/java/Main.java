
public class Main {

    public static void main(String[] args) {

        String url = new  MyUrl.Builder()
                .withProtocol("http")
                .withDomain("google.com")
                .withPath("chrome")
                .withParams("asd","1231")
                .withParams("aasdassd","1231")
                .build();
        System.out.println("URL: " + url);
    }
}
