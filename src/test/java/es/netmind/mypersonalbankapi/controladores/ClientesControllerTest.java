package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.exceptions.ClienteException;
import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
import es.netmind.mypersonalbankapi.persistencia.ClientesInMemoryRepo;
import es.netmind.mypersonalbankapi.persistencia.IClientesRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientesControllerTest {

    @Test
    void dado_clienteValido_cuando_alta_cliente_entonces_se_añade_en_repositorio() throws Exception {
        //Dado
        String fechaHoy = String.valueOf(LocalDate.now());
        System.out.println("Fecha:" + fechaHoy );

        String [] persona={"personal", "Juan Juanez", "jj@j.com", "Calle JJ 1", fechaHoy, "12345678J"};

       IClientesRepo clientesRepo = ClientesInMemoryRepo.getInstance();
       List<Cliente> clientes = clientesRepo.getAll();
       int numClientes = clientes.size();
        //Cuando
        ClientesController.add(persona);

        //Entonces
        assertEquals(numClientes+1, clientes.size());

    }


    @ParameterizedTest
    @CsvSource({"personal, Juan Juanez, jjj@.com, Calle JJ 1, 2023-10-23,"})
    void dado_clienteNoValido_cuando_alta_cliente_entonces_lanzar_excepcion(String tipoCliente, String nombre,
                                                                            String email, String direccion, LocalDate fechaHoy, String dni) throws DateTimeException, Exception, ClienteException, NumberFormatException {
        //Dado Parametro entrada
        String [] persona={tipoCliente, nombre, email, direccion, fechaHoy.toString(), dni};

        System.out.println("persona: " + persona);

        //Entonces
        assertThrows(Exception.class, () -> {
            //Cuando
            ClientesController.add(persona);
        });




    }
}