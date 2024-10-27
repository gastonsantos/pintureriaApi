package com.api.pintureria.Pintureria.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pintureria.Pintureria.Exception.ProductoNoEncontradoException;
import com.api.pintureria.Pintureria.Exception.UsuarioNoEncontradoException;
import com.api.pintureria.Pintureria.model.PintureriaModel;
import com.api.pintureria.Pintureria.model.ProductoDto;
import com.api.pintureria.Pintureria.model.ProductoModel;
import com.api.pintureria.Pintureria.model.StockPintureriaModel;
import com.api.pintureria.Pintureria.repository.PintureriaRepository;
import com.api.pintureria.Pintureria.repository.ProductoRepository;
import com.api.pintureria.Pintureria.repository.StockPintureriaRepository;

@Service
public class ProductoService implements IProductoService{
	  @Autowired
	   private ProductoRepository productoRepository;
	   private PintureriaRepository pintureriaRepository;
	   private StockPintureriaRepository stockPintureriaRepository;
	  public ProductoService(ProductoRepository productoRepository, PintureriaRepository pintureriaRepository,
			  StockPintureriaRepository stockPintureriaRepository
			  ) {
	
		this.productoRepository = productoRepository;
		this.pintureriaRepository = pintureriaRepository;
		this.stockPintureriaRepository = stockPintureriaRepository;
	}

	@Override
	  public List<ProductoModel> findAllProductosModel() {
		return productoRepository.findAll();
	}
	
	

	@Override
	public ProductoModel findProductoById(Long productoId) {
		
		return productoRepository.findById(productoId)
				 .orElseThrow(() -> new ProductoNoEncontradoException());
		
	}
	
	@Override 
	public ProductoDto devuelveProductoDto(ProductoModel productoModel) {
		
		ProductoDto producto = new ProductoDto();
		producto.setId(productoModel.getId());
		producto.setNombre(productoModel.getNombre());
		producto.setDescripcion(productoModel.getDescripcion());
		producto.setCategoria(productoModel.getCategoria());
		producto.setPrecio(productoModel.getPrecio());
		return producto;
	}
	
	@Override
	public ProductoDto retornaProductoParaEndPoing(Long productoId) {
		ProductoModel productoModel = findProductoById(productoId);
		return devuelveProductoDto( productoModel);
	}
	
	
	@Override 
	public String retornaProductoParaEndPoint(Long productoId) {
		ProductoModel productoModel = findProductoById(productoId);
		return productoModel.getNombre();
	}

	@Override
	public boolean modificarProducto(ProductoDto producto) {
		ProductoModel productoModel = findProductoById(producto.getId());
		
		if(productoModel == null) {
			throw new ProductoNoEncontradoException();
		}else {
			productoModel.setDescripcion(producto.getDescripcion());
			productoModel.setPrecio(producto.getPrecio());
			productoRepository.save(productoModel);
			return true;
		}
		
	}

	@Override
	public Long agregarProducto(ProductoDto producto) {
		  ProductoModel productoModel = new ProductoModel();
		    productoModel.setNombre(producto.getNombre());
		    productoModel.setDescripcion(producto.getDescripcion());
		    productoModel.setPrecio(producto.getPrecio());
		    productoModel.setFecha_ingreso(new Date()); 
		    productoModel.setCategoria(producto.getCategoria());
		    productoModel.setStockPinturerias(new HashSet<>()); 

		     return productoRepository.save(productoModel).getId();
	}
	
	@Override 
	public void agregarStockProductoPintureria (ProductoDto producto) {
		PintureriaModel pintureriaModel = pintureriaRepository.getById(producto.getId());
		if(pintureriaModel == null) {
			throw new ProductoNoEncontradoException();
		}else {
			Long idProducto = agregarProducto(producto);
			ProductoModel productoModel = findProductoById(idProducto);
			if(productoModel == null) {
				throw new ProductoNoEncontradoException();
			}
			StockPintureriaModel stockPintureria = new StockPintureriaModel();
			stockPintureria.setPintureria(pintureriaModel);
			stockPintureria.setProducto(productoModel);
			stockPintureria.setCantidad(1);
			
			stockPintureriaRepository.save(stockPintureria);
	   }
	}

	@Override
	public void eliminarProductoPintureria(Long id) {
	
		ProductoModel producto = findProductoById(id);
		if(producto != null) {
			productoRepository.delete(producto);
		}else {
			throw new ProductoNoEncontradoException();
		}
	}
	
}
