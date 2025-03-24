package devcldkai.kaipizzas.mapper;

import devcldkai.kaipizzas.domain.entities.Products;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMappers {

    private ProductMappers() {}

    public static Products mapToProducts(ResultSet rs) throws SQLException {
        Products products = new Products();
        products.setId(rs.getLong("ProductID"));
        products.setName(rs.getString("ProductName"));
        products.setDescription(rs.getString("Description"));
        products.setPrice(rs.getDouble("UnitPrice"));
        products.setQuantity(rs.getLong("Quantity"));
        products.setSupplierId(rs.getInt("SupplierID"));
        products.setCategoryId(rs.getInt("CategoryID"));
        products.setProductImgUrl(rs.getString("ProductImage"));
        return products;
    }
}
