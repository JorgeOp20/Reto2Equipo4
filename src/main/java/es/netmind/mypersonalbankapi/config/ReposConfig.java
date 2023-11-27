package es.netmind.mypersonalbankapi.config;

import es.netmind.mypersonalbankapi.persistencia.ClientesInDBRepo;
import es.netmind.mypersonalbankapi.persistencia.IClientesRepo;
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
}
