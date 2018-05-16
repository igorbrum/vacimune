package ws;

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
import rn.VacinaAplicadaRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("vacinaAplicada")
public class VacinaAplicadaWS {

    VacinaAplicadaRN vacinaAplicadaRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VacinaAplicadaWS
     */
    public VacinaAplicadaWS() {
        vacinaAplicadaRN = new VacinaAplicadaRN();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VacinaAplicada> getVacinaAplicadas() {
        return (vacinaAplicadaRN.listar());

    }

    @POST
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
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public VacinaAplicada getVacinaAplicadaPorId(@PathParam("id") Long id) {
        return vacinaAplicadaRN.buscarPorId(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public VacinaAplicada atualizar(@PathParam("id") Long id,
            VacinaAplicada vacinaAplicada){
        vacinaAplicada.setId(id);
        VacinaAplicada vacinaAplicadaAtualizado = vacinaAplicadaRN.atualizar(vacinaAplicada);
        return vacinaAplicadaAtualizado;
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public VacinaAplicada deletar(@PathParam("id") Long id){
        VacinaAplicada vacinaAplicadaDeletado = vacinaAplicadaRN.deletar(id);
        return vacinaAplicadaDeletado;
    }
}
