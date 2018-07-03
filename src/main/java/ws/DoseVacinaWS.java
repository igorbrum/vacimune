package ws;

import entity.DoseVacina;
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
import rn.DoseVacinaRN;
import rn.InsercoesIniciaisRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("doseVacina")
public class DoseVacinaWS {

    DoseVacinaRN doseVacinaRN;
    InsercoesIniciaisRN insere;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DoseVacinaWS
     */
    public DoseVacinaWS() {
        insere = new InsercoesIniciaisRN();
        insere.escolhaOpcao("dosevacina");
        doseVacinaRN = new DoseVacinaRN();
        
        if(doseVacinaRN.listar().isEmpty()){
            //criar todas doseVacina1 possiveis
            
        }
    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoseVacina> getDoseVacinas() {
        return (doseVacinaRN.listar());

    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoseVacinas(){
        List<DoseVacina> doseVacina = doseVacinaRN.listar();
        return Response.ok()
                .entity(doseVacina)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DoseVacina adicionar(DoseVacina doseVacina,
            @Context HttpServletResponse response) {

        doseVacinaRN.inserir(doseVacina);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return doseVacina;
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionar(DoseVacina doseVacina,
            @Context HttpServletResponse response) {
        
        doseVacinaRN.inserir(doseVacina);
        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        
        return Response.ok()
                .entity(doseVacina)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST")
                .allow("OPTIONS").build();
    }

    /*@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DoseVacina getDoseVacinaPorId(@PathParam("id") Long id) {
        return doseVacinaRN.buscarPorId(id);
    }*/
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoseVacinaPorId(@PathParam("id") Long id) {
        DoseVacina doseVacina = doseVacinaRN.buscarPorId(id);
        
        return Response.ok()
                .entity(doseVacina)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

    /*@PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DoseVacina atualizar(@PathParam("id") Long id,
            DoseVacina doseVacina){
        doseVacina.setId(id);
        DoseVacina doseDoseVacinaAtualizado = doseVacinaRN.atualizar(doseVacina);
        return doseDoseVacinaAtualizado;
    }*/
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id,
            DoseVacina doseVacina) {
        doseVacina.setId(id);
        DoseVacina doseVacinaAtualizado = doseVacinaRN.atualizar(doseVacina);
        
        return Response.ok()
                .entity(doseVacinaAtualizado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "PUT")
                .allow("OPTIONS").build();
    }
    
    /*@DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DoseVacina deletar(@PathParam("id") Long id){
        DoseVacina doseVacinaDeletado = doseVacinaRN.deletar(id);
        return doseVacinaDeletado;
    }*/
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") Long id){
        DoseVacina doseVacinaDeletado = doseVacinaRN.deletar(id);
        
        return Response.ok()
                .entity(doseVacinaDeletado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "DELETE")
                .allow("OPTIONS").build();
    }
}
