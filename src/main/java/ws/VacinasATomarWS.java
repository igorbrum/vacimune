package ws;

import entity.DoseVacina;
import entity.DoseVacinaAplicada;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rn.SituacaoVacinalRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("vacinasATomar")
public class VacinasATomarWS {

    SituacaoVacinalRN situacaoVacinalRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EapvWS
     */
    public VacinasATomarWS() {
        situacaoVacinalRN = new SituacaoVacinalRN();
    }
    
    
    /*@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoseVacina> getVacinasATomar(@PathParam("id") Long id) { // idPaciente, no caso
        List<DoseVacinaAplicada> dosesTomadas = situacaoVacinalRN.getVacinasTomadas(id); 
        List<DoseVacina> dosesATomar = situacaoVacinalRN.getVacinasATomar(dosesTomadas);
        return dosesATomar;
    }*/
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacinasATomar(@PathParam("id") Long id) { // idPaciente, no caso
        List<DoseVacinaAplicada> dosesTomadas = situacaoVacinalRN.getVacinasTomadas(id); 
        List<DoseVacina> dosesATomar = situacaoVacinalRN.getVacinasATomar(dosesTomadas);
        return Response.ok()
                .entity(dosesATomar)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

}
