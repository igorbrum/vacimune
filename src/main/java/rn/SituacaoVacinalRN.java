package rn;

import entity.DoseVacina;
import entity.DoseVacinaAplicada;
import entity.Eapv;
import entity.EapvSofrido;
import entity.Paciente;
import entity.Vacina;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import org.json.JSONObject;

import util.JPAUtil;

/**
 * REST Web Service
 *
 * @author 631610042
 */

public class SituacaoVacinalRN {

    PacienteRN pacienteRN;
    DoencaRN doencaRN;
    EapvRN eapvRN;
    VacinaRN vacinaRN;
    DoseVacinaRN doseVacinaRN;
    DoseVacinaAplicadaRN doseVacinaAplicadaRN;
    EapvSofridoRN eapvSofridoRN;

    
    public SituacaoVacinalRN() {
        
        pacienteRN = new PacienteRN();
        doencaRN = new DoencaRN();
        eapvRN = new EapvRN();
        vacinaRN = new VacinaRN();
        doseVacinaRN = new DoseVacinaRN();
        doseVacinaAplicadaRN = new DoseVacinaAplicadaRN();
        eapvSofridoRN = new EapvSofridoRN();
        
    }
    
    //##########################################################################
    //UTILIDADE 1 - LISTAR VACINAS TOMADAS E VACINAS A TOMAR
    
    //Metodo para retornar vacinas jah aplicadas pelo paciente com id = idPaciente
    public List<DoseVacinaAplicada> getVacinasTomadas(Long idPaciente){
        //Long id = Long.valueOf(idPaciente);
        Paciente pac = pacienteRN.buscarPorId(idPaciente);
        List<DoseVacinaAplicada> doses = dosesPaciente(pac);
        //System.out.println("Vacinas tomadas: IDs");
        //for(DoseVacinaAplicada dosVacApl:doses){
        //System.out.println(dosVacApl.getId());
        //}
        return doses;
    }
        
    //Metodo para retornar vacinas a tomar, recebendo lista de vacinas aplicadas (getVacinasTomadas) como parametro
    public List<DoseVacina> getVacinasATomar(List<DoseVacinaAplicada> doses){
        //das vacinas que temos, considerar tetra equivalente a penta
        List<DoseVacina> listaDosesExistentes = doseVacinaRN.listar();
        List<DoseVacina> listaDosesATomar = new ArrayList<>();
        
        for(DoseVacina d:listaDosesExistentes){
            for(DoseVacinaAplicada dA:doses){
                if(!d.getId().equals(dA.getDoseVacina().getId())){
                    if(!d.getVacina().getId().equals(Long.valueOf(10))) // vacina tetravalente nao eh pedida, pois eh vacina antiga
                    listaDosesATomar.add(d);
                }
            }
        }
        return listaDosesATomar;
    }
    
    //Metodo auxiliar
    private List<DoseVacinaAplicada> dosesPaciente(Paciente paciente) {
        //EntityManager manager = JPAUtil.createManager();
        
        List<DoseVacinaAplicada> listaDosesVacinasAplicadas = doseVacinaAplicadaRN.listar();
        List<DoseVacinaAplicada> listaDosesVacinasAplicadasPaciente = new ArrayList<>();
        
        for(DoseVacinaAplicada dosVacApl:listaDosesVacinasAplicadas){
           // if(paciente.getId().equals(dosVacApl.getPaciente().getId()))
                listaDosesVacinasAplicadasPaciente.add(dosVacApl);
        }
        
        //DoseVacinaAplicada doseVacinaAplicada = manager.find(DoseVacinaAplicada.class, paciente);
        //Verificacao de id
        //manager.close();
        return listaDosesVacinasAplicadasPaciente;
    }
    //FIM DO UTILIDADE 1
    //##########################################################################
    
    //##########################################################################
    //UTILIDADE 2 - ESTATISTICAS DA BASE - CONTAGEM DE PESSOAS VACINADAS QUE SOFRERAM (OU NAO) EAPV, POR VACINA E POR EAPV
    //Ou seja, retornar:
    //a.Contagem de pessoas que tomaram vacina (BASE TODA);
    //b.Contagem de pessoas que tomaram determinada vacina;
    //c.Contagem de pessoas que sofreram EAPV (BASE TODA);
    //d.Contagem de pessoas que sofreram determinado EAPV;
    //e.Contagem de pessoas que sofreram algum EAPV, apos determinada vacina;
    //f.Contagem de pessoas que sofreram determinado EAPV, apos determinada vacina;
    
    //a.Contagem de pessoas que tomaram vacina (BASE TODA);
    public int numPessoasVacinadas(){ 
        List<DoseVacinaAplicada> listaDosesVacinasAplicadas = doseVacinaAplicadaRN.listar();
        List<Paciente> pacientes = new ArrayList<>();
        List<String> idsPacientes = new ArrayList<>();
        
        for(DoseVacinaAplicada dosVacApl:listaDosesVacinasAplicadas){
            pacientes.add(dosVacApl.getPaciente());
        }

        for(Paciente pac:pacientes){
            idsPacientes.add(String.valueOf(pac.getId()));
        }
        
        Long n = idsPacientes.stream().distinct().count();
        int numPessoasVacinadas = n.intValue();
        
        return numPessoasVacinadas;
    }
    
    //b.Contagem de pessoas que tomaram determinada vacina;
    // input objeto:
    public int numPessoasVacinadas(Vacina vacina){
        List<DoseVacinaAplicada> listaDosesVacinasAplicadas = doseVacinaAplicadaRN.listar();
        List<Paciente> pacientes = new ArrayList<>();
        List<String> idsPacientes = new ArrayList<>();
        
        for(DoseVacinaAplicada dosVacApl:listaDosesVacinasAplicadas){
            if(Objects.equals(dosVacApl.getDoseVacina().getVacina().getId(), vacina.getId())){
                pacientes.add(dosVacApl.getPaciente());
            }
        }
        
        for(Paciente pac:pacientes){
            idsPacientes.add(String.valueOf(pac.getId()));
        }
        
        Long n = idsPacientes.stream().distinct().count();
        int numPessoasVacinadas = n.intValue();
        
        return numPessoasVacinadas;
    }
    // input Long id:
    public int numPessoasVacinadas(Long idVacina){
        List<DoseVacinaAplicada> listaDosesVacinasAplicadas = doseVacinaAplicadaRN.listar();
        List<Paciente> pacientes = new ArrayList<>();
        List<String> idsPacientes = new ArrayList<>();
        
        for(DoseVacinaAplicada dosVacApl:listaDosesVacinasAplicadas){
            //if(Objects.equals(dosVacApl.getDoseVacina().getVacina().getId(), idVacina)){
                pacientes.add(dosVacApl.getPaciente());
            //}
        }
        
        for(Paciente pac:pacientes){
            idsPacientes.add(String.valueOf(pac.getId()));
        }
        
        Long n = idsPacientes.stream().distinct().count();
        int numPessoasVacinadas = n.intValue();
        
        return numPessoasVacinadas;
    }
    
    //f.Contagem de pessoas que sofreram o EAPV = x, para a Vacina = y;
    // input objeto
    public int numPessoasSofreramEAPV(Vacina vacina, Eapv eapv){
        List<DoseVacinaAplicada> listaDosesVacinasAplicadas = doseVacinaAplicadaRN.listar();
        List<Paciente> pacientes = new ArrayList<>();
        List<String> idsPacientes = new ArrayList<>();
        
        for(DoseVacinaAplicada dosVacApl:listaDosesVacinasAplicadas){
            if(dosVacApl.getDoseVacina().getVacina().getId() == vacina.getId()){
                List<EapvSofrido> listaEapvSofrido = dosVacApl.getEapvSofrido();
                List<Eapv> listaEapvs = new ArrayList<>();
                for(EapvSofrido e:listaEapvSofrido){
                    listaEapvs.add(e.getEapv());
                }
                if(listaEapvs.contains(eapv)){
                    pacientes.add(dosVacApl.getPaciente());
                }
            }
        }
        
        for(Paciente pac:pacientes){
            idsPacientes.add(String.valueOf(pac.getId()));
        }
        
        Long n = idsPacientes.stream().distinct().count();
        int numPessoasSofreramEAPV = n.intValue();
        
        return numPessoasSofreramEAPV;
    }
    // input Long Ids
    public int numPessoasSofreramEAPV(Long idVacina, Long idEapv){
        List<DoseVacinaAplicada> listaDosesVacinasAplicadas = doseVacinaAplicadaRN.listar();
        List<Paciente> pacientes = new ArrayList<>();
        List<String> idsPacientes = new ArrayList<>();
        
        for(DoseVacinaAplicada dosVacApl:listaDosesVacinasAplicadas){
            if(Objects.equals(dosVacApl.getDoseVacina().getVacina().getId(), idVacina)){
                List<EapvSofrido> listaEapvSofrido = dosVacApl.getEapvSofrido();
                List<Long> listaIdEapvs = new ArrayList<>();
                for(EapvSofrido e:listaEapvSofrido){
                    listaIdEapvs.add(e.getEapv().getId());
                }
                if(listaIdEapvs.contains(idEapv)){
                    pacientes.add(dosVacApl.getPaciente());
                }
            }
        }
        
        for(Paciente pac:pacientes){
            idsPacientes.add(String.valueOf(pac.getId()));
        }
        
        Long n = idsPacientes.stream().distinct().count();
        int numPessoasSofreramEAPV = n.intValue();
        
        return numPessoasSofreramEAPV;
    }
    
    // input objeto
    public JSONObject verificaPessoasVacinadas(Eapv eapv, Vacina vacina){
        JSONObject jsonObject = new JSONObject();
             
        int totalPessoasVacinadas = numPessoasVacinadas(vacina);
        int totalPessoasEAPV = numPessoasSofreramEAPV(vacina, eapv);
        int totalPessoasSemEapv = totalPessoasVacinadas - totalPessoasEAPV;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("TotalPessoasVacinadas", totalPessoasVacinadas);
        jsonObject.put("TotalPessoasEapv", totalPessoasEAPV);
        jsonObject.put("TotalPessoasSemEapv", totalPessoasSemEapv);
        return jsonObject;
    }
    // input Long ids
    public JSONObject verificaPessoasVacinadas(Long idEapv, Long idVacina){
        JSONObject jsonObject = new JSONObject();
             
        int totalPessoasVacinadas = numPessoasVacinadas(idVacina);
        int totalPessoasEAPV = numPessoasSofreramEAPV(idVacina, idEapv);
        int totalPessoasSemEapv = totalPessoasVacinadas - totalPessoasEAPV;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("TotalPessoasVacinadas", totalPessoasVacinadas);
        jsonObject.put("TotalPessoasEapv", totalPessoasEAPV);
        jsonObject.put("TotalPessoasSemEapv", totalPessoasSemEapv);
        return jsonObject;
    }
    //FIM DO UTILIDADE 2
    //##########################################################################
    
}

// Falta imprimir doses vacinais a tomar. Recebe ID do paciente e cria uma lista de doses tomadas e a tomar. Ok
// Na hora de imprimir a lista, devolve se já deveria ter tomado a dose a tanto tempo, se deve tomar a dose daqui a quanto tempo e 
// se já tomou a dose. (A ser feito no Front-End, colocando em formato tabular, talvez)
// Ordena tudo isso pela data de aplicacao proposta. (Front-End)
// Imprime mensagem de Dose tomada em xx/xx/xxxx, ou 
// Dose deveria ter sido tomada em xx/xx/xxxx (vacina a tomar!), ou
// Dose deve ser tomada em xx/xx/xxxx. (Front-End)

/*{
	"eapv": {
                "id": 10,
                "nome": "Febre - temperatura axilar >= 39,5 graus C"
    },
	"vacina": {
                "doenca": [
                    {
                        "id": 6,
                        "nome": "Hepatite B"
                    }
                ],
                "id": 4,
                "nome": "Vacina contra hepatite B",
                "numeroDeDoses": 4
    }
}*/