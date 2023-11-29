package es.netmind.mypersonalbankapi.controladores;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

import es.netmind.mypersonalbankapi.config.SpringConfig;
import es.netmind.mypersonalbankapi.persistencia.ICuentasRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
//@ActiveProfiles("dev")

class CuentasControllerTest {

    @Autowired
    private ICuentasRepo cuentasRepo;

    @Autowired
    private CuentasController ctaCont;

    @Test
    void testBeans() {
        assertThat(cuentasRepo, notNullValue());
        assertThat(ctaCont, notNullValue());
        assertThat(ctaCont.getCuentasRepo(), notNullValue());
    }

    @Test
    void dadoUnClienteCuandoConsultaCuentasEntoncesOK(){
//        assertThat(ctaCont, notNullValue());
        System.out.println(cuentasRepo);
        System.out.println(ctaCont);
        ctaCont.mostrarLista(1);
//        String fechaHoy = String.valueOf(LocalDate.now());
//        String [] persona={"AAA", "jj@j.com", "Calle JJ 1", LocalDate.now(), true, false, "12345678J"};
//        ctaCont.add(4, persona);
        assertNotNull(cuentasRepo);


   }



}