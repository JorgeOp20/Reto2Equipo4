package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.config.SpringConfig;
import es.netmind.mypersonalbankapi.modelos.cuentas.Cuenta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class CuentasInMemoryRepoTest {

    @Autowired
    private ICuentasRepo repo;

    @Autowired
    private IClientesRepo repo2;


    @Test
    void testBeans() {
        assertThat(repo, notNullValue());
        assertThat(repo2, notNullValue());
    }


    @Test
    void dadounUsuarioCuandoSolicitaTodaslasCuentasEntoncesOK() {

        List<Cuenta> cuentas;

        cuentas = repo.getAll();
        System.out.println("Numero de cuentas: " +cuentas.size());

        System.out.println(cuentas);

        assertTrue(true);


    }

    @Test
    void dadoUsuarioCuandoConsultaIdCuentaEntoncesOK () throws Exception {
        Cuenta cta;

        cta = repo.getAccountById(1);

        System.out.println(cta);

        assertThat(cta.getId(), is(1));
    }

    @Test
    void dadoUsuarioCuandoConsultaIdCuentaEntoncesNOK () throws Exception {
        //Cuenta cta = repo.getAccountById(300);

        assertThrows(Exception.class, ()->{
            repo.getAccountById(300);
        });
        //System.out.println(cta);



        //assertNull(cta);
    }



}