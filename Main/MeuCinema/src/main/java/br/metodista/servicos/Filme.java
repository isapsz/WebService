/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.servicos;

/**
 *
 * @author u18194
 */
public class Filme {
    private Long id;
    private String filme;
    private String sinopse;
    private String genero;
    private String trailer;
    private Integer duracao;

      public Filme(Long id, String filme, String sinopse, 
    String genero, Integer duracao, String trailer) throws Exception
      {

        this.setId(id);
        this.setFilme(filme);
        this.setSinopse(sinopse);
        this.setGenero(genero);
        this.setTrailer(trailer);
        this.setDuracao(duracao);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) throws Exception{
        if(id == null || id < 0)
            throw new Exception("Id inválido");
        
        this.id = id;
    }

    public String getFilme() {
        return this.filme;
    }

    public void setFilme(String filme) throws Exception{
        if(filme == null || filme.equals(""))
            throw new Exception("Filme inválido");
        
        
        this.filme = filme;
    }

    public String getSinopse() {
        return this.sinopse;
    }

    public void setSinopse(String sinopse) throws Exception {
        if(sinopse == null || sinopse.equals(""))
            throw new Exception("Sinopse inválido");
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) throws Exception {
        if(genero == null || genero.equals(""))
            throw new Exception("Gênero inválido");
        this.genero = genero;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public void setTrailer(String trailer) throws Exception{
        if(trailer == null || trailer.equals(""))
            throw new Exception("Trailer inválido");
        this.trailer = trailer;
    }

    public Integer getDuracao() {
        return this.duracao;
    }

    public void setDuracao(Integer duracao) throws Exception{
        if(duracao == null || duracao < 0)
            throw new Exception("Durção inválida");
        this.duracao = duracao;
    }
}
