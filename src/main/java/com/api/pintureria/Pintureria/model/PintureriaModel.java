package com.api.pintureria.Pintureria.model;


import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="pintureria", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class PintureriaModel implements UserDetails {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column
	    private String nombre;

	    @Column
	    private String direccion;
	    
	    @Column 
	    private String telefono;
	    
	    @Column 
	    private String username; 
	    
	    @Column 
	    private String password;
	    
	    @OneToMany(mappedBy = "pintureria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<StockPintureriaModel> stockPinturerias;

	    
	    
	    
		public PintureriaModel(Long id, String nombre, String direccion, String telefono, String username,
				String password, Set<StockPintureriaModel> stockPinturerias) {
			
			this.id = id;
			this.nombre = nombre;
			this.direccion = direccion;
			this.telefono = telefono;
			this.username = username;
			this.password = password;
			this.stockPinturerias = stockPinturerias;
		}
	    
		public PintureriaModel() {
			
		
		}
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		

		public void setUsername(String username) {
			this.username = username;
		}

	
		public void setPassword(String password) {
			this.password = password;
		}

		public Set<StockPintureriaModel> getStockPinturerias() {
			return stockPinturerias;
		}

		public void setStockPinturerias(Set<StockPintureriaModel> stockPinturerias) {
			this.stockPinturerias = stockPinturerias;
		}

		 @Override
		    public Collection<? extends GrantedAuthority> getAuthorities() {
		        return null;
		    }

		    @Override
		    public boolean isAccountNonExpired() {
		        return true;
		    }

		    @Override
		    public boolean isAccountNonLocked() {
		        return true;
		    }

		    @Override
		    public boolean isCredentialsNonExpired() {
		        return true;
		    }

		    @Override
		    public boolean isEnabled() {
		        return true;
		    }

		    @Override
		    public String getPassword() {
		        return this.password;
		    }

		    @Override
		    public String getUsername() {
		        return this.username;
		    }
	    
}
