package TestJSONInUIAndServer;

import java.util.Date;

public class File extends FileSystemItem {
    private long size;
    
    public long getSize() {
        return size;
    }
    public void setSize(long size) {
        this.size = size;
    }
    
    public File(String name)
    {
        super(name);
    }
    
    public File(String name, Date creationDate)
    {
        super(name, creationDate);
    }
    
    public File(String name, long size)
    {
        super(name);
        this.size = size;
    }
    
    public File(String name, Date creationDate, long size)
    {
        super(name, creationDate);
        this.size = size;
    }
}
