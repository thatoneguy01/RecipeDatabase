import javax.management.Query;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Daniel on 11/19/14.
 */
public class Search {

    public static Iterable<Integer> findRecipeByKeyword(String searchQuery) {
        ResultSet rs = query("SELECT recipeId FROM Keywords WHERE keyword=" + searchQuery);
        ArrayList list = new ArrayList();
        if (rs != null) {
            try {
                while (rs.next()){
                   list.add(rs.getInt("recipeId"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static Iterable multiKeywordSearch(Iterable<String> keywords) {
        ArrayList results = new ArrayList();
        for (String s : keywords) {
            for ()
        }

    }

    public static Recipe getRecipeInfo(int recipeId)
    {
        ResultSet rs = query("SELECT * FROM Recipes WHERE recipeId=" + recipeId);

    }

    public static ResultSet query(String query) {
        String db = "DatabaseName";
        Connection conn = null;
        Statement stmt = null;
        try
        {
            DriverManager.getConnection(db);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = query;
        ResultSet rs = null;
        try
        {
            rs = stmt.executeQuery(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
