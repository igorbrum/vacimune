/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ibrum
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.glassfish.jersey.server.wadl.internal.WadlResource.class);
        resources.add(ws.DoencaWS.class);
        resources.add(ws.DoseVacinaAplicadaWS.class);
        resources.add(ws.DoseVacinaWS.class);
        resources.add(ws.EapvSofridoWS.class);
        resources.add(ws.EapvWS.class);
        resources.add(ws.PacienteWS.class);
        resources.add(ws.SituacaoVacinalWS.class);
        resources.add(ws.UnidadeSaudeWS.class);
        resources.add(ws.VacinaAplicadaWS.class);
        resources.add(ws.VacinaWS.class);
        resources.add(ws.VacinasATomarWS.class);
        resources.add(ws.VacinasTomadasWS.class);
        resources.add(ws.WatsonWS.class);
    }
    
}
