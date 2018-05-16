package ws;

import entity.Eapv;
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
import rn.EapvRN;

/**
 * REST Web Service
 *
 * @author 631610042
 */
@Path("eapv")
public class EapvWS {

    EapvRN eapvRN;
    Eapv eapv;
    //private static int autoIncr = 1;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EapvWS
     */
    public EapvWS() {
        eapvRN = new EapvRN();
        if(eapvRN.listar().isEmpty()){
            // Fonte: pni.datasus.gov.br/Download/Eapv/Ficha_eventos_adversos.doc
            // Segui os codigos oficiais do Ministerio da Saude para os EAPV
            //eapvRN.inserir(new Eapv(Long.valueOf(autoIncr++),"Abscesso local frio"));
            eapvRN.inserir(new Eapv(Long.valueOf(3),"Abscesso local frio"));
            eapvRN.inserir(new Eapv(Long.valueOf(2),"Abscesso local quente"));
            eapvRN.inserir(new Eapv(Long.valueOf(59),"Angioedema"));
            eapvRN.inserir(new Eapv(Long.valueOf(60),"Apneia"));
            eapvRN.inserir(new Eapv(Long.valueOf(23),"Artrite"));
            eapvRN.inserir(new Eapv(Long.valueOf(45),"Artrite"));
            eapvRN.inserir(new Eapv(Long.valueOf(68),"Boncoespasmo/Laringoespasmo"));
            eapvRN.inserir(new Eapv(Long.valueOf(28),"Choque Anafilatico/Anafilactoide"));
            eapvRN.inserir(new Eapv(Long.valueOf(72),"Choro persistente"));
            eapvRN.inserir(new Eapv(Long.valueOf(12),"Convulsao afebril"));
            eapvRN.inserir(new Eapv(Long.valueOf(11),"Convulsao febril"));
            eapvRN.inserir(new Eapv(Long.valueOf(52),"Dificuldade de deambular (caminhar)")); //notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(65),"Doenca do soro"));
            eapvRN.inserir(new Eapv(Long.valueOf(24),"Doenca vicerotropica aguda apos vacina contra FA"));
            eapvRN.inserir(new Eapv(Long.valueOf(29),"Dor, rubor e calor (no local da aplicacao)")); //notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(35),"Encefalite"));
            eapvRN.inserir(new Eapv(Long.valueOf(36),"Encefalopatia aguda"));
            eapvRN.inserir(new Eapv(Long.valueOf(69),"Encefalomielite disseminada aguda (ADEM)"));
            eapvRN.inserir(new Eapv(Long.valueOf(9),"Enduracao (no local da aplicacao)")); //notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(13),"Episodio Hipotonico-Hiporresponsivo"));
            eapvRN.inserir(new Eapv(Long.valueOf(17),"Exantema generalizado"));
            eapvRN.inserir(new Eapv(Long.valueOf(10),"Febre - temperatura axilar >= 39,5 graus C"));
            eapvRN.inserir(new Eapv(Long.valueOf(25),"Febre - temperatura axilar < 39,5 graus C")); //notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(58),"Granuloma (caroco no local da aplicacao)")); //notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(56),"Ictericia")); //notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(61),"Invaginacao intestinal (intussuscepcao)"));
            eapvRN.inserir(new Eapv(Long.valueOf(41),"Lesoes generalizadas (dec. de dis. de BCG)")); //notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(70),"Lesoes localizadas dec. de dis. do BCG"));
            eapvRN.inserir(new Eapv(Long.valueOf(71),"Lesoes localizadas dec. de dis. do BCG (acometendo mais de um orgao)"));
            eapvRN.inserir(new Eapv(Long.valueOf(6),"Linfadenite não supurada > 3cm"));
            eapvRN.inserir(new Eapv(Long.valueOf(5),"Linfadenomegalia > 3cm supurada")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(7),"Linfadenomegalia > 3cm nao supurada")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(8),"Linfadenite supurada"));
            eapvRN.inserir(new Eapv(Long.valueOf(22),"Meningite"));
            eapvRN.inserir(new Eapv(Long.valueOf(53),"Mialgia (dor muscular)")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(42),"Mielite"));
            eapvRN.inserir(new Eapv(Long.valueOf(62),"Neurite braquial"));
            eapvRN.inserir(new Eapv(Long.valueOf(14),"Nodulo (no local da aplicacao)")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(63),"Obito"));
            eapvRN.inserir(new Eapv(Long.valueOf(46),"Orquite"));
            eapvRN.inserir(new Eapv(Long.valueOf(49),"Osteite/osteomielite"));
            eapvRN.inserir(new Eapv(Long.valueOf(1),"Outras reacoes locais")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(16),"Outras paralisias")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(47),"Outros eventos graves e/ou inusitados"));
            eapvRN.inserir(new Eapv(Long.valueOf(64),"Outros eventos neurologicos graves")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(43),"Pancreatite")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(37),"Panencefalite esclerosante subaguda")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(26),"Paralisia dos membros inferiores")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(55),"Paresia")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(15),"Parestesia")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(21),"Parotidite")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(38),"Poliomielite pos-vacinal"));
            eapvRN.inserir(new Eapv(Long.valueOf(48),"Polirradiculoneurite (Sindrome de Guillain-Barre)"));
            //eapvRN.inserir(new Eapv(Long.valueOf(48),"Purpura sem contagem"));
            eapvRN.inserir(new Eapv(Long.valueOf(73),"Purpura nao trombocitopenica"));
            eapvRN.inserir(new Eapv(Long.valueOf(18),"Purpura trombocitopenica"));
            eapvRN.inserir(new Eapv(Long.valueOf(27),"Queloide")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(32),"Reacao de Arthus"));
            eapvRN.inserir(new Eapv(Long.valueOf(51),"Reacao de hipersensibilidade apos 2h")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(20),"Reacao de hipersensibilidade ate 2h")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(66),"Reacoes locais intensas"));
            eapvRN.inserir(new Eapv(Long.valueOf(40),"Sindrome de reacao sistemica precoce")); // notificacao nao obrigatoria
            eapvRN.inserir(new Eapv(Long.valueOf(4),"Ulcera > 1 cm apos BCG"));
            eapvRN.inserir(new Eapv(Long.valueOf(67),"Urticaria generalizada"));
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Eapv> getEapvs() {
        return (eapvRN.listar());

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Eapv adicionar(Eapv eapv,
            @Context HttpServletResponse response) {

        eapvRN.inserir(eapv);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return eapv;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Eapv getEapvPorId(@PathParam("id") Long id) {
        return eapvRN.buscarPorId(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Eapv atualizar(@PathParam("id") Long id,
            Eapv eapv){
        eapv.setId(id);
        Eapv eapvAtualizado = eapvRN.atualizar(eapv);
        return eapvAtualizado;
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Eapv deletar(@PathParam("id") Long id){
        Eapv eapvDeletado = eapvRN.deletar(id);
        return eapvDeletado;
    }
}
