package ws;

import entity.DoseVacinaAplicada;
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
import rn.DoseVacinaAplicadaRN;
import rn.EapvSofridoRN;
import rn.InsercoesIniciaisRN;
import rn.PacienteRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("doseVacinaAplicada")
public class DoseVacinaAplicadaWS {

    DoseVacinaAplicadaRN doseVacinaAplicadaRN;
    EapvSofridoRN eapvSofridoRN;
    PacienteRN pacienteRN;
    InsercoesIniciaisRN insere;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DoseVacinaAplicadaWS
     */
    public DoseVacinaAplicadaWS() {
        insere = new InsercoesIniciaisRN();
        //insere.escolhaOpcao("dosevacinaaplicada");
        doseVacinaAplicadaRN = new DoseVacinaAplicadaRN();
        //eapvSofridoRN = new EapvSofridoRN();
        //pacienteRN = new PacienteRN();
    
        if(doseVacinaAplicadaRN.listar().isEmpty()){
            //criando doseVacinaAplicada1
            /*List<EapvSofrido> listaEapvSofrido1 = new ArrayList<>();
            listaEapvSofrido1.add(eapvSofridoRN.buscarPorId(Long.valueOf(29))); // 29 = dor, rubor e calor
            doseVacinaAplicadaRN.inserir(new DoseVacinaAplicadaRN(Long.valueOf(1), 
                "05/11/1997", dosevacina,
                pacienteRN.buscarPorId(Long.valueOf(29),
                    Long.valueOf(1), "Vacina Antimeningococica C", 4, listaDoenca1) ); 
            */
           // preciso criar os RN e WS de doseVacina...
           // preciso cadastrar todas as doseVacina que existirao, antes desta etapa...
           
        }
    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoseVacinaAplicada> getDoseVacinaAplicadas() {
        return (doseVacinaAplicadaRN.listar());

    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoseVacinaAplicada() {
        List<DoseVacinaAplicada> doseVacinaAplicada = doseVacinaAplicadaRN.listar();
        return Response.ok()
                .entity(doseVacinaAplicada)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DoseVacinaAplicada adicionar(DoseVacinaAplicada doseVacinaAplicada,
            @Context HttpServletResponse response) {

        doseVacinaAplicadaRN.inserir(doseVacinaAplicada);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return doseVacinaAplicada;
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionar(DoseVacinaAplicada doseVacinaAplicada,
            @Context HttpServletResponse response) {

        doseVacinaAplicadaRN.inserir(doseVacinaAplicada);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return Response.ok()
                .entity(doseVacinaAplicada)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST")
                .allow("OPTIONS").build();
    }

    /*@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DoseVacinaAplicada getDoseVacinaAplicadaPorId(@PathParam("id") Long id) {
        return doseVacinaAplicadaRN.buscarPorId(id);
    }*/
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getdoseVacinaAplicadaPorId(@PathParam("id") Long id) {
        DoseVacinaAplicada doseVacinaAplicada = doseVacinaAplicadaRN.buscarPorId(id);
        
        return Response.ok()
                .entity(doseVacinaAplicada)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS").build();
    }

    /*@PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DoseVacinaAplicada atualizar(@PathParam("id") Long id,
            DoseVacinaAplicada doseVacinaAplicada){
        doseVacinaAplicada.setId(id);
        DoseVacinaAplicada doseDoseVacinaAplicadaAtualizado = doseVacinaAplicadaRN.atualizar(doseVacinaAplicada);
        return doseDoseVacinaAplicadaAtualizado;
    }*/
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id, DoseVacinaAplicada doseVacinaAplicada){
        doseVacinaAplicada.setId(id);
        DoseVacinaAplicada doseVacinaAplicadaAtualizado = doseVacinaAplicadaRN.atualizar(doseVacinaAplicada);
        
        return Response.ok()
                .entity(doseVacinaAplicadaAtualizado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "PUT")
                .allow("OPTIONS").build();
    }
    
    /*@DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DoseVacinaAplicada deletar(@PathParam("id") Long id){
        DoseVacinaAplicada doseVacinaAplicadaDeletado = doseVacinaAplicadaRN.deletar(id);
        return doseVacinaAplicadaDeletado;
    }*/
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") Long id){
        DoseVacinaAplicada doseVacinaAplicadaDeletado = doseVacinaAplicadaRN.deletar(id);
        
        return Response.ok()
                .entity(doseVacinaAplicadaDeletado)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "DELETE")
                .allow("OPTIONS").build();
    }
}
