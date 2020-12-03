import java.io.File;
import java.util.List;

public class FileTree {

    String rootDir;
    int depth;
    String mask;
    List<File> listFiles;

    public FileTree() {
        super();
    }

    public FileTree(String rootDir, int depth, String mask) {
        this.rootDir = rootDir;
        this.depth = depth;
        this.mask = mask;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public List<File> getListFiles() {
        return listFiles;
    }
}
