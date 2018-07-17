package ws;


import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import rn.SituacaoVacinalRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("situacaoVacinal")
public class SituacaoVacinalWS {

    SituacaoVacinalRN situacaoVacinalRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EapvWS
     */
    public SituacaoVacinalWS() {
        situacaoVacinalRN = new SituacaoVacinalRN();
    }
   
    
    @GET
    @Path("/{id1}/{id2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPessoasVacinadasStatus(@PathParam("id1") Long id1, @PathParam("id2") Long id2) {
        JSONObject jsonObject;
        jsonObject = situacaoVacinalRN.verificaPessoasVacinadas(id1, id2); //id1 eh do eapv, id2 eh da vacina
        
                
        return Response.status(200).entity(jsonObject.toString()).build();
    }
    
}
