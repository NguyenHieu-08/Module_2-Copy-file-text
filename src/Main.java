import java.io.*;
import java.util.*;

public class Main {

    public static List<String> readFile(String filePath){
        List<String> word = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("");
                for(int i = 0; i < arr.length; i++)
                    word.add(arr[i]);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return word;
    }

    public static void writeFile(String filePath, String[] words){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Chuỗi copy: " + String.join("", words));
            bufferedWriter.write("\nSố ký tự: " + words.length);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] printArr(List<String> words) {
        String[] newArr = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            newArr[i] = words.get(i);
        }
        return newArr;
    }

    public static void main(String[] args) {
        List<String> words = readFile("C:\\Users\\nguye\\OneDrive\\Máy tính\\demo\\copy\\src\\File.txt");
        String[] wordArr = printArr(words);
        writeFile("C:\\Users\\nguye\\OneDrive\\Máy tính\\demo\\copy\\src\\result.txt", wordArr);
    }
}