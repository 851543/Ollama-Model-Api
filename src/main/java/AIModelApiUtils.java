import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

public class AIModelApiUtils {

    private final static String MODEL = "qwen2.5:14b";

    private final static String URL = "http://localhost:11434/api";

    private final static Map paramMap = new HashMap<String,String>();

    private final static  boolean stream = false;

    static {
        paramMap.put("model",MODEL);
        paramMap.put("prompt","def compute_gcd(a, b):");
        paramMap.put("stream",stream);
        paramMap.put("suffix","    return result");
        Map temperature = new HashMap();
        temperature.put("temperature",0);
        paramMap.put("options",temperature);
    }

    public static String generate(){
        String doURL = URL + "/generate";
        String response = null;
        try {
            response = HttpClientUtil.doPost4Json(doURL, paramMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
