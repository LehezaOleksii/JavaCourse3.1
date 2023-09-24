package oleksii.leheza.java.lab5.filehendlers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TagFrequencyCounter {

	public void printIdenticalTags(String url) {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);

		try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				Document document = Jsoup.parse(entity.getContent(), "UTF-8", url);
				Elements elements = document.select("*");

				Map<String, Integer> tagFrequency = new HashMap<>();

				for (Element element : elements) {
					String tagName = element.tagName();
					tagFrequency.put(tagName, tagFrequency.getOrDefault(tagName, 0) + 1);
				}

				// Виведення результатів в порядку зростання за тегами
				System.out.println("Частота тегів (в лексикографічному порядку):");
				TreeMap<String, Integer> sortedTagFrequency = new TreeMap<>(tagFrequency);
				sortedTagFrequency.forEach((tag, count) -> System.out.println(tag + ": " + count));

				// Виведення результатів в порядку зростання по частоті появи тегів
				System.out.println("\nЧастота тегів (в порядку зростання по частоті):");
				tagFrequency.entrySet().stream().sorted(Map.Entry.comparingByValue())
						.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}