package ws;

import com.ibm.watson.developer_cloud.conversation.v1.model.OutputData;
import entity.Watson;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import rn.WatsonRN;

/**
 * REST Web Service
 *
 * @author ibrum
 */
@Path("chat")
public class WatsonWS {

    WatsonRN watsonRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WatsonWS
     */
    public WatsonWS() {
        this.watsonRN = new WatsonRN();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OutputData send(Watson watson){
        OutputData resposta = watsonRN.sendMessage(watson);
        return resposta;
    }
}
