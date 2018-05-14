package ws;

import entity.Vacina;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import rn.VacinaRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("vacina")
public class VacinaWS {

    VacinaRN vacinaRN;
    //DoencaRN doencaRN;
    //private static int autoIncr = 1;
    
    @Context
    private UriInfo context;
    
    
    /**
     * Creates a new instance of VacinaWS
     */
    public VacinaWS() {
        vacinaRN = new VacinaRN();
        
        // Como adicionar vacina que contem uma doenca? Deve verificar se a doenca jah esta contida... 
        //se estiver, usa ela, senao, cria...
        //if(vacinaRN.listar().isEmpty()){
            //vacinaRN.inserir(new Vacina(Long.valueOf(1), "Antimeningococica", 3, (List<Doenca>) doencaRN.buscarPorId(Long.valueOf(8))) );        
        //}

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vacina> getVacinas() {
        return (vacinaRN.listar());

    }
    
    
    //--NOVO!!
    //@GET //para buscar por nome
    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vacina> getVacinas(@QueryParam("nome") String nome) {
        List<Vacina> listaVacinasBusca = new ArrayList<>();
        for(Vacina p: getVacinas()){
            if(p.getNome().contains(nome)){
                listaVacinasBusca.add(p);
            }
        }
        if(listaVacinasBusca.isEmpty())
            throw new NotFoundException();
        else
            return listaVacinasBusca;
    } 
    //--
    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vacina adicionar(Vacina vacina,
            @Context HttpServletResponse response) {

        vacinaRN.inserir(vacina);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return vacina;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vacina getVacinaPorId(@PathParam("id") Long id) {
        return vacinaRN.buscarPorId(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vacina atualizar(@PathParam("id") Long id,
            Vacina vacina){
        vacina.setId(id);
        Vacina vacinaAtualizado = vacinaRN.atualizar(vacina);
        return vacinaAtualizado;
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vacina deletar(@PathParam("id") Long id){
        Vacina vacinaDeletado = vacinaRN.deletar(id);
        return vacinaDeletado;
    }
}
