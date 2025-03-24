package devcldkai.kaipizzas.mapper;

import devcldkai.kaipizzas.domain.entities.Categories;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMappers {

    private CategoryMappers() {}

    public static Categories mapToCategory(ResultSet rs) throws SQLException {
        Categories categories = new Categories();
        categories.setId(rs.getInt("CategoryID"));
        categories.setName(rs.getString("CategoryName"));
        categories.setDescription(rs.getString("Description"));
        return categories;
    }
}
