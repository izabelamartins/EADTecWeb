/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author Douglas Souza
 */
@Path("EAD")
public class EADWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EADWS
     */
    public EADWS() {
    }

    /**
     * Retrieves representation of an instance of WS.EADWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Algo deu errado no GET";
    }    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Usuarios/Buscar/{login}")
    public String findUsuario(@PathParam("login")String login){
        Usuario u = new Usuario();
        u.setLogin(login);
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);
        //Convertendo para JSON
        Gson g = new Gson();
        return g.toJson(u);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Usuarios/Listar")
    public String listUsuario(){
        List<Usuario> lista;
        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.listar();
        
        Gson g = new Gson();
        return g.toJson(lista);
    }

    
    
    
}
