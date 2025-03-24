package devcldkai.kaipizzas.domain.entities;

public class Categories {

    private Integer id;

    private String name;

    private String description;

    public Categories() {}

    public Categories(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
