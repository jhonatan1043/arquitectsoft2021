/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generals;

/**
 *
 * @author Programador 1
 */
public class Contans {
    // query of system 
    //--------------------------------------------------------------------------------------------------------------------------------

    public static String QUERY_ACABADO = "SELECT Codigo_Homologacion codigo, Descripcion FROM Acabados;";

    public static String QUERY_INSERT_ACABADOS = "INSERT acabados (Codigo_Homologacion, descripcion)VALUES(?,?)";
//--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_UNIDAD_MEDIDA = "SELECT Id_Unidad_Medida, Descripcion FROM Unidades_Medidas;";

    public static String QUERY_INSERT_UNIDAD_MEDIDA = "INSERT unidades_medidas (Descripcion,Convencion)VALUES(?,?);";
    //--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_EXITS_COMPONENTES = "SELECT true AS status FROM componentes where Codigo = ?;";

    public static String QUERY_COMPONENTES = "SELECT Id_Componente,Codigo,Descripcion FROM arquitectdb.componentes;";

    public static String QUERY_COMPONENTES_LISTAR = "CALL componentesConsultar('";

    public static String QUERY_COMPONENTES_CARGAR = "SELECT Codigo,Descripcion FROM arquitectdb.componentes WHERE Id_Componente = ?;";

    public static String QUERY_COMPONENTES_DETALLE_CARGAR = "CALL componenteDetalleCargar(?);";

    public static String QUERY_INSERT_COMPONENTES = "INSERT arquitectdb.componentes(codigo, descripcion) VALUES (?,?);";

    public static String QUERY_INSERT_COMPONENTE_DETALLE = "INSERT arquitectdb.componentes_detalle (Id_Componente,"
            + " Id_Subcomponente,"
            + " Id_Unidad_Calculada,"
            + " Cantidad_Default,"
            + " Cantidad_Adicional,"
            + " Aplica_Decremento) VALUES (?,?,?,?,?,?);";

    public static String QUERY_UPDATE_COMPONENTES = "CALL spComponenteActualizar(?,?,?);";

    public static String QUERY_DELETE_COMPONENTE = "DELETE FROM arquitectdb.componentes WHERE Id_Componente = ?;";

    public static String QUERY_DELETE_COMPONENTE_DETALLE = "DELETE FROM arquitectdb.componentes_detalle WHERE Id_Componente = ?;";

    //--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_CATEGORIAS = "SELECT Id_categoria,Descripcion,Tipo_Formula FROM arquitectdb.categorias;";
    //--------------------------------------------------------------------------------------------------------------------------------
    // querys subComponentes
    public static String QUERY_EXITS_SUBCOMPONENTES = "SELECT true AS status FROM subcomponentes where Codigo_Homologacion = ?;";

    public static String QUERY_SUBCOMPONENTES = "CALL spSubComponenteConsultar('";

    public static String QUERY_SUBCOMPONENTES_CALC_CARGAR = "CALL spComponenteCargar(";

    public static String QUERY_SUBCOMPONENTES_CARGAR = "SELECT CONCAT(subcomponentes.Codigo_Homologacion,'-',acabados.Codigo_Homologacion) Codigo, "
            + "subcomponentes.Descripcion "
            + "FROM arquitectdb.subcomponentes "
            + "JOIN acabados ON acabados.Id_acabado = subcomponentes.Id_acabado"
            + " WHERE Id_subcomponente= ";

    public static String QUERY_INSERT_SUBCOMPONENTES = "CALL spSubComponenteRegistrar(?,?,?);";

    public static String QUERY_UPDATE_SUBCOMPONENTES = "CALL spSubcomponenteUpdate(?,?,?,?);";

    public static String QUERY_DELETE_SUBCOMPONENTES = "DELETE FROM arquitectdb.subcomponentes WHERE Id_subcomponente = ?";
    //--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_INSERT_CORTES = "INSERT cortes (Descripcion,Corte_Derecho,Corte_Izquierdo)VALUES(?,?,?);";

    public static String QUERY_SUBCOMPONENTES_FORM_CARGAR = "CALL spSubcomponenteCargar(?);";
    //---------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_INSERT_PROYECTO = "INSERT INTO proyecto "
            + "(Id_Subcomponente, "
            + " Id_Unidad_Medida, "
            + " cantidad, "
            + " medida) "
            + "VALUES (?,?,?,?)";
    public static String QUERY_GET_PROYECTO = "CALL spSubComponenteAgrupar();";

// static of system 
    public static String SELECTING = "-- Seleccionar --";
}
