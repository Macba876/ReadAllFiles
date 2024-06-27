import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager implements IFileManager {



    @Override
    public List<Path> mGetFilePathsInRes() throws IOException {
        //Get all files
        return Files.walk(Paths.get(resFolder))
                .filter(Files::isRegularFile).toList();
    }

    @Override
    public ArrayList<String> mReadFileContent(List<Path> paths) throws IOException {
        ArrayList<String> contents = new ArrayList<>();

        for (Path p: paths) {
            String str = new String(Files.readAllBytes(p));
            contents.add(str);
        }
        return contents;
    }

    @Override
    public void mProcessList(ArrayList<String> fileContents) {
        String [] filesArray = fileContents.toArray(fileContents.toArray(new String[0]));

        List<String> words = new ArrayList<>();
        //turn each file content into an array of words
        for (String fileC:fileContents){
            /**splits the sentence in to individual words while ignoring space commas and periods*/
            String[] str = fileC.split("[ ,.]");

            /**stores that array in words array list */
            Collections.addAll(words, str);
        }

        Map<String, Integer> workCountMap = getWordCount(
                words.stream().sorted(
                        Comparator.reverseOrder()).collect(
                                Collectors.toList()));
        //words.forEach(System.out::println);
        workCountMap.forEach((key,value) -> System.out.println(key+" "+value));
    }

    @Override
    public Map<String, Integer> getWordCount(List<String> words){
        Map<String, Integer> wordMap = new HashMap<>();
        for (var word: words) {
            if(!wordMap.containsKey(word)){
                wordMap.put(word,1);
            }else{
                wordMap.put(word,wordMap.get(word)+1);
//                var x = wordMap.merge(word,1,Integer::sum);
//                System.out.println(word+"----------------------- "+x);
            }
        }


        return  wordMap;

    }


}
