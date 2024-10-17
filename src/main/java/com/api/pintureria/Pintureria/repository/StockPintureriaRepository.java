package com.api.pintureria.Pintureria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.pintureria.Pintureria.model.ProductoDto;
import com.api.pintureria.Pintureria.model.ProductoModel;
import com.api.pintureria.Pintureria.model.StockPintureriaModel;
@Repository
public interface StockPintureriaRepository extends JpaRepository<StockPintureriaModel, Integer> {
	 /*
	 @Query("SELECT s.producto FROM StockPintureriaModel s WHERE s.pintureria.id = :pintureriaId")
	    List<ProductoModel> findProductosByPintureriaId(@Param("pintureriaId") Long pintureriaId);
	 */
	 @Query("SELECT s.producto, s.cantidad as cantidad FROM StockPintureriaModel s WHERE s.pintureria.id = :pintureriaId")
	    List<Object[]>findProductosByPintureriaId(@Param("pintureriaId") Long pintureriaId);
	    
	    @Query("SELECT s.producto FROM StockPintureriaModel s WHERE s.producto.id = :productoId")
	    ProductoModel findProductoByProductoId(@Param("productoId") Long productoId);
	    
	    
}
