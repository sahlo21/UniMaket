package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.MedioPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {
    private int codigoUsuario;
    private MedioPago medioPago;
    private List<DetalleCompraDTO> detalleCompraDtoList;
}
