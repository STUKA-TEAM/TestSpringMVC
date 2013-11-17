package TestJSONInUIAndServer;

import java.util.Date;

public class FileSystemItem {
    private String name;
    private Date creationDate;
    private Boolean hidden;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public Boolean isHidden() {
        return hidden;
    }
    
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
    
    public FileSystemItem(String name)
    {
        this(name, null);
    }
    
    public FileSystemItem(String name, Date creationDate)
    {
        this.name = name;
        this.creationDate = creationDate;
    }
}
 