package uj.ii.transferobjects;

public class Publication implements java.io.Serializable {

	private String name;
    private String description;
    private String owner;
    private String ownerFirstName;
    private String ownerLastName;
    
    public Publication() {
    }
    
    public Publication(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Publication(String name, String description, String firstName, String lastName) {
        this.name = name;
        this.description = description;
        this.ownerFirstName = firstName;
        this.ownerLastName = lastName;
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
        return "Publication{" + "name=" + name + "description=" + description + "owner=" + owner + '}';
    }
}
