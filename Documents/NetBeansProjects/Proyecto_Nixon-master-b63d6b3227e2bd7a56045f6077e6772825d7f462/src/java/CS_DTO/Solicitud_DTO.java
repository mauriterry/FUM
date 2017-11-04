/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS_DTO;

import java.util.ArrayList;

/**
 *
 * @author camila
 */
public class Solicitud_DTO {
   
    ArrayList<Solicitud_DTO> datos = new ArrayList();
            int idSolicitud = 0;
            String ADP = null;
            String ciudad = null;
            String tipoT = null;
            String Estado=null;
            String identificacion=null;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public ArrayList<Solicitud_DTO> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Solicitud_DTO> datos) {
        this.datos = datos;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getADP() {
        return ADP;
    }

    public void setADP(String ADP) {
        this.ADP = ADP;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipoT() {
        return tipoT;
    }

    public void setTipoT(String tipoT) {
        this.tipoT = tipoT;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

   
    
}
