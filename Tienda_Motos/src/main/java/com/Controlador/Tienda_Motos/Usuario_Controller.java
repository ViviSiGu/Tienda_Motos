package com.Controlador.Tienda_Motos;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tienda_Motos.Usuarios_DAO;
import com.DTO.Tienda_Motos.Usuarios_View_Object_DTO;


@RestController
public class Usuario_Controller {
	
	
	@RequestMapping("/Lista_Usuarios")
	
	//Crear método que permita listar los usuarios
	public ArrayList <Usuarios_View_Object_DTO> Lista_Usuarios()
	{
		Usuarios_DAO dao = new Usuarios_DAO();
		return dao.Listar_Usuarios();
	}
	
	
	@RequestMapping("/Consulta_Usuarios")
	public ArrayList <Usuarios_View_Object_DTO> Consultar_Usuarios(int Id)
	{
		Usuarios_DAO dao = new Usuarios_DAO();
		return dao.Consultar_Usuario(Id);
	}
	
	@RequestMapping("/Registro_Usuario")
	public void Registrar_Usuario(Usuarios_View_Object_DTO Persona_Reg)
	{
		Usuarios_DAO dao = new Usuarios_DAO();
		dao.Registrar_Usuario(Persona_Reg);
	}
	
	@RequestMapping("/Update_Usuario")
	public void Actualizar_Usuario(int Id, String Nombre_Act, String Correo_Act)
	{
		Usuarios_DAO dao = new Usuarios_DAO();
		dao.Actualizar_Usuario( Id, Nombre_Act, Correo_Act);
	}
		
	@RequestMapping("/Eliminar_Usuario")
	public void Eliminar_Usuario(int Id)
	{
		Usuarios_DAO dao = new Usuarios_DAO();
		dao.Eliminar_Usuario(Id);
	}
}
