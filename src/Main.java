import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input root path");
        String rootDir = scanner.nextLine();
        System.out.println("Input depth (positive mean number)");
        int depth = scanner.nextInt();
        System.out.println("Input mask");
        String mask = "test"; //scanner.nextLine();
        scanner.close();

        FileTree fileTree = new FileTree(rootDir, depth, mask);

        FileTreeController fileTreeController = new FileTreeController(fileTree);

        fileTreeController.treeParser();
        fileTreeController.printList();

    }
}