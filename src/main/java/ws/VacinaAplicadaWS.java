package ws;

import entity.Paciente;
import entity.VacinaAplicada;
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
import rn.PacienteRN;
import rn.VacinaAplicadaRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("vacinaAplicada")
public class VacinaAplicadaWS {

    VacinaAplicadaRN vacinaAplicadaRN;
    PacienteRN pacienteRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VacinaAplicadaWS
     */
    public VacinaAplicadaWS() {
        vacinaAplicadaRN = new VacinaAplicadaRN();
        pacienteRN = new PacienteRN();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacinaAplicadas(){
        List<VacinaAplicada> vacinaAplicada = vacinaAplicadaRN.listar();
        return Response.ok()
                .entity(vacinaAplicada)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }
    
    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public VacinaAplicada adicionar(VacinaAplicada vacinaAplicada,
            @Context HttpServletResponse response) {

        vacinaAplicadaRN.inserir(vacinaAplicada);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return vacinaAplicada;
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionar(VacinaAplicada vacinaAplicada, @Context HttpServletResponse response) {
        
        vacinaAplicadaRN.inserir(vacinaAplicada);
        response.setStatus(HttpServletResponse.SC_CREATED);
        
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        
        return Response.ok()
                .entity(vacinaAplicada)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST")
                .allow("OPTIONS").build();
    }

    /*@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public VacinaAplicada getVacinaAplicadaPorId(@PathParam("id") Long id) {
        return vacinaAplicadaRN.buscarPorId(id);
    }*/
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacinaAplicadaPorId(@PathParam("id") Long id) {
        VacinaAplicada vacinaAplicada = vacinaAplicadaRN.buscarPorId(id);
        return Response.ok()
                .entity(vacinaAplicada)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

    /*@PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public VacinaAplicada atualizar(@PathParam("id") Long id,
            VacinaAplicada vacinaAplicada){
        vacinaAplicada.setId(id);
        VacinaAplicada vacinaAplicadaAtualizado = vacinaAplicadaRN.atualizar(vacinaAplicada);
        return vacinaAplicadaAtualizado;
    }*/
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id, VacinaAplicada vacinaAplicada){
        vacinaAplicada.setId(id);
        VacinaAplicada vacinaAplicadaAtualizado = vacinaAplicadaRN.atualizar(vacinaAplicada);
        return Response.ok()
                .entity(vacinaAplicadaAtualizado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "PUT")
                .allow("OPTIONS").build();
    }
    
    /*@DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public VacinaAplicada deletar(@PathParam("id") Long id){
        VacinaAplicada vacinaAplicadaDeletado = vacinaAplicadaRN.deletar(id);
        return vacinaAplicadaDeletado;
    }*/
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") Long id){
        VacinaAplicada vacinaAplicadaDeletado = vacinaAplicadaRN.deletar(id);
        return Response.ok()
                .entity(vacinaAplicadaDeletado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "DELETE")
                .allow("OPTIONS").build();
    }
    
    @GET
    @Path("/paciente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPaciente(@PathParam("id") Long id){
        Paciente paciente = pacienteRN.buscarPorId(id);
        List<VacinaAplicada> vacinaAplicada = vacinaAplicadaRN.buscarPacientePorID(paciente.getId());
        //VacinaAplicada vacinaAplicada = vacinaAplicadaRN.buscarPorId(paciente.getId());
        return Response.ok()
                .entity(vacinaAplicada)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }
}
