package proyecto.Objects;

public class InicioDeSesionObject
{
    private int id;
    private String nombre;
    private String correo;
    private String contrasegna;
    private int idType;

    public InicioDeSesionObject(int pId, String pNombre, String pCorreo, 
            String pConstrasegna, int pidType) 
    {
        setId(pId);
        setNombre(pNombre);
        setCorreo(pCorreo);
        setContrasegna(pConstrasegna);
        setIdType (pidType);
        
      
        
    }

    public int getId() 
    {
        return id;
    }

    private void setId(int pId) 
    {
        this.id = pId;
    }

    public String getNombre() 
    {
        return nombre;
    }

    private void setNombre(String pNombre) 
    {
        this.nombre = pNombre;
    }

    public String getCorreo() 
    {
        return correo;
    }

    private void setCorreo(String pCorreo) 
    {
        this.correo = pCorreo;
    }

    public String getContrasegna() 
    {
        return contrasegna;
    }

    private void setContrasegna(String pContrasegna) 
    {
        this.contrasegna = pContrasegna;
    }

    public int getIdType() {
        return idType;
    }

    private void setIdType(int pidType) {
        this.idType = pidType;
    }

 
}