package uj.ii.transferobjects;

public class Conference {

    private String name;
    private String description;
    private String owner;

    public Conference() {
    }
    
    public Conference(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Conference{" + "name=" + name + "description=" + description + "owner=" + owner + '}';
    }
}
