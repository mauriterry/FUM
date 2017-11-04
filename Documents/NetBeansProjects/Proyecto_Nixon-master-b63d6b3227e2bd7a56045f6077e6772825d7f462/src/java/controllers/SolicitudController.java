/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import CS_DAO.Solicitud_DAO;
import CS_DTO.ClienteDTO;
import CS_DTO.Solicitud_DTO;
import co.edu.uniminuto.pa.bds.MySqlDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author camila
 */
@Controller
@RequestMapping("/")
public class SolicitudController {
    
    
    
      @RequestMapping("SolicitudCrear.htm")
    public String processSubmit2crear(HttpServletRequest req,SessionStatus status,ModelMap model) 
    {
        
        Solicitud_DAO pDao = new Solicitud_DAO();
        Logger.getLogger(Solicitud_DAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");       
       ClienteDTO p = new ClienteDTO();
         List<ClienteDTO> datos= pDao.consultarCliente( MySqlDataSource.getConexionBD());
       // List<ClienteDTO> datos =p.getDatos();
        //Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + "-" + datos.size());
        
        model.put("listaSolicitud", datos);
        if (datos.size() > 0)
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        else
            model.put("mensaje", "La consulta NO tiene resultados...");
        
        return "Solicitud_crear";
    }
    //---------------------------------------------------------------------------------------------------------
        @RequestMapping(method = RequestMethod.GET, value = "SolicitudDigita.htm")
    public String processSubmit(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        System.out.println("SolicitudCrear");
        model.put("mensajeSolicitud", "Pase por el controller de Solicitud:::"+req.getParameter("nombre"));
        return "Solicitud_digita";
    }    

@RequestMapping(method = RequestMethod.POST, value = "SolicitudRegistrar.htm")
    public String processSubmit1(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        Solicitud_DAO pDao = new Solicitud_DAO();
            
        Logger.getLogger(SolicitudController.class.getName()).log(Level.INFO, "Ejecutando processSubmit1...");

       int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String adp = req.getParameter("ADP");
        String ciudad = req.getParameter("ciudad");
        String tipot = req.getParameter("tipoT");
        ClienteDTO c=new ClienteDTO();
        String identi=req.getParameter("identificacion");

        Solicitud_DTO p = new Solicitud_DTO();
        p.setIdSolicitud(id);
        p.setADP(adp);
        p.setCiudad(ciudad);
        p.setTipoT(tipot);
        p.setIdentificacion(identi);
   
        boolean insert = pDao.crearSolicitud(p, MySqlDataSource.getConexionBD());

        Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Registrar + " + "-" + insert);
        
        if (insert)
            model.put("mensaje", "El registro fue creado satisfactoriamente!!!");
        else
            model.put("mensaje", "El registro NO fue creado, consulte con el administrador...");
        
        return "Solicitud_digita";
    }     
    
    

    //-----------------------------------------------------------------------------------------------------------------
    
    @RequestMapping("SolicitudRechazada.htm")
    public String processSubmit23(HttpServletRequest req,SessionStatus status,ModelMap model) 
    {
        Solicitud_DAO pDao = new Solicitud_DAO();       
        Logger.getLogger(Solicitud_DAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
       Solicitud_DTO p = new Solicitud_DTO();
        List<Solicitud_DTO> datos= pDao.consultarSolicitud1( MySqlDataSource.getConexionBD());
        //List<Solicitud_DTO> datos =p.getDatos();
        //Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + "-" + datos.size());
        model.put("listaSolicitud", datos);
        if (datos.size() > 0)
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        else
            model.put("mensaje", "La consulta NO tiene resultados...");
        
        return "Solicitud_rechazada";
    }

@RequestMapping(method = RequestMethod.GET, value = "SolicitudConsultar.htm")
    public String processSubmit2(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(ClienteController.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "Solicitud_consultar";
    } 
    
@RequestMapping(method = RequestMethod.POST, value = "SolicitudConsultarForm.htm")
    public String processSubmit3(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        Solicitud_DAO pDao = new Solicitud_DAO();
        
            
        Logger.getLogger(Solicitud_DAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");

        int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String ident = req.getParameter("identificacion");
        String nombre1 = req.getParameter("nombre1");
        
       Solicitud_DTO p = new Solicitud_DTO();
        p.setIdSolicitud(id);
        
            
        List<Solicitud_DTO> datos = pDao.consultarSolicitud(p, MySqlDataSource.getConexionBD());

        Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());
        
        model.put("listaSolicitud", datos);
        if (datos.size() > 0)
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        else
            model.put("mensaje", "La consulta NO tiene resultados...");
        
        return "Solicitud_consultar";
    }     
    
@RequestMapping(method = RequestMethod.GET, value = "SolicitudEditar.htm")
    public String processSubmit4(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(SolicitudController.class.getName()).log(Level.INFO, "Ejecutando processSubmit4...");
        return "Solicitud_editar";
    } 
    
@RequestMapping(method = RequestMethod.POST, value = "SolicitudEditarForm1.htm")
    public String processSubmit5(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

       Solicitud_DAO pDao = new Solicitud_DAO();
        
        Logger.getLogger(Solicitud_DAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit5...");

        int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String ident = req.getParameter("identificacion");
        String nombre1 = req.getParameter("nombre1");
        
      Solicitud_DTO p = new Solicitud_DTO(); 
        p.setIdSolicitud(id);
    
            
        List<Solicitud_DTO> datos = pDao.consultarSolicitud(p, MySqlDataSource.getConexionBD());

        Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());
        
        model.put("listaSolicitud", datos);
        
        
        return "Solicitud_editar";
        
    }    
    
@RequestMapping(method = RequestMethod.POST, value = "SolicitudEditarForm2.htm")
    public String processSubmit6(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

       Solicitud_DAO pDao = new Solicitud_DAO();
        
            
        Logger.getLogger(Solicitud_DAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit6...");

        int id = Integer.parseInt(req.getParameter("id"));  
        String ident = req.getParameter("identificacion");
        String nombre1 = req.getParameter("nombre1");
        String nombre2 = req.getParameter("nombre2");
        String apellido1 = req.getParameter("apellido1");
        String apellido2 = req.getParameter("apellido2");
        String direccion = req.getParameter("direccion");
        String telef = req.getParameter("telefono");
        String email = req.getParameter("email");
        
        
        
        Logger.getLogger(Solicitud_DAO.class.getName()).log(Level.INFO, "Id Solicitud: " + id);
        
       Solicitud_DTO p = new Solicitud_DTO();
       p.setIdSolicitud(id);
  
        boolean res = pDao.editarSolicitud(p, MySqlDataSource.getConexionBD());                         
        
        if (res)
            model.put("mensaje", "Se edito satisfactoriamente!!!");
        else
            model.put("mensaje", "NO se guardaron los cambios...");
        
        return "Solicitud_editar";
        
    }      
}
