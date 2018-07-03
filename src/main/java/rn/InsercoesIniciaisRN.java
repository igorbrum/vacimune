package rn;

import entity.Doenca;
import entity.DoseVacina;
import entity.DoseVacinaAplicada;
import entity.Eapv;
import entity.EapvSofrido;
import entity.Paciente;
import entity.UnidadeSaude;
import entity.Vacina;
import java.util.ArrayList;
import java.util.List;

/**
 * REST Web Service
 *
 * @author 631610042
 */

public class InsercoesIniciaisRN {

    PacienteRN pacienteRN;
    DoencaRN doencaRN;
    EapvRN eapvRN;
    VacinaRN vacinaRN;
    DoseVacinaRN doseVacinaRN;
    DoseVacinaAplicadaRN doseVacinaAplicadaRN;
    EapvSofridoRN eapvSofridoRN;
    UnidadeSaudeRN unidadeSaudeRN;
    
    /**
     * Creates a new instance of PacienteWS
     */
    public InsercoesIniciaisRN() {
        
    }
    
    public void escolhaOpcao(String opcao){
        switch(opcao){
            case "doenca":
                insertDoenca();
                break;
            case "eapv":
                insertEapv();
                break;
            case "paciente":
                insertPaciente();
                break;
            case "vacina":
                insertVacina();
                break;
            case "dosevacina":
                insertDoseVacina();
                break;
            case "eapvsofrido":
                insertEapvSofrido();
                break;
            case "dosevacinaaplicada":
                insertDoseVacinaAplicada();
                break;
            case "unidadessaude":
                insertUnidadeSaude();
                break;
            default:
                System.out.println("Ops");
        }
    }
    
    private void insertDoenca(){
        doencaRN = new DoencaRN();
        if(doencaRN.listar().isEmpty()){
            doencaRN.inserir(new Doenca(Long.valueOf(1),"Caxumba"));
            doencaRN.inserir(new Doenca(Long.valueOf(2),"Difteria"));
            doencaRN.inserir(new Doenca(Long.valueOf(3),"Febre Amarela"));
            doencaRN.inserir(new Doenca(Long.valueOf(4),"Gripe"));
            doencaRN.inserir(new Doenca(Long.valueOf(5),"Hepatite A")); // ainda nao colocado no watson...
            doencaRN.inserir(new Doenca(Long.valueOf(6),"Hepatite B"));
            doencaRN.inserir(new Doenca(Long.valueOf(7),"Hib (Haemophilus influenzae)"));
            doencaRN.inserir(new Doenca(Long.valueOf(8),"HPV"));
            doencaRN.inserir(new Doenca(Long.valueOf(9),"Meningite"));
            doencaRN.inserir(new Doenca(Long.valueOf(10),"Pertussis (Coqueluche)"));
            doencaRN.inserir(new Doenca(Long.valueOf(11),"Pneumonia"));
            doencaRN.inserir(new Doenca(Long.valueOf(12),"Poliomielite"));
            doencaRN.inserir(new Doenca(Long.valueOf(13),"Rotavirus"));
            doencaRN.inserir(new Doenca(Long.valueOf(14),"Rubeola"));
            doencaRN.inserir(new Doenca(Long.valueOf(15),"Sarampo"));
            doencaRN.inserir(new Doenca(Long.valueOf(16),"Tetano"));
            doencaRN.inserir(new Doenca(Long.valueOf(17),"Tuberculose (BCG)"));
            doencaRN.inserir(new Doenca(Long.valueOf(18),"Otite"));
            doencaRN.inserir(new Doenca(Long.valueOf(19),"Sinusite"));
            doencaRN.inserir(new Doenca(Long.valueOf(20),"Catapora (sinonimo de Varicela)"));
        }
    }
    
    private void insertEapv(){
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
    
    private void insertPaciente(){
        pacienteRN = new PacienteRN();
        if(pacienteRN.listar().isEmpty()){
            pacienteRN.inserir(new Paciente(Long.valueOf(1), Long.parseLong("12345678911"), "Marcelino Pao e Vinho", "01/01/1991", "paoevinho@hotmail.com"));
            pacienteRN.inserir(new Paciente(Long.valueOf(2), Long.parseLong("99999999999"), "Aristides Bergamota", "04/11/1991", "bergamota@hotmail.com"));
            pacienteRN.inserir(new Paciente(Long.valueOf(3), Long.parseLong("2987898091"), "Claudete da Silva", "03/03/1977", "claudete777@hotmail.com"));
        }
    }
    
    private void insertVacina(){
        vacinaRN = new VacinaRN();
        if(vacinaRN.listar().isEmpty()){
            //criando vacina Antimeningococica
            List<Doenca> listaDoenca1 = new ArrayList<>();
            listaDoenca1.add(doencaRN.buscarPorId(Long.valueOf(9)));
            vacinaRN.inserir(new Vacina(Long.valueOf(1), "Vacina Antimeningococica C", 4, listaDoenca1) ); 
            //criando vacina contra febre amarela:
            List<Doenca> listaDoenca2 = new ArrayList<>();
            listaDoenca2.add(doencaRN.buscarPorId(Long.valueOf(3)));
            vacinaRN.inserir(new Vacina(Long.valueOf(2), "Vacina contra febre amarela", 2, listaDoenca2) ); 
            //criando vacina BCG:
            List<Doenca> listaDoenca3 = new ArrayList<>();
            listaDoenca3.add(doencaRN.buscarPorId(Long.valueOf(17)));
            vacinaRN.inserir(new Vacina(Long.valueOf(3), "Vacina BCG", 1, listaDoenca3) );
            //criando vacina HB:
            List<Doenca> listaDoenca4 = new ArrayList<>();
            listaDoenca4.add(doencaRN.buscarPorId(Long.valueOf(6)));
            vacinaRN.inserir(new Vacina(Long.valueOf(4), "Vacina contra hepatite B", 4, listaDoenca4) );
            //criando vacina SCR:
            List<Doenca> listaDoenca5 = new ArrayList<>();
            listaDoenca5.add(doencaRN.buscarPorId(Long.valueOf(15)));
            listaDoenca5.add(doencaRN.buscarPorId(Long.valueOf(1)));
            listaDoenca5.add(doencaRN.buscarPorId(Long.valueOf(14)));
            vacinaRN.inserir(new Vacina(Long.valueOf(5), "Vacina SCR (sarampo, caxumba e rubeola) - triplice viral", 2, listaDoenca5) );
            //criando vacina VORH:
            List<Doenca> listaDoenca6 = new ArrayList<>();
            listaDoenca6.add(doencaRN.buscarPorId(Long.valueOf(13)));
            vacinaRN.inserir(new Vacina(Long.valueOf(6), "Vacina VORH (oral contra rotavirus humano)", 2, listaDoenca6) );
            //criando vacina VIP:
            List<Doenca> listaDoenca7 = new ArrayList<>();
            listaDoenca7.add(doencaRN.buscarPorId(Long.valueOf(12)));
            vacinaRN.inserir(new Vacina(Long.valueOf(7), "Vacina VIP (inativa contra poliomielite)", 3, listaDoenca7) );
            //criando vacina VOP:
            List<Doenca> listaDoenca8 = new ArrayList<>();
            listaDoenca8.add(doencaRN.buscarPorId(Long.valueOf(12)));
            vacinaRN.inserir(new Vacina(Long.valueOf(8), "Vacina VOP (oral contra poliomielite)", 2, listaDoenca8) );
            //criando vacina Pentavalente(DTP+Hib+HB):
            List<Doenca> listaDoenca9 = new ArrayList<>();
            listaDoenca9.add(doencaRN.buscarPorId(Long.valueOf(2)));
            listaDoenca9.add(doencaRN.buscarPorId(Long.valueOf(16)));
            listaDoenca9.add(doencaRN.buscarPorId(Long.valueOf(10)));
            listaDoenca9.add(doencaRN.buscarPorId(Long.valueOf(7)));
            listaDoenca9.add(doencaRN.buscarPorId(Long.valueOf(6)));
            vacinaRN.inserir(new Vacina(Long.valueOf(9), "Vacina Pentavalente (DTP+Hib+HB)", 3, listaDoenca9) );
            //criando vacina Tetravalente (DTP+Hib):
            List<Doenca> listaDoenca10 = new ArrayList<>();
            listaDoenca10.add(doencaRN.buscarPorId(Long.valueOf(2)));
            listaDoenca10.add(doencaRN.buscarPorId(Long.valueOf(16)));
            listaDoenca10.add(doencaRN.buscarPorId(Long.valueOf(10)));
            listaDoenca10.add(doencaRN.buscarPorId(Long.valueOf(7)));
            vacinaRN.inserir(new Vacina(Long.valueOf(10), "Vacina Tetravalente (DTP+Hib)", 3, listaDoenca10) );
            //criando vacina Pneumococica 10 Valente:
            List<Doenca> listaDoenca11 = new ArrayList<>();
            listaDoenca11.add(doencaRN.buscarPorId(Long.valueOf(11)));
            listaDoenca11.add(doencaRN.buscarPorId(Long.valueOf(9)));
            listaDoenca11.add(doencaRN.buscarPorId(Long.valueOf(18)));
            listaDoenca11.add(doencaRN.buscarPorId(Long.valueOf(19)));
            vacinaRN.inserir(new Vacina(Long.valueOf(11), "Vacina Pneumococica 10 Valente", 3, listaDoenca11) );
            /*//criando vacina Antimeningococica C:
            List<Doenca> listaDoenca12 = new ArrayList<>();
            listaDoenca12.add(doencaRN.buscarPorId(Long.valueOf(9)));
            vacinaRN.inserir(new Vacina(Long.valueOf(12), "Vacina Antimeningococica C", 4, listaDoenca12) ); ja criada
            */
            //criando vacina HA:
            List<Doenca> listaDoenca13 = new ArrayList<>();
            listaDoenca13.add(doencaRN.buscarPorId(Long.valueOf(5)));
            vacinaRN.inserir(new Vacina(Long.valueOf(12), "Vacina contra hepatite A", 1, listaDoenca13) );
            //criando vacina SCRC:
            List<Doenca> listaDoenca14 = new ArrayList<>();
            listaDoenca14.add(doencaRN.buscarPorId(Long.valueOf(15)));
            listaDoenca14.add(doencaRN.buscarPorId(Long.valueOf(1)));
            listaDoenca14.add(doencaRN.buscarPorId(Long.valueOf(14)));
            listaDoenca14.add(doencaRN.buscarPorId(Long.valueOf(20)));
            vacinaRN.inserir(new Vacina(Long.valueOf(13), "Vacina SCRC (sarampo, caxumba, rubeola e catapora) - tetra viral", 1, listaDoenca14) );
            //criando vacina contra catapora (sinonimo de varicela):
            List<Doenca> listaDoenca15 = new ArrayList<>();
            listaDoenca15.add(doencaRN.buscarPorId(Long.valueOf(20)));
            vacinaRN.inserir(new Vacina(Long.valueOf(14), "Vacina contra catapora (sinonimo de varicela)", 1, listaDoenca15) );
            //criando vacina contra HPV:
            List<Doenca> listaDoenca16 = new ArrayList<>();
            listaDoenca16.add(doencaRN.buscarPorId(Long.valueOf(8)));
            vacinaRN.inserir(new Vacina(Long.valueOf(15), "Vacina contra HPV", 2, listaDoenca16) );
            //criando vacina contra difteria e tetano (dT) - dupla adulto:
            List<Doenca> listaDoenca17 = new ArrayList<>();
            listaDoenca17.add(doencaRN.buscarPorId(Long.valueOf(2)));
            listaDoenca17.add(doencaRN.buscarPorId(Long.valueOf(16)));
            vacinaRN.inserir(new Vacina(Long.valueOf(16), "Vacina contra difteria e tetano (dT) - dupla adulto", 3, listaDoenca17) );
            //criando vacina contra difteria, tetano e pertussis acelular (dTpa) - triplice bacteriana adulto:
            List<Doenca> listaDoenca18 = new ArrayList<>();
            listaDoenca18.add(doencaRN.buscarPorId(Long.valueOf(2)));
            listaDoenca18.add(doencaRN.buscarPorId(Long.valueOf(16)));
            listaDoenca18.add(doencaRN.buscarPorId(Long.valueOf(10)));
            vacinaRN.inserir(new Vacina(Long.valueOf(17), "Vacina contra difteria, tetano e pertussis acelular (dTpa) - triplice bacteriana adulto", 1, listaDoenca18) );
        }
    }
    
    private void insertDoseVacina(){
        doseVacinaRN = new DoseVacinaRN();
        if(doseVacinaRN.listar().isEmpty()){
            //criar todas doseVacina1 possiveis
            VacinaRN vacinaRN = new VacinaRN();
            List<Vacina> listaVacinas = vacinaRN.listar();
            int k = 1;
            int idadeAplicacaoMes;
            for(Vacina vac: listaVacinas){
                for(int j = 1; j <= vac.getNumeroDeDoses(); j++){
                    idadeAplicacaoMes = defineIdadeAplicacaoMes(vac, j);
                    doseVacinaRN.inserir(new DoseVacina(Long.valueOf(k), "Dose "+j+" - Vacina "+vac.getNome(), idadeAplicacaoMes, vac));
                    k++;
                }
            }
        }
    }
    
    private void insertEapvSofrido(){
        eapvSofridoRN = new EapvSofridoRN();
        if(eapvSofridoRN.listar().isEmpty()){
            //criar eapvSofrido hipoteticos
            eapvSofridoRN.inserir(new EapvSofrido(Long.valueOf(1), eapvRN.buscarPorId(Long.valueOf(29)))); // dor, rubor e calor
            eapvSofridoRN.inserir(new EapvSofrido(Long.valueOf(2), eapvRN.buscarPorId(Long.valueOf(10)))); // febre >= 39
        }
    }
    
    private void insertDoseVacinaAplicada(){
        doseVacinaAplicadaRN = new DoseVacinaAplicadaRN();
        if(doseVacinaAplicadaRN.listar().isEmpty()){
            //criando doseVacinaAplicada1
            // Claudete - id = 3, tomou a vacina contra hepatite B, ao nascer (1a dose - id=8), e teve febre >= 39
            List<EapvSofrido> listaEapvSofrido1 = new ArrayList<>();
            listaEapvSofrido1.add(eapvSofridoRN.buscarPorId(Long.valueOf(2))); // 2 = febre >= 39
            doseVacinaAplicadaRN.inserir(new DoseVacinaAplicada(Long.valueOf(1), 
                "03/03/1977", doseVacinaRN.buscarPorId(Long.valueOf(8)), // 8 = HB, 1a dose
                pacienteRN.buscarPorId(Long.valueOf(3)), // 3 = claudete
                listaEapvSofrido1 )); 
        }
    }
    
    private void insertUnidadeSaude(){
        unidadeSaudeRN = new UnidadeSaudeRN();
        if(unidadeSaudeRN.listar().isEmpty()){
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(1), "Centro de Saude Santa Marta", "(51) 3289-2900", -30.0285033, -51.232530999999994));   
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(2), "Unidade Basica de Saude Santa Cecilia", "(51) 3359-8685", -30.0386913, -51.20532530000003));   
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(3), "Centro de Saude Modelo", "(51) 3359-8685", -30.04321509999999, -51.213823400000024));   
            unidadeSaudeRN.inserir(new UnidadeSaude(Long.valueOf(4), "Pronto Atendimento Bom Jesus", "(51) 3289-5408", -30.04322059999999, -51.153921500000024));
        }
    }    

    private int defineIdadeAplicacaoMes(Vacina vac, int j) {
        int idadeAplicacaoMes = -1;
        if(vac.getId() == Long.valueOf(1)){ //antimeningococica c
            if(j == 1) 
                idadeAplicacaoMes = 3;
            if(j == 2) 
                idadeAplicacaoMes = 5;
            if(j == 3) 
                idadeAplicacaoMes = 12;
            if(j == 4) 
                idadeAplicacaoMes = 10*12;
            }
        if(vac.getId() == Long.valueOf(2)){ //febre amarela
            if(j == 1) 
                idadeAplicacaoMes = 9;
            if(j == 2) 
                idadeAplicacaoMes = 10*12;
        }
        if(vac.getId() == Long.valueOf(3)){ //BCG
            if(j == 1) 
                idadeAplicacaoMes = 0;
        }
        if(vac.getId() == Long.valueOf(4)){ //HB 
            if(j == 1) 
                idadeAplicacaoMes = 0;
            if(j == 2) 
                idadeAplicacaoMes = 10*12;
            if(j == 3) 
                idadeAplicacaoMes = 10*12 + 1;
            if(j == 4) 
                idadeAplicacaoMes = 10*12 + (180/12);
        }
        if(vac.getId() == Long.valueOf(5)){ //SCR
            if(j == 1) 
                idadeAplicacaoMes = 12;
            if(j == 2) 
                idadeAplicacaoMes = 10*12;
        }
        if(vac.getId() == Long.valueOf(6)){ //VORH
            if(j == 1) 
                idadeAplicacaoMes = 2;
            if(j == 2) 
                idadeAplicacaoMes = 4;
        }
        if(vac.getId() == Long.valueOf(7)){ //VIP
            if(j == 1) 
                idadeAplicacaoMes = 2;
            if(j == 2) 
                idadeAplicacaoMes = 4;
            if(j == 3) 
                idadeAplicacaoMes = 6;
        }
        if(vac.getId() == Long.valueOf(8)){ //VOP
            if(j == 1) 
                idadeAplicacaoMes = 15;
            if(j == 2) 
                idadeAplicacaoMes = 4*12;
        }
        if(vac.getId() == Long.valueOf(9)){ //Penta
            if(j == 1) 
                idadeAplicacaoMes = 2;
            if(j == 2) 
                idadeAplicacaoMes = 4;
            if(j == 3) 
                idadeAplicacaoMes = 6;
        }
        if(vac.getId() == Long.valueOf(10)){ //Tetra - substituida pela penta, no plano vacinal
            if(j == 1) 
                idadeAplicacaoMes = 2;
            if(j == 2) 
                idadeAplicacaoMes = 4;
            if(j == 3) 
                idadeAplicacaoMes = 6;
        }
        if(vac.getId() == Long.valueOf(11)){ //pneumococica
            if(j == 1) 
                idadeAplicacaoMes = 2;
            if(j == 2) 
                idadeAplicacaoMes = 4;
            if(j == 3) 
                idadeAplicacaoMes = 12;
        }
        if(vac.getId() == Long.valueOf(12)){ //HA
            if(j == 1) 
                idadeAplicacaoMes = 15;
        }
        if(vac.getId() == Long.valueOf(13)){ //SCRC
            if(j == 1) 
                idadeAplicacaoMes = 15;
        }
        if(vac.getId() == Long.valueOf(14)){ //varicela/catapora
            if(j == 1) 
                idadeAplicacaoMes = 4*12;
        }
        if(vac.getId() == Long.valueOf(15)){ //HPV -> detalhe do sexo -> meninas 9 a 14 anos e meninos de 11 a 14 anos. Deixarei ambos 11, pois, nessa idade, contempla ambos.
            if(j == 1) 
                idadeAplicacaoMes = 11*12;
            if(j == 2) 
                idadeAplicacaoMes = 11*12 + 6;
        }
        if(vac.getId() == Long.valueOf(16)){ //dT
            if(j == 1) 
                idadeAplicacaoMes = 10*12;
            if(j == 2) 
                idadeAplicacaoMes = 20*12;
            if(j == 3) 
                idadeAplicacaoMes = 60*12;
        }
        if(vac.getId() == Long.valueOf(17)){ //dTpa -> vacina para gestantes, a partir do 5o mes de gestacao (coloquei 99999 meses
            if(j == 1) 
                idadeAplicacaoMes = 99999;
        }
        return idadeAplicacaoMes;
    }

}

// Falta imprimir doses vacinais a tomar. Recebe ID do paciente e cria uma lista de doses a tomar. 
// Na hora de imprimir a lista, devolve se já deveria ter tomado a dose a tanto tempo, se deve tomar a dose daqui a quanto tempo e 
// se já tomou a dose.
// Ordena tudo isso pela data de aplicacao proposta.
// Imprime mensagem de Dose tomada em xx/xx/xxxx, ou
// Dose deveria ter sido tomada em xx/xx/xxxx (vacina a tomar!), ou
// Dose deve ser tomada em xx/xx/xxxx.
