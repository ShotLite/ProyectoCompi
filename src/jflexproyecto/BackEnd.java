
package jflexproyecto;

import java.io.File;
import java.io.FileOutputStream;


public class BackEnd {
      
    FileOutputStream salida;
    public String GuardarArchivo(File archivo, String documento){
        String mensaje = null;
        try{
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje="Archivo Guardar";
        }catch(Exception e){
        }
        return mensaje;
    }
 
}
