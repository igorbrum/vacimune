package ws;

import entity.Vacina;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rn.VacinaRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("vacina")
public class VacinaWS {

    VacinaRN vacinaRN;
    //DoencaRN doencaRN;
    //private static int autoIncr = 1;
    
    @Context
    private UriInfo context;
    
    
    /**
     * Creates a new instance of VacinaWS
     */
    public VacinaWS() {
        vacinaRN = new VacinaRN();
        
        // Como adicionar vacina que contem uma doenca? Deve verificar se a doenca jah esta contida... 
        //se estiver, usa ela, senao, cria...
        //if(vacinaRN.listar().isEmpty()){
            //vacinaRN.inserir(new Vacina(Long.valueOf(1), "Antimeningococica", 3, (List<Doenca>) doencaRN.buscarPorId(Long.valueOf(8))) );        
        //}

    }

    public List<Vacina> listaVacinas() {
        return (vacinaRN.listar());
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacinas() {
        List<Vacina> vacina = listaVacinas();
        return Response.ok()
                .entity(vacina)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }
    
    //--NOVO!!
    //@GET //para buscar por nome
    /*@GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vacina> getVacinas(@QueryParam("nome") String nome) {
        List<Vacina> listaVacinasBusca = new ArrayList<>();
        for(Vacina p: listaVacinas()){
            if(p.getNome().contains(nome)){
                listaVacinasBusca.add(p);
            }
        }
        if(listaVacinasBusca.isEmpty())
            throw new NotFoundException();
        else
            return listaVacinasBusca;
    }*/
    
    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacinas(@QueryParam("nome") String nome) {
        List<Vacina> listaVacinasBusca = new ArrayList<>();
        for(Vacina p: listaVacinas()){
            if(p.getNome().contains(nome)){
                listaVacinasBusca.add(p);
            }
        }
        if(listaVacinasBusca.isEmpty())
            throw new NotFoundException();
        else
            return Response.ok()
                .entity(listaVacinasBusca)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }
    
    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vacina adicionar(Vacina vacina,
            @Context HttpServletResponse response) {

        vacinaRN.inserir(vacina);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return vacina;
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionar(Vacina vacina, @Context HttpServletResponse response) {

        vacinaRN.inserir(vacina);
        response.setStatus(HttpServletResponse.SC_CREATED);
        
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return Response.ok()
                .entity(vacina)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST")
                .allow("OPTIONS").build();
    }

    /*@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vacina getVacinaPorId(@PathParam("id") Long id) {
        return vacinaRN.buscarPorId(id);
    }*/
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacinaPorId(@PathParam("id") Long id) {
        Vacina vacina = vacinaRN.buscarPorId(id);
        return Response.ok()
                .entity(vacina)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

    /*@PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vacina atualizar(@PathParam("id") Long id,
            Vacina vacina){
        vacina.setId(id);
        Vacina vacinaAtualizado = vacinaRN.atualizar(vacina);
        return vacinaAtualizado;
    }*/
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id, Vacina vacina){
        vacina.setId(id);
        Vacina vacinaAtualizado = vacinaRN.atualizar(vacina);
        return Response.ok()
                .entity(vacinaAtualizado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "PUT")
                .allow("OPTIONS").build();
    }
    
    /*@DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vacina deletar(@PathParam("id") Long id){
        Vacina vacinaDeletado = vacinaRN.deletar(id);
        return vacinaDeletado;
    }*/
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") Long id){
        Vacina vacinaDeletado = vacinaRN.deletar(id);
        return Response.ok()
                .entity(vacinaDeletado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "DELETE")
                .allow("OPTIONS").build();
    }
}
