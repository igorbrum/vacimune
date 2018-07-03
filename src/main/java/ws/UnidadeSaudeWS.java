package ws;

import entity.UnidadeSaude;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rn.UnidadeSaudeRN;
import rn.InsercoesIniciaisRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("unidadeSaude")
public class UnidadeSaudeWS {

    UnidadeSaudeRN unidadeSaudeRN;
    InsercoesIniciaisRN insere;
    //private static int autoIncr = 1;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UnidadeSaudeWS
     */
    public UnidadeSaudeWS() {
        insere = new InsercoesIniciaisRN();
        insere.escolhaOpcao("unidadessaude");
        unidadeSaudeRN = new UnidadeSaudeRN();
        /*if(unidadeSaudeRN.listar().isEmpty()){
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(1),"Caxumba"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(2),"Difteria"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(3),"Febre Amarela"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(4),"Gripe"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(5),"Hepatite A")); // ainda nao colocado no watson...
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(6),"Hepatite B"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(7),"Hib (Haemophilus influenzae)"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(8),"HPV"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(9),"Meningite"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(10),"Pertussis (Coqueluche)"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(11),"Pneumonia"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(12),"Poliomielite"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(13),"Rotavirus"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(14),"Rubeola"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(15),"Sarampo"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(16),"Tetano"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(17),"Tuberculose (BCG)"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(18),"Otite"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(19),"Sinusite"));
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(20),"Catapora (sinonimo de Varicela)"));
        }*/
    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UnidadeSaude> getUnidadeSaudes() {
        return (unidadeSaudeRN.listar());

    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUnidadeSaudes() {
        List<UnidadeSaude> paciente = unidadeSaudeRN.listar();
        return Response.ok()
                .entity(paciente)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UnidadeSaude adicionar(UnidadeSaude unidadeSaude,
            @Context HttpServletResponse response) {

        unidadeSaudeRN.inserir(unidadeSaude);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return unidadeSaude;
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionar(UnidadeSaude unidadeSaude,
            @Context HttpServletResponse response) {

        unidadeSaudeRN.inserir(unidadeSaude);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return Response.ok()
                .entity(unidadeSaude)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST")
                .allow("OPTIONS").build();
    }

    /*@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UnidadeSaude getUnidadeSaudePorId(@PathParam("id") Long id) {
        return unidadeSaudeRN.buscarPorId(id);
    }*/
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUnidadeSaudePorId(@PathParam("id") Long id) {
        UnidadeSaude unidadeSaude = unidadeSaudeRN.buscarPorId(id);
        
        return Response.ok()
                .entity(unidadeSaude)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

    /*@PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UnidadeSaude atualizar(@PathParam("id") Long id,
            UnidadeSaude unidadeSaude){
        unidadeSaude.setId(id);
        UnidadeSaude unidadeSaudeAtualizado = unidadeSaudeRN.atualizar(unidadeSaude);
        return unidadeSaudeAtualizado;
    }*/
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id, UnidadeSaude unidadeSaude){
        unidadeSaude.setId(id);
        UnidadeSaude unidadeSaudeAtualizado = unidadeSaudeRN.atualizar(unidadeSaude);
        
        return Response.ok()
                .entity(unidadeSaudeAtualizado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "PUT")
                .allow("OPTIONS").build();
    }
    
    /*@DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UnidadeSaude deletar(@PathParam("id") Long id){
        UnidadeSaude unidadeSaudeDeletado = unidadeSaudeRN.deletar(id);
        return unidadeSaudeDeletado;
    }*/
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") Long id){
        UnidadeSaude unidadeSaudeDeletado = unidadeSaudeRN.deletar(id);
        
        return Response.ok()
                .entity(unidadeSaudeDeletado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "DELETE")
                .allow("OPTIONS").build();
    }
}
