package es.netmind.mypersonalbankapi.config;

import es.netmind.mypersonalbankapi.persistencia.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class ReposConfig {

    @Value("${db_url}")
    String dbUrl;


    @Bean
    //@Profile("default")
    public IClientesRepo getClientesRepo() {
        System.out.println("dburl: " + dbUrl);
        ClientesInDBRepo repo = new ClientesInDBRepo();
        repo.setDb_url(dbUrl);
        return repo;
    }

    @Bean
    //@Profile("dev")
    public ICuentasRepo createCuentasInMemoryRepo() {
        System.out.println("usando CuentasInMemoryRepo...");
        CuentasInMemoryRepo repoC = new CuentasInMemoryRepo();
        return repoC;
    }

    @Bean
    //@Profile("dev")
    public IPrestamosRepo createPrestamosInMemoryRepo() {
        System.out.println("usando PrestamosInMemoryRepo...");
        PrestamosInMemoryRepo repoP = new PrestamosInMemoryRepo();
        return repoP;
    }
}
