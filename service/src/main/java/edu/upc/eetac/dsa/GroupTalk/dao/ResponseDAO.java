package edu.upc.eetac.dsa.GroupTalk.dao;

import edu.upc.eetac.dsa.GroupTalk.entity.Response;
import edu.upc.eetac.dsa.GroupTalk.entity.ResponseCollection;

import java.sql.SQLException;

/**
 * Created by hixam on 25/10/15.
 */
public interface ResponseDAO {

    public Response createResponse (String idTema, String content, String autor_respuesta) throws SQLException;
    public Response updateResponse(String id, String content) throws SQLException;
    public Response getRespuestaById(String id) throws SQLException;
    public ResponseCollection getResponses(String idtema) throws SQLException;
    public boolean deleteResponse (String id) throws SQLException;
}
