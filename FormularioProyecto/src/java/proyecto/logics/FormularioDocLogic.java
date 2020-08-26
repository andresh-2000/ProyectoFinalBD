
package proyecto.logics;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;

/**
 *
 * @author diana
 */
public class FormularioDocLogic extends Logic {

    public FormularioDocLogic(String pConnectionString) {
        super(pConnectionString);
    }
    
    public int insertFormulario(String pTipo, int pAgno, int pAsignaturaId, int pUsuarioId) {
    DatabaseX database = getDatabase();
        String query = "INSERT INTO letsstudyxd.publicaciones "
                + "(id, tipo, agno, asignatura_id, usuario_id)"
                + "VALUES (0, '"+pTipo+"', "+pAgno+", "+pAsignaturaId+", "+pUsuarioId+");";
    
        int rows = database.executeNonQueryRows(query);
        return rows;
   }

              
}

