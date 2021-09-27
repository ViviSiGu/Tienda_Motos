package com.DAO.Tienda_Motos;

import java.sql.*;

public class Conexion {
	
	// Parámetros de conexión
	
	String Base_Datos = "db_tienda_motos"; 
	String Login = "root";
	String Password = "12345";
	String URL = "jdbc:mysql://localhost/"+ Base_Datos;
	
	// Crear variable de tipo connection inicializada en null
	
	Connection Connect = null;
	
	// Constructor para la conexión
	
	public Conexion()
	{
		try
		{
			//Obtener el driver para  MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Realizar la conexion
			Connect = DriverManager.getConnection(URL, Login, Password);
			
			
			if (Connect != null)
			{
				System.out.println("Conexión a base de datos " + Base_Datos + " Ok\n");
			}
		
		}
		
		catch(SQLException Ex1)
		{
			System.out.println("Error de conexión: " + Ex1);
		}
		
		catch(ClassNotFoundException Ex2) 
		{
			System.out.println("Error clase no encontrada:" + Ex2);
		}
		
		catch(Exception Ex3)
		{
			System.out.println("Error de conexión: " + Ex3);
		}
		
	}
	
	//Método getConnection de tipo Connection
	public Connection getConnect()
	{
		return Connect;
	}
		
	public void Desconectar()
	{
		Connect = null;
	}
	

}
