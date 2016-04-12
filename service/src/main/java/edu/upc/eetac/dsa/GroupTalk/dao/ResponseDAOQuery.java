package edu.upc.eetac.dsa.GroupTalk.dao;

/**
 * Created by hixam on 25/10/15.
 */
public interface ResponseDAOQuery {
    public final static String  UUID = "select REPLACE(UUID(),'-','')";

    public final static String CREATE_RESPONSE = "insert into respuesta (id, idtema,autor_respuesta, content) " +
            "values (UNHEX(?), unhex(?),unhex(?), ?)";

    public final static String GET_RESPONSE="select hex(id) as id, hex(idtema) as idtema, hex(autor_respuesta) as "+
            "autor_respuesta,content from respuesta where idtema = unhex(?)";

    public final static String GET_RESPONSE_BY_ID= "select hex(r.id) as id, hex(r.idtema) as idtema, hex(r.autor_respuesta) " +
            "as autor_respuesta, r.content, u.login from respuesta r, users u where r.id=unhex(?) and u.id=t.userid";


    public final static String UPDATE_RESPONSE="update respuesta content=? where id=unhex(?) ";

    public final static String DELETE_RESPONSE="delete from respuesta where id=unhex(?)";
}
