package TestJSONInUIAndServer;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemItem {
    private File[] files;
    private Folder[] folders;
     
    public File[] getFiles() {
        return files;
    }
      
    public Folder[] getFolders() {
        return folders;
    }
    
    public Folder(String name, FileSystemItem...items)
    {
        super(name);
        
        List<File> files = new ArrayList<File>();
        List<Folder> folders = new ArrayList<Folder>();
        
        for(FileSystemItem item : items)
        {
            if (item instanceof File)
            {
                files.add((File)item);
            }
            else
            {
                folders.add((Folder)item);
            }
        }
        
        this.files = files.toArray(new File[files.size()]);
        this.folders = folders.toArray(new Folder[folders.size()]);
    }
}
