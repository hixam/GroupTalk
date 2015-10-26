package edu.upc.eetac.dsa.GroupTalk.dao;

import edu.upc.eetac.dsa.GroupTalk.entity.Response;
import edu.upc.eetac.dsa.GroupTalk.entity.ResponseCollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bernat on 25/10/15.
 */
public class ResponseDAOImpl implements ResponseDAO {
    @Override
    public Response createResponse (String idTema, String content, String autor_respuesta) throws SQLException{
        Connection connection = null;
        PreparedStatement stmt = null;
        String id = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(ResponseDAOQuery.UUID); //Crea el id único
            ResultSet rs = stmt.executeQuery(); //Ejecuta la query
            if (rs.next())
                id = rs.getString(1);
            else
                throw new SQLException();

            connection.setAutoCommit(false);

            stmt.close();

            stmt = connection.prepareStatement(ResponseDAOQuery.CREATE_RESPONSE);
            stmt.setString(1, id);
            stmt.setString(2, idTema);
            stmt.setString(3, autor_respuesta);
            stmt.setString(4,content);
            stmt.executeUpdate();
            stmt.close();

            connection.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        return getRespuestaById(id);
    }
    public Response updateResponse(String id, String content) throws SQLException{
        Response response = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(ResponseDAOQuery.UPDATE_RESPONSE);
            stmt.setString(1, id);
            stmt.setString(2, content);

            int rows = stmt.executeUpdate();
            if (rows == 1)
                response = getRespuestaById(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return response;
    }

    @Override
    public Response getRespuestaById(String id) throws SQLException{
        Response response = null;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            // Obtiene la conexión del DataSource
            connection = Database.getConnection();

            // Prepara la consulta
            stmt = connection.prepareStatement(ResponseDAOQuery.GET_RESPONSE_BY_ID);
            // Da valor a los parámetros de la consulta
            stmt.setString(1, id);

            // Ejecuta la consulta
            ResultSet rs = stmt.executeQuery();
            // Procesa los resultados
            if (rs.next()) {
                response = new Response();
                response.setId(rs.getString("id"));
                response.setIdtema(rs.getString("idtema"));
                response.setAutor_respuesta(rs.getString("autor_respuesta"));
                response.setContent(rs.getString("content"));


            }
        } catch (SQLException e) {
            // Relanza la excepción
            throw e;
        } finally {
            // Libera la conexión
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        // Devuelve el modelo
        return response;

    }
    @Override
    public ResponseCollection getResponses(String idtema) throws SQLException{

        ResponseCollection responseCollection = new ResponseCollection();

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(ResponseDAOQuery.GET_RESPONSE);
            stmt.setString(1,idtema);
            ResultSet rs = stmt.executeQuery();
            boolean first = true;
            while (rs.next()) {
                Response response = new Response();
                response.setId(rs.getString("id"));
                response.setIdtema(rs.getString("idtema"));
                response.setAutor_respuesta(rs.getString("autor_tema"));
                response.setContent(rs.getString("content"));

                responseCollection.getResponses().add(response);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return responseCollection;
    }
    public boolean deleteResponse (String id) throws SQLException{
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();

            stmt = connection.prepareStatement(ResponseDAOQuery.DELETE_RESPONSE);
            stmt.setString(1, id);

            int rows = stmt.executeUpdate();
            return (rows == 1);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null)
                stmt.close();
            if (connection != null)
                connection.close();
        }
    }
}
