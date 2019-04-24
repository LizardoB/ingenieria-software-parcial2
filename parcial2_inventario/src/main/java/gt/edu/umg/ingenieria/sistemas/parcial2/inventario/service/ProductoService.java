package gt.edu.umg.ingenieria.sistemas.parcial2.inventario.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.inventario.dao.ProductoRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    public List<ProductoEntity> buscarTodos() {

        ArrayList<ProductoEntity> lista = new ArrayList<ProductoEntity>();
        
        lista = (ArrayList<ProductoEntity>) this.productoRepository.findAll();
        
        Collections.sort(lista, new Comparator<ProductoEntity>() {
            public int compare(ProductoEntity obj1, ProductoEntity obj2) {
                return obj1.getName().compareTo(obj2.getName());
            }
        });
        
        
        
        return lista;
    }
   
    
    public ProductoEntity createProduct(ProductoEntity producto) {
        
        String oldName = producto.getName();
        String [] split = oldName.split(" ");
        String newName = "";

        for (int j = 0; j < split.length; j++) {
            if(j==0)
                split[j] = split[j].substring(0, 1).toUpperCase() + split[j].substring(1).toLowerCase();
            else
                split[j] = split[j].substring(0, 1).toLowerCase()+ split[j].substring(1).toLowerCase();
            newName = newName + split[j] + " ";
        }
        
        producto.setName(newName);
        
        return this.productoRepository.save(producto);
 
    }
    
    
    public ProductoEntity updateStock(Long id, String operacion,Integer stock) {
        
        ProductoEntity producto = this.productoRepository.findById(id).get();
        Integer stockActual=0;
        Integer stockActualizado=0;
        
        if (operacion.equals("incrementar")) 
        {
            stockActual = producto.getStock();
            stockActualizado = stockActual + stock;
            producto.setStock(stockActualizado);
        } 
        else if (operacion.equals("decrementar"))
        {
            stockActual = producto.getStock();
            stockActualizado = stockActual - stock;
            producto.setStock(stockActualizado);
        }
      
        
        return this.productoRepository.save(producto);
    }
    
}
