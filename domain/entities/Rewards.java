package devcldkai.kaipizzas.domain.entities;

public class Rewards {

    private Integer id;

    private String name;

    private Double point;

    private Integer limitExchange;

    private String description;

    private String imageUrl;

    private Integer quantity;

    public Rewards(){}

    public Rewards(String name, Double point, Integer quantity, Integer limitExchange, String description, String imageUrl) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.point = point;
        this.quantity = quantity;
        this.limitExchange = limitExchange;
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

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getLimitExchange() {
        return limitExchange;
    }

    public void setLimitExchange(Integer limitExchange) {
        this.limitExchange = limitExchange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", limitExchange=" + limitExchange +
                ", imageUrl='" + imageUrl + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
