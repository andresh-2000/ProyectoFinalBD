/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.logics;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "RegistroLogic", urlPatterns = {"/RegistroLogic"})
public class RegistroLogic extends Logic {


    public RegistroLogic(String pConnectionString) {
        super(pConnectionString);
    }

    public int registerNewStudent(String name, String correo, String contrasegna, String carnet, String agno, int carrera){
        DatabaseX database = getDatabase();
        String query = "INSERT INTO letsstudyxd.usuario "
                + "(id, nombre, correo, contrasegna, carnet, agno, carrera_id, idType)"
                + "VALUES (0, '"+name+"', '"+correo+"', '"+contrasegna+"', '"+carnet+"', '"+agno+"', "+carrera+", 1);";
        int rows = database.executeNonQueryRows(query);
        return rows;
    }
    

}
