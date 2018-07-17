package ws;

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
@Path("vacinasTomadas")
public class VacinasTomadasWS {

    SituacaoVacinalRN situacaoVacinalRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EapvWS
     */
    public VacinasTomadasWS() {
        situacaoVacinalRN = new SituacaoVacinalRN();
    }
    
    
    /*@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoseVacinaAplicada> getVacinasTomadas(@PathParam("id") Long id) { // idPaciente, no caso
        List<DoseVacinaAplicada> dosesTomadas = situacaoVacinalRN.getVacinasTomadas(id); 
        return dosesTomadas;
    }*/
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacinasTomadas(@PathParam("id") Long id) { // idPaciente, no caso
        List<DoseVacinaAplicada> dosesTomadas = situacaoVacinalRN.getVacinasTomadas(id); 
        return Response.ok()
                .entity(dosesTomadas)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

}
