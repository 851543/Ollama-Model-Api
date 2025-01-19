import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AIModelApiUtils {

    private final static String MODEL = "qwen2.5:14b";

    private final static String URL = "http://localhost:11434/api";

    private final static Map paramMap = new HashMap<String,Object>();

    private final static  boolean stream = true;

    /**
     * 生成补全
     * @return
     */
    public static String generate(){
        paramMap.put("model",MODEL);
        paramMap.put("prompt","你好 你是谁");
        paramMap.put("stream",stream);
        String doURL = URL + "/generate";
        String response = null;
        try {
            response = HttpClientUtil.doPost4Json(doURL, paramMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 生成补全
     * @return
     */
    public static void generateStream(){
        paramMap.put("model",MODEL);
        paramMap.put("prompt","朱BB是谁?");
        paramMap.put("stream",stream);
        String doURL = URL + "/generate";
        try {
            HttpClientUtil.doPost4JsonStream(doURL, paramMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成聊天
     * @return
     */
    public static String chat(){
        paramMap.put("model",MODEL);
        List messageArray= new ArrayList();
        Map messageObject= new HashMap();
        messageObject.put("role","user");
        messageObject.put("content","你好 你是谁");
        messageArray.add(messageObject);
        paramMap.put("messages",messageArray);
        paramMap.put("stream",stream);
        String doURL = URL + "/chat";
        String response = null;
        try {
            response = HttpClientUtil.doPost4Json(doURL, paramMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
