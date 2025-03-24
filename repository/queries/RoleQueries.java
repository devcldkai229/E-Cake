package devcldkai.kaipizzas.repository.queries;

public class RoleQueries {

    private RoleQueries(){}

    public static final String DEF_LOAD_ROLE_BY_ID = "select Name from Roles where RoleID = ?";
}
