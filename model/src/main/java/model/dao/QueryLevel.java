package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Map;

/**
 * Created by Théo on 21/06/2017.
 */
public abstract class QueryLevel extends AbstractDAO {

    private static String sqlMapByID = "{call getMapById(?)}";

    private static int idmapColumnIndex = 1;
    private static int mapColumnIndex = 6;

    private String map;

    public String getQuerySelectByIdMap(int idmap) throws SQLException {
        CallableStatement callStatement = prepareCall(sqlMapByID);
        Level level = null;
        callStatement.setInt(1, idmap);
        if (callStatement.execute()) {
            ResultSet result = callStatement.getResultSet();

            if (result.first()){
                map = result.getString(mapColumnIndex);

            }
            result.close();
        }
        return map;
    }
}
