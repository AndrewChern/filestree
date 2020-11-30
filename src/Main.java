import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input root path");
        String rootDir = scanner.nextLine();
        System.out.println("Input depth (positive mean number)");
        int depth = scanner.nextInt();
        System.out.println("Input mask");
        String mask = "test"; //scanner.nextLine();
        scanner.close();

        File root = new File(rootDir);
        File[] allFiles = root.listFiles();
        int i = 0;

        while(i<allFiles.length) {
            File curElement = allFiles[i];
            File[] subFiles;
            if (curElement.isDirectory()) {
                subFiles = curElement.listFiles();
            }
            else {
                i++;
                continue;
            }
            File[] tempArr = new File[allFiles.length + subFiles.length];
            for (int j = 0; j<=i; j++) {
                tempArr[j] = allFiles[j];
            }
            for (int k = 0; k<subFiles.length; k++) {
                tempArr[i + k + 1] = subFiles[k];
            }
            for (int m = i+1; m<allFiles.length; m++) {
                tempArr[m + subFiles.length] = allFiles[m];
            }
            allFiles = tempArr;
            i++;
        }

        List<File> listFiles = Arrays.stream(allFiles)
                .filter(file -> file.toPath().getNameCount() <= (depth+1))//Path.getNameCount() returns the number of name elements in the path
                .filter(file -> file.getName().contains(mask))
                .collect(Collectors.toList());

        for (File somefile:listFiles) {
            System.out.println(somefile.toString());
        }
    }
}