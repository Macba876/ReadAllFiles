import java.io.IOException;
import java.util.HashMap;

public class Main  {
    public static void main(String[] args) {
        FileManager fm = new FileManager();
        HashMap<String,Integer> test = new HashMap<>();
        test.put("a",1);
        test.put("b",test.get("a")+1);
        test.put("a",test.get("a")+1);

        test.forEach((key,val)-> System.out.println(key+ " "+ val));
        try {
            fm.mProcessList(fm.mReadFileContent(fm.mGetFilePathsInRes()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}