import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Dictionary {
    private Map<String, String> map;

    public Dictionary(String dictionaryType) {
        map = MapFactory.createDictionary(dictionaryType);
    }

    public void loadDictionary(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            String[] parts = line.split("\\t");
            String word = parts[0].toLowerCase();
            String translation = parts[1];
            map.put(word, translation);
            line = reader.readLine();
        }
        reader.close();
    }

    public String translate(String word) {
        String translation = map.get(word.toLowerCase());
        if (translation == null) {
            return "*" + word + "*";
        } else {
            return translation;
        }
    }
}