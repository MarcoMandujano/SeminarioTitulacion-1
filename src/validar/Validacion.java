package validar;

/**
 *
 * @author Parker
 */
public final class Validacion {
    /**
    * Constructor Validacion.
    */
    private Validacion() { }

    /**
    * Función que verifiva si en una cadena solo hay numeros.
    *
    * @param    numero  cadena para verificar.
    * @return           un boolean, true si en la cadena solo hay números,
    *                   de lo contrario regresa false.
    */
    public static boolean soloNumeros(final String numero) {
        return numero.matches("[0-9]+");
    }

    /**
    * Función que verifiva si en una cadena solo hay letras.
    *
    * @param    letras  cadena para verificar.
    * @return           un boolean, true si en la cadena solo hay letras,
    *                   de lo contrario regresa false.
    */
    public static boolean soloLetras(final String letras) {
        return letras.toLowerCase().matches("[a-z\\á\\é\\í\\ó\\ú\\ñ]+");
    }

    /**
    * Función que verifiva si en una cadena solo hay letras y espacios.
    *
    * @param    letras  cadena para verificar.
    * @return           un boolean, true si en la cadena solo hay letras
    *                   y espacios, de lo contrario regresa false.
    */
    public static boolean soloNombres(final String letras) {
        String expresion = "[a-z\\á\\é\\í\\ó\\ú\\ñ\\ ]+";
        return letras.toLowerCase().matches(expresion);
    }

    /**
    * Función que verifiva si es un cubículo.
    *
    * @param    cadena  cadena para verificar.
    * @return           un boolean, true si en la cadena esta el formato
    *                   letra seguido de un guion y  más de un número,
    *                   de lo contrario regresa false.
    */
    public static boolean soloCubiculo(final String cadena) {
        return cadena.toLowerCase().matches("[a-z]-[0-9]+");
    }

    /**
    * Función que verifiva si en una cadena solo hay numeros,
    * letras y espacios.
    *
    * @param    cadena  cadena para verificar.
    * @return           un boolean, true si en la cadena solo hay letras,
    *                   números, puntos y espacios,
    *                   de lo contrario regresa false.
    */
    public static boolean soloLetraNumeroEspacio(final String cadena) {
        String expresion = "[a-z0-9\\á\\é\\í\\ó\\ú\\ñ\\ \\.]+";
        return cadena.toLowerCase().matches(expresion);
    }

    /**
    * Función que verifiva si en una cadena hay letras, espacio y punto.
    *
    * @param    cadena  cadena para verificar.
    * @return           un boolean, true si en la cadena solo hay letras,
    *                   espacioss y puntos, de lo contrario regresa false.
    */
    public static boolean soloTexto(final String cadena) {
        String expresion = "[a-z\\á\\é\\í\\ó\\ú\\ñ\\ \\.]+";
        return cadena.toLowerCase().matches(expresion);
    }

    /**
    * Función que verifiva si una cadena es un correo electrónico.
    *
    * @param    cadena  cadena para verificar.
    * @return           un boolean, true si la cadena es un correo electrónico,
    *                   de lo contrario regresa false.
    */
    public static boolean soloEmail(final String cadena) {
        String email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return cadena.matches(email);
    }
}

