package programa;

import bd.daos.Livros;
import bd.dbos.Livro;

public class Programa
{

    public static void main (String[] args)
    {
        try
        {
            Livros.incluir (new Livro (1,"L'�tranger",20));
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

}
