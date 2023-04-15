import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String uri = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
        CloseableHttpClient httpClient = HttpClient.get();
        HttpGet request = HttpRequest.get(uri);
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            Parser parser = new Parser();
            List<Facts> catFacts = parser.parse(response.getEntity().getContent());
            catFacts.stream()
                    .filter(value -> value.getUpvotes() != null && value.getUpvotes() > 0)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
