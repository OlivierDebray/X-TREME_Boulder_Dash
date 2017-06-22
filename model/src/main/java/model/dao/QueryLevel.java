package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Théo on 21/06/2017.
 */
public class QueryLevel extends AbstractDAO {

    private static String sqlMapByID = "{call getMapByID(?)}";

    private static int boulder_dash_mapColumnIndex = 2;

    public static String mapString;


    public static String getQuerySelectByIdMap(int idmap) throws SQLException {
        CallableStatement callStatement = prepareCall(sqlMapByID);
        callStatement.setInt(1, idmap);
        if (callStatement.execute()) {
            ResultSet result = callStatement.getResultSet();

            if (result.first()){
                mapString = result.getString(boulder_dash_mapColumnIndex);
            }
        }
        return mapString;
    }
}
