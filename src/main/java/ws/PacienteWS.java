package ws;

import entity.Paciente;
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

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("paciente")
public class PacienteWS {

    PacienteRN pacienteRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PacienteWS
     */
    public PacienteWS() {
        pacienteRN = new PacienteRN();

    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> getPacientes() {
        return (pacienteRN.listar());

    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPacientes() {
        List<Paciente> paciente = pacienteRN.listar();
        return Response.ok()
                .entity(paciente)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente adicionar(Paciente paciente,
            @Context HttpServletResponse response) {

        pacienteRN.inserir(paciente);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return paciente;
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionar(Paciente paciente, @Context HttpServletResponse response) {

        pacienteRN.inserir(paciente);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return Response.ok()
                .entity(paciente)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST")
                .allow("OPTIONS").build();
    }

    /*@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente getPacientePorId(@PathParam("id") Long id) {
        return pacienteRN.buscarPorId(id);
    }*/
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPacientePorId(@PathParam("id") Long id) {
        Paciente paciente = pacienteRN.buscarPorId(id);
        
        return Response.ok()
                .entity(paciente)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

    /*@PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente atualizar(@PathParam("id") Long id,
            Paciente paciente){
        paciente.setId(id);
        Paciente pacienteAtualizado = pacienteRN.atualizar(paciente);
        return pacienteAtualizado;
    }*/
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id, Paciente paciente){
        paciente.setId(id);
        Paciente pacienteAtualizado = pacienteRN.atualizar(paciente);
        
        return Response.ok()
                .entity(pacienteAtualizado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "PUT")
                .allow("OPTIONS").build();
    }
    
    /*@DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente deletar(@PathParam("id") Long id){
        Paciente pacienteDeletado = pacienteRN.deletar(id);
        return pacienteDeletado;
    }*/
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") Long id){
        Paciente pacienteDeletado = pacienteRN.deletar(id);
        
        return Response.ok()
                .entity(pacienteDeletado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "DELETE")
                .allow("OPTIONS").build();
    }
}
