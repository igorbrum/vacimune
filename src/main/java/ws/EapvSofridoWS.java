package ws;

import entity.EapvSofrido;
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
import rn.EapvSofridoRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("eapvSofrido")
public class EapvSofridoWS {

    EapvSofridoRN eapvSofridoRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EapvSofridoWS
     */
    public EapvSofridoWS() {
        eapvSofridoRN = new EapvSofridoRN();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EapvSofrido> getEapvSofridos() {
        return (eapvSofridoRN.listar());

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EapvSofrido adicionar(EapvSofrido eapvSofrido,
            @Context HttpServletResponse response) {

        eapvSofridoRN.inserir(eapvSofrido);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return eapvSofrido;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EapvSofrido getEapvSofridoPorId(@PathParam("id") Long id) {
        return eapvSofridoRN.buscarPorId(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EapvSofrido atualizar(@PathParam("id") Long id,
            EapvSofrido eapvSofrido){
        eapvSofrido.setId(id);
        EapvSofrido eapvSofridoAtualizado = eapvSofridoRN.atualizar(eapvSofrido);
        return eapvSofridoAtualizado;
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EapvSofrido deletar(@PathParam("id") Long id){
        EapvSofrido eapvSofridoDeletado = eapvSofridoRN.deletar(id);
        return eapvSofridoDeletado;
    }
}
