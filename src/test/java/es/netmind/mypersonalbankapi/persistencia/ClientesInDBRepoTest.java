package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientesInDBRepoTest {

    private IClientesRepo repo;

    @BeforeEach
    void setUp() throws Exception {
//        repo = new UsuarioInMemoryRepository();
        repo = new ClientesInDBRepo();
    }

    @Test
    void dadoAltaNuevoClienteTipoPersonalCuandoClienteValidoEntoncesOK() throws Exception {

        Cliente altaUsuario = new Personal(null, "Equipo 4", "e4@gmai.com", "Calle 4", LocalDate.now(), true, false, "12345678Z" );
        repo.addClient(altaUsuario);

        System.out.println(altaUsuario);

        assertThat(altaUsuario.getId(), greaterThan(0));

    }

    @Test
    void dadoAltaNuevoClienteTipoEmpresaCuandoClienteValidoEntoncesOK() throws Exception {

        Cliente altaUsuario = new Empresa(null, "Empresa 4", "e4@gmai.com", "Calle 4", LocalDate.now(), true, false, "Z12345678", null );
        repo.addClient(altaUsuario);

        System.out.println(altaUsuario);

        assertThat(altaUsuario.getId(), greaterThan(0));

    }

    @Test
    void dadoUnUsuarioCuandoQuiereListaClientesEntoncesOK() throws Exception {



    }

}