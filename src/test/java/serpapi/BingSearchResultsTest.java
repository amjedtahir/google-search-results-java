package serpapi;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Test bing search results 
 */
public class BingSearchResultsTest {

  BingSearchResults client;

  @Before
  public void setUp() throws Exception {
    if (System.getenv("API_KEY") != null) {
      BingSearchResults.serp_api_key_default = System.getenv("API_KEY");
    }
  }

  @Test
  public void searchCoffee() throws SerpApiClientException {
    // skip test if no api_key provided
    if (System.getenv("API_KEY") == null)
      return;

    Map<String, String> parameter = new HashMap<>();
    parameter.put("q", "Coffee");

    BingSearchResults result = new BingSearchResults(parameter);
    JsonObject results = result.getJson();
    assertTrue(results.getAsJsonArray("organic_results").size() > 5);
  }

}
