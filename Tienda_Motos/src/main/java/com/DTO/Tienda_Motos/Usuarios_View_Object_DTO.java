package com.DTO.Tienda_Motos;

public class Usuarios_View_Object_DTO {
	
	private String  Nombre_Us;
	private int  Cedula_Us;
	private String  Correo_Us;
	private String  Usuario;
	private String  Clave;
	
	
	// Generación de getters and setters
	
	// Generación de datos para el programa
	
	public String getNombre_Us() 
	{
		return Nombre_Us;
	}
	public void setNombre_Us(String nombre_Us)
	{
		Nombre_Us = nombre_Us;
	}
	
	public int getCedula_Us()
	{
		return Cedula_Us;
	}
	public void setCedula_Us(int cedula_Us) 
	{
		Cedula_Us = cedula_Us;
	}
	
	public String getCorreo_Us() 
	{
		return Correo_Us;
	}
	public void setCorreo_Us(String correo_Us) 
	{
		Correo_Us = correo_Us;
	}
	
	public String getUsuario() 
	{
		return Usuario;
	}
	public void setUsuario(String usuario)
	{
		Usuario = usuario;
	}
	
	public String getClave() 
	{
		return Clave;
	}
	public void setClave(String clave) 
	{
		Clave = clave;
	}


}
