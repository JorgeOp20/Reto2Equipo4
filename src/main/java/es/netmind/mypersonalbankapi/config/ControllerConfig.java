package es.netmind.mypersonalbankapi.config;


import es.netmind.mypersonalbankapi.controladores.ClientesController;

import es.netmind.mypersonalbankapi.persistencia.ClientesInDBRepo;
import es.netmind.mypersonalbankapi.persistencia.IClientesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Autowired
    IClientesRepo clientesRepo;

    @Bean
    public ClientesController getClientesCont() throws Exception {
        ClientesController clCont = new ClientesController();
        clCont.setClientesRepo(clientesRepo);
        return clCont;
    }
}
