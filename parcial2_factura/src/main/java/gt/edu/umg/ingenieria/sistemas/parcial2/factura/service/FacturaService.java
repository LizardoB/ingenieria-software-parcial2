package gt.edu.umg.ingenieria.sistemas.parcial2.factura.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.DetalleFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.CabeceraFacturaRepository;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.DetalleFacturaRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private CabeceraFacturaRepository cabeceraFacturaRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    
    public List<CabeceraFacturaEntity> buscarTodasCabecerasFactura() {
        return (List<CabeceraFacturaEntity>) this.cabeceraFacturaRepository.findAll();
    }
    
    public List<DetalleFacturaEntity> buscarTodosDetallesFactura() {
        return (List<DetalleFacturaEntity>) this.detalleFacturaRepository.findAll();
    }
    
    public List<DetalleFacturaEntity> buscarTodosDetallesFactura(Long idCabeceraFactura) {
        return this.detalleFacturaRepository.findByHeader(idCabeceraFactura);
    }
    
    public CabeceraFacturaEntity createCabeceraFactura(CabeceraFacturaEntity cabeceraFactura) {
        
        
        String oldName = cabeceraFactura.getClientName();
        String[] split = oldName.split(" ");
        String newName = "";
        
        for (int j = 0; j < split.length; j++) {
            split[j] = split[j].substring(0, 1).toUpperCase() + split[j].substring(1).toLowerCase();
            newName = newName + split[j] + " ";
        }
        cabeceraFactura.setClientName(newName);
        
        return this.cabeceraFacturaRepository.save(cabeceraFactura);
    }
    
    public DetalleFacturaEntity createDetalleFactura(DetalleFacturaEntity detalleFactura, Long id) {
        
        DetalleFacturaEntity detalleFactura2 = detalleFactura;
        
        detalleFactura2.setHeader(id);
        return this.detalleFacturaRepository.save(detalleFactura);
    }
    
    public List<CabeceraFacturaEntity> getClientsByFNLN(String nit, String orden) {
        
     
        
        return (List<CabeceraFacturaEntity>) this.cabeceraFacturaRepository.findCabeceraByNit(nit);
    }
}
