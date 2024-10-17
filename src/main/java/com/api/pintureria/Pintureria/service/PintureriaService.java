package com.api.pintureria.Pintureria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pintureria.Pintureria.Exception.ProductoNoEncontradoException;
import com.api.pintureria.Pintureria.model.PintureriaModel;
import com.api.pintureria.Pintureria.model.ProductoDto;
import com.api.pintureria.Pintureria.model.ProductoModel;
import com.api.pintureria.Pintureria.model.StockPintureriaModel;
import com.api.pintureria.Pintureria.repository.StockPintureriaRepository;
@Service
public class PintureriaService implements IPintureriaService{

	    @Autowired
	    private StockPintureriaRepository stockPintureriaRepository;
	    
	    public PintureriaService(StockPintureriaRepository stockPintureriaRepository) {
			
			this.stockPintureriaRepository = stockPintureriaRepository;
		
		}
	  
		@Override
		public List<ProductoDto> findProductosAndCantidadByPintureriaId(Long pintureriaId) {
			  List<Object[]> productoModels = stockPintureriaRepository.findProductosByPintureriaId(pintureriaId);
			  
			     
			// Convertir Object[] a ProductoDto
			    List<ProductoDto> productoDtos = productoModels.stream()
			        .map(obj -> new ProductoDto(
			            ((ProductoModel) obj[0]).getId(),          // id
			            ((ProductoModel) obj[0]).getNombre(),      // nombre
			            (Integer) obj[1],                          // cantidad
			            ((ProductoModel) obj[0]).getPrecio(),      // precio
			            ((ProductoModel) obj[0]).getDescripcion(), // descripcion
			            ((ProductoModel) obj[0]).getCategoria()    // categoria
			        ))
			        .collect(Collectors.toList());

			    return productoDtos;
		}
		
		@Override
		public ProductoDto productoPorId(Long productoId) {
			   
		    ProductoModel productoModel = stockPintureriaRepository.findProductoByProductoId(productoId);
		        

		   
		    ProductoDto productoDto = new ProductoDto();
		    productoDto.setId(productoModel.getId());
		    productoDto.setNombre(productoModel.getNombre());
		    productoDto.setPrecio(productoModel.getPrecio());
		    productoDto.setDescripcion(productoModel.getDescripcion());
		    productoDto.setCategoria(productoModel.getCategoria());
		    productoDto.setCantidad(productoModel.getStockPinturerias().size());
		    
		    return productoDto;
		}
		
		
		
	
}
