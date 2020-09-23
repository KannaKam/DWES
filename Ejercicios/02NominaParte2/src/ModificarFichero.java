import java.io.*;


public class ModificarFichero {
    public static void leerFichero(String ruta){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (ruta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si tdo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public static void escribirFichero(String ruta, String texto){
        FileWriter writer = null;
        leerFichero(ruta);
        try
        {
            leerFichero(ruta);
            writer = new FileWriter(ruta);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != writer)
                    writer.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public static void modificarFichero(String ruta, String textoAnterior, String textoNuevo){
        File fichero = new File(ruta);
        String contenidoAntiguo = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try{
            reader = new BufferedReader(new FileReader(fichero));
            String linea = reader.readLine();
            while (linea!=null){
                contenidoAntiguo = contenidoAntiguo + linea + System.lineSeparator();
                linea = reader.readLine();
            }
            String contenidoNuevo = contenidoAntiguo.replaceAll(textoAnterior, textoNuevo);
            writer = new FileWriter(fichero);
            writer.write(contenidoNuevo);
        } catch (IOException e) {
           e.printStackTrace();
        }finally {
            try{
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
