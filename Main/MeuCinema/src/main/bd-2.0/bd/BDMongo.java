package bd;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class BDMongo
{
    public final static DB BD;
    public final static DBCollection COLECAO;	

    static
    {
        DB bd                = null;
        DBCollection colecao = null;

        try
        {
            Mongo mongo = new Mongo   ("SERVIDOR", 27017);
            bd          = mongo.getDB ("BD");
            colecao     = bd.getCollection ("COLECAO");
        }
        catch(Exception e)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }

        BD      = bd;
        COLECAO = colecao;
    }
}
