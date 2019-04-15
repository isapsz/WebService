package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Filmes
{
    public static Filme getFilme (long id) throws Exception
    {
        Filme filme = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Filmes " +
                  "WHERE id = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setLong (1, id);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            filme = new Filme (resultado.getLong("ID"), resultado.getString("FILME"),
                               resultado.getString("SINOPSE"),resultado.getString("GENERO"),
                               resultado.getInt("DURACAO"),resultado.getString("TRAILER"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar filme");
        }

        return filme;
    }

    public static MeuResultSet getFilmes () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Filmes";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar filmes");
        }

        return resultado;
    }
}