package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.persistencia.ClientesInMemoryRepo;
import es.netmind.mypersonalbankapi.persistencia.IClientesRepo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientesControllerTest {

    @Test
    void dado_cliente_cuando_alta_cliente_entonces_se_añade_en_repositorio() throws Exception {
        //Dado
        String fechaHoy = String.valueOf(LocalDate.now());
        System.out.println("Fecha:" + fechaHoy );
        //Empresa empresa = new Empresa(100, "Empresa1", "mail@gmail.com","Calle java", LocalDate.now(), true, false, "B34245632", null);
        String [] persona={"personal", "Juan Juanez", "jj@j.com", "Calle JJ 1", fechaHoy, "12345678J"};

       IClientesRepo clientesRepo = ClientesInMemoryRepo.getInstance();
       List<Cliente> clientes = clientesRepo.getAll();
       int numClientes = clientes.size();
        //Cuando
        ClientesController.add(persona);

        //Entonces
        assertEquals(numClientes+1, clientes.size());


    }
}