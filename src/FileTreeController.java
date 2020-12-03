import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileTreeController {

    List<File> listFiles;
    private FileTree fileTree;

    public FileTreeController(FileTree fileTree) {
        this.listFiles = listFiles;
        this.fileTree = fileTree;
    }

    public FileTree getFileTree() {
        return fileTree;
    }

    public void setFileTree(FileTree fileTree) {
        this.fileTree = fileTree;
    }

    public List<File> getListFiles() {
        return listFiles;
    }

    public List treeParser ()throws IOException{
        File root = new File(fileTree.getRootDir());
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

        listFiles = Arrays.stream(allFiles)
                .filter(file -> file.toPath().getNameCount() <= (fileTree.getDepth()+1))//Path.getNameCount() returns the number of name elements in the path
                .filter(file -> file.getName().contains(fileTree.getMask()))
                .collect(Collectors.toList());

        return listFiles;
    }

    public void printList(){
        for (File somefile:listFiles) {
            System.out.println(somefile.toString());
        }
    }
}
