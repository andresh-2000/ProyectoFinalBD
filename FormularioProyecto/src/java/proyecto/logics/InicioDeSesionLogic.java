package proyecto.logics;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import proyecto.Objects.InicioDeSesionObject;

public class InicioDeSesionLogic extends Logic
{

    public InicioDeSesionLogic(String pConnectionString) 
    {
        super(pConnectionString);
    }
    
    public InicioDeSesionObject getUserByEmail(String pCorreo)
    {
        DatabaseX database = getDatabase();
        String sql = "select * from letsstudyxd.usuario "
                + "where correo like '"+pCorreo+"';";
        ResultSet result = database.executeQuery(sql);
        
        InicioDeSesionObject temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int id;
                String nombre;
                String correo;
                String contrasegna;
                int idType; 
                
                while(result.next())
                {
                    id = result.getInt("id");
                    nombre = result.getString("nombre");
                    correo = result.getString("correo");
                    contrasegna = result.getString("contrasegna");
                    idType = result.getInt("idType");
                    temp = new InicioDeSesionObject(id, nombre, correo, contrasegna, idType);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(InicioDeSesionLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }     
}
