import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IFileManager {
    String resFolder = "src/resources";

    List<Path> mGetFilePathsInRes() throws IOException;

    ArrayList<String> mReadFileContent(List<Path> paths) throws IOException;

    void mProcessList(ArrayList<String> fileContents);
    Map<String, Integer> getWordCount(List<String> words);
}
