package com.DAO.Tienda_Motos;

// Esta clase permite el acceso a la base de datos y realizar CRUD para los Usuarios

import java.sql.*;
import java.util.ArrayList;

import com.DTO.Tienda_Motos.*;


public class Usuarios_DAO {
	
	// Crear primer método para consultar lista de usuarios
	
	public ArrayList <Usuarios_View_Object_DTO> Listar_Usuarios()
	{
		
		// De tipo ArrayList basado en el <Usuarios_View_Object_DTO> crear Variable Mi_Lista
		ArrayList <Usuarios_View_Object_DTO> Mi_Lista = new ArrayList <Usuarios_View_Object_DTO>();
		Conexion Con = new Conexion();
		
		try
		{
			//PreparedStatement toma la instrucción SQL
			// se conecta con la base de datos con el getConnect
			// devuelve el resultado y lo deja en la variable consulta
			PreparedStatement Consulta = Con.getConnect().prepareStatement("SELECT * FROM T_USUARIOS");
			
			// Con todos los resultados crear variable Rta
			// Rta sera igual a lo obtenido en el query de "Select"
			ResultSet Rta = Consulta.executeQuery();
			
			// Mientras haya un Siguiente es decir registros en Rta haga
			while(Rta.next())
			{
				//Declarar variable de tipo <Usuarios_View_Object_DTO>
				Usuarios_View_Object_DTO Persona = new Usuarios_View_Object_DTO();
				
				// Conversion del dato de tipo integer de la cedula
				Persona.setCedula_Us(Integer.parseInt(Rta.getString("Cedula_Usuario")));
				Persona.setNombre_Us(Rta.getString("Nombre_Usuario"));
				Persona.setCorreo_Us(Rta.getString("Correo_Usuario"));
				Persona.setUsuario(Rta.getString("Usuario"));
				Persona.setClave(Rta.getString("Clave"));
				
				// Al arreglo Mi_Lista adicionarle los datos de Persona
				Mi_Lista.add(Persona);
			
			}
			
			Rta.close();
			Consulta.close();
			Con.Desconectar();
		
		}
		
		catch(Exception Ex)
		{
			System.out.println("Error de conexión para listar: " + Ex);
		}
	
		return Mi_Lista;
	}
	
	public ArrayList <Usuarios_View_Object_DTO> Consultar_Usuario(int Id)
	{
		ArrayList <Usuarios_View_Object_DTO> Mi_Lista = new ArrayList <Usuarios_View_Object_DTO>();
		Conexion Con = new Conexion();
		
		try
		{
			PreparedStatement Consulta = Con.getConnect().prepareStatement("Select * from T_Usuarios where Cedula_Usuario =? ");
			
			// La primera variable se llenará con 1 documento
			Consulta.setInt(1, Id);
			ResultSet Rta = Consulta.executeQuery();
			
			if(Rta.next())
			{
				Usuarios_View_Object_DTO Persona_Busq = new Usuarios_View_Object_DTO();
				
				Persona_Busq.setCedula_Us(Integer.parseInt(Rta.getString("Cedula_Usuario")));
				Persona_Busq.setNombre_Us(Rta.getString("Nombre_Usuario"));
				Persona_Busq.setCorreo_Us(Rta.getString("Correo_Usuario"));
				Persona_Busq.setUsuario(Rta.getString("Usuario"));
				Persona_Busq.setClave(Rta.getString("Clave"));
				
				// Al arreglo Mi_Lista adicionarle los datos de Persona_Busq
				Mi_Lista.add(Persona_Busq);
			}
			
			Rta.close();
			Consulta.close();
			Con.Desconectar();
		
		}
	
		catch(Exception Ex)
		{
			System.out.println("Error de conexion para consultar: " + Ex);
		}
		
		return Mi_Lista;
		
	}
	
	public void Registrar_Usuario(Usuarios_View_Object_DTO Persona_Reg)
	{
		
		Conexion Con = new Conexion();
		
		try
		{
			Statement Instruccion = Con.getConnect().createStatement();
			Instruccion.executeUpdate("Insert into T_Usuarios values('"+Persona_Reg.getCedula_Us()+"','"
			+Persona_Reg.getNombre_Us()+"','"+Persona_Reg.getCorreo_Us()+"','"+Persona_Reg.getUsuario()+"','"
			+Persona_Reg.getClave()+"')");
			
			System.out.println("El usuario se registro correctamente");
			
			Instruccion.close();
			Con.Desconectar();
		
		}
	
		catch(Exception Ex)
		{
			System.out.println("Error de conexion para registrar: " + Ex);
		}
		
			
	}
	
	
	
	public void Actualizar_Usuario(int Id, String Nombre_Act, String Correo_Act)
	{
		
		Conexion Con = new Conexion();
		
		
		
		try
		{
			
			PreparedStatement SQL = Con.getConnect().prepareStatement("Update T_Usuarios set Nombre_Usuario = ?, Correo_Usuario =? where Cedula_Usuario =?");
			SQL.setString(1, Nombre_Act);
			SQL.setString(2, Correo_Act);
			SQL.setInt(3, Id);
			
			SQL.executeUpdate();
			
			System.out.println("El usuario se actualizó correctamente");
			
			
			Con.Desconectar();
		
		}
	
		catch(Exception Ex)
		{
			System.out.println("Error de conexion para actualizar: " + Ex);
		}
		
			
	}
	

	public void Eliminar_Usuario(int Id)
	{
		
		Conexion Con = new Conexion();
		Statement Instruccion = null;
		
		try
		{
			
			Instruccion = Con.getConnect().createStatement();
			Instruccion.executeUpdate("Delete from T_Usuarios where Cedula_Usuario = '"+ Id + "'");
			
					
			System.out.println("El usuario se ha eliminado");
			
			//Instruccion.close();
			
		
		}
	
		catch(Exception Ex)
		{
			System.out.println("Error de conexion para borrar: " + Ex);
		}
		
			
	}	
	
}
