package com.api.pintureria.Pintureria.service;

import java.util.List;
import java.util.Optional;

import com.api.pintureria.Pintureria.model.ProductoDto;
import com.api.pintureria.Pintureria.model.ProductoModel;


public interface IProductoService {
	 public List<ProductoModel> findAllProductosModel();
	
	 public ProductoModel findProductoById(Long productoId);
	 public ProductoDto devuelveProductoDto(ProductoModel productoModel);
	 public ProductoDto retornaProductoParaEndPoing(Long productoId);
	 public String retornaProductoParaEndPoint(Long productoId);

	public boolean  modificarProducto(ProductoDto producto);

	public Long agregarProducto(ProductoDto producto);
	public void agregarStockProductoPintureria (ProductoDto producto);

	public void eliminarProductoPintureria(Long id);
}
