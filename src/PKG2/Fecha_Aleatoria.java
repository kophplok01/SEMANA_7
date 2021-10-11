package PKG2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha_Aleatoria {
	
	
    static Date randomDate(String beginDate, String endDate) {  
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date Fecha_inicio = format.parse (beginDate); // Construir la fecha de inicio  
            Date Fecha_final = format.parse (endDate); // Construir la fecha final  
            // getTime () significa devolver la cantidad de milisegundos representados por este objeto Date desde las 00:00:00 GMT del 1 de enero de 1970.  
            if (Fecha_inicio.getTime() >= Fecha_final.getTime()) {  
                return null;  
            }  
            long date = random(Fecha_inicio.getTime(), Fecha_final.getTime());  

            return new Date(date);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  

    private static long random(long begin, long end) {  
        long rtn = begin + (long) (Math.random() * (end - begin));  
        // Si el tiempo de retorno es el tiempo de inicio y de finalización, llame a esta función de forma recursiva para encontrar un valor aleatorio  
        if (rtn == begin || rtn == end) {  
            return random(begin, end);  
        }  
        return rtn;  
    }

}
