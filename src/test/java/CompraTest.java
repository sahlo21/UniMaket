import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.*;
import co.edu.uniquindio.unimarket.modelo.entidades.*;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = UniMarketApplication.class)
    @Transactional
    public class CompraTest {

    @Autowired
    private CompraServicio compraServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crerCompraTest() throws Exception {

        List<DetalleCompraDTO> detalleCompraDTOS = new ArrayList<>();

        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO(
                6,
                2
        );
        detalleCompraDTOS.add(detalleCompraDTO);
         detalleCompraDTO = new DetalleCompraDTO(
                7,
                1
        );

        detalleCompraDTOS.add(detalleCompraDTO);

        CompraDTO compraDTO = new CompraDTO(
                1,
                MedioPago.PAGO_CONTRAENTREGA,
                detalleCompraDTOS
        );

        int codeCompra = compraServicio.crearCompra(compraDTO);

        Compra compra = compraServicio.obtenerCompra(codeCompra);
        System.err.println("COMPRA: "+compra.getValorTotal()+compra.getMedioPago());

        for(DetalleCompra detalleCompra :compra.getDetalleCompraList()) {
            System.err.println("DETAIL:"+detalleCompra.getCodigo()+" name: "+compra.getValorTotal()+"   "+compra.getMedioPago());

        }

        Assertions.assertNotEquals(0, codeCompra);
    }
    /*
    @Test
    @Sql("classpath:dataset.sql")
    public void listTransaction() {
        List<TransactionGetDTO> listTransaction = transactionInterface.listTransactionByPerson("1004684293");
        System.out.println(listTransaction);
        Assertions.assertFalse(listTransaction.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void getTransaction() throws Exception {
        TransactionGetDTO transactionGetDTO = transactionInterface.getTransactionDTO(1);
        Assertions.assertNotNull(transactionGetDTO);
    }

     */






}


