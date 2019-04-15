/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.servicos;

import bd.dbos.Filme;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.*;

import bd.dbos.*;
import bd.daos.*;
import bd.core.*;

import com.google.gson.Gson;
import javax.ws.rs.PathParam;
/**
 * REST Web Service
 *
 * @author u18194
 */
@Path("filmes")
public class FilmesResource {
    
 private static List<Filme> filmes;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FilmesResource
     */
     public FilmesResource() throws Exception{
        filmes = new ArrayList<Filme>();
        MeuResultSet lista = Filmes.getFilmes();
        while(lista.next())
        {
            Filme umFilme = new Filme (lista.getLong("ID"), lista.getString("FILME"),
                               lista.getString("SINOPSE"),lista.getString("GENERO"),
                               lista.getInt("DURACAO"),lista.getString("TRAILER"));
            filmes.add(umFilme);
        }
    }
    /**
     * Retrieves representation of an instance of br.metodista.servicos.FilmesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        Gson gson = new Gson();
        return gson.toJson(filmes);
    }

    /**
     * PUT method for updating or creating an instance of FilmesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @GET
    @Path("{filmeId}")
    @Produces("application/json")
    public String getFilme(@PathParam("filmeId") String filmeId)
    {
        for(Filme f : filmes)
        {
            if(f.getId() == Long.valueOf(filmeId))
            {
                Gson gson = new Gson();
                return gson.toJson(f);
            }
        }
        return null;
    }
}
