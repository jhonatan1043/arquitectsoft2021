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
    // -----------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_CORTE = "SELECT Id_Corte codigo, Descripcion FROM cortes;";
    //--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_ACABADO = "SELECT Codigo_Homologacion codigo, Descripcion FROM Acabados;";

    public static String QUERY_INSERT_ACABADOS = "INSERT acabados (Codigo_Homologacion, descripcion)VALUES(?,?)";
//--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_UNIDAD_MEDIDA = "SELECT Id_Unidad_Medida, Descripcion FROM Unidades_Medidas;";

    public static String QUERY_INSERT_UNIDAD_MEDIDA = "INSERT unidades_medidas (Descripcion,Convencion)VALUES(?,?);";
    //--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_EXITS_COMPONENTES = "SELECT true AS status FROM componentes where Codigo = ?;";

    public static String QUERY_COMPONENTES = "SELECT Id_Componente,Codigo,Descripcion,NoSubcomponente FROM arquitectdb.componentes;";

    public static String QUERY_COMPONENTES_LISTAR = "CALL componentesConsultar('";

    public static String QUERY_COMPONENTES_CARGAR = "SELECT Codigo,Descripcion,NoSubcomponente FROM arquitectdb.componentes WHERE Id_Componente = ?;";

    public static String QUERY_COMPONENTES_DETALLE_CARGAR = "CALL componenteDetalleCargar(?);";

    public static String QUERY_INSERT_COMPONENTES = "INSERT arquitectdb.componentes(codigo, descripcion, NoSubcomponente) VALUES (?,?,?);";

    public static String QUERY_INSERT_COMPONENTE_DETALLE = "INSERT arquitectdb.componentes_detalle (Id_Componente,"
            + " Id_Subcomponente,"
            + " Id_Unidad_Calculada,"
            + " Cantidad_Default,"
            + " Cantidad_Adicional,"
            + " Aplica_Decremento, "
            + " elevado," 
            + " idCorte )VALUES(?,?,?,?,?,?,?,?);";

    public static String QUERY_UPDATE_COMPONENTES = "CALL spComponenteActualizar(?,?,?,?);";

    public static String QUERY_DELETE_COMPONENTE = "DELETE FROM arquitectdb.componentes WHERE Id_Componente = ?;";

    public static String QUERY_DELETE_COMPONENTE_DETALLE = "DELETE FROM arquitectdb.componentes_detalle WHERE Id_Componente = ?;";

    //-----------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_COMPONENTES_ESPECIAL = "SELECT Id_Componente_Especial,Codigo,Descripcion FROM arquitectdb.componentes_especial;";

    public static String QUERY_COMPONENTES_ESPECIAL_LISTAR = "CALL componentesEspecialConsultar('";

    public static String QUERY_EXITS_COMPONENTES_ESPECIAL = "SELECT true AS status FROM componentes_Especial where Codigo = ?;";

    public static String QUERY_COMPONENTES_ESPECIAL_CARGAR = "SELECT Codigo,Descripcion FROM arquitectdb.componentes_Especial WHERE Id_Componente_especial = ?;";

    public static String QUERY_UPDATE_COMPONENTES_ESPECIAL = "CALL spComponenteEspecialActualizar(?,?,?);";

    public static String QUERY_COMPONENTES_ESPECIAL_DETALLE_CARGAR = "CALL componenteEspecialDetalleCargar(?);";

    public static String QUERY_INSERT_COMPONENTES_ESPECIAL = "INSERT arquitectdb.componentes_especial(codigo, descripcion) VALUES (?,?);";

    public static String QUERY_INSERT_COMPONENTE_ESPECIAL_DETALLE = "INSERT arquitectdb.componentes_especial_detalle (Id_Componente_especial,"
            + " Id_Subcomponente,"
            + " select_Columna, "
            + " Cantidad_Default,"
            + " Cantidad_Adicional,"
            + " Aplica_Decremento,"
            + " elevado,"
            + " idCorte)"
            + " VALUES (?,?,?,?,?,?,?,?);";

    public static String QUERY_DELETE_COMPONENTE_ESPECIAL = "DELETE FROM arquitectdb.componentes_especial WHERE Id_Componente_especial = ?;";

    public static String QUERY_DELETE_COMPONENTE_ESPECIAL_DETALLE = "DELETE FROM arquitectdb.componentes_especial_detalle WHERE Id_Componente_Especial = ?;";
    //--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_CATEGORIAS = "SELECT Id_categoria,Descripcion,Tipo_Formula FROM arquitectdb.categorias;";
    //--------------------------------------------------------------------------------------------------------------------------------
    // querys subComponentes
    public static String QUERY_EXITS_SUBCOMPONENTES = "SELECT true AS status FROM subcomponentes where Codigo_Homologacion = ?;";

    public static String QUERY_SUBCOMPONENTES = "CALL spSubComponenteConsultar('";

    public static String QUERY_SUBCOMPONENTES_ESPECIAL = "CALL spSubComponenteEspecialConsultar('";

    public static String QUERY_SUBCOMPONENTES_CALC_CARGAR = "CALL spComponenteCargar(";

    public static String QUERY_SUBCOMPONENTES_CARGAR = "SELECT CONCAT(subcomponentes.Codigo_Homologacion,'-',acabados.Codigo_Homologacion) Codigo, "
            + "subcomponentes.Descripcion "
            + "FROM arquitectdb.subcomponentes "
            + "JOIN acabados ON acabados.Id_acabado = subcomponentes.Id_acabado"
            + " WHERE Id_subcomponente= ";

    public static String QUERY_INSERT_SUBCOMPONENTES = "CALL spSubComponenteRegistrar(?,?,?,?);";

    public static String QUERY_UPDATE_SUBCOMPONENTES = "CALL spSubcomponenteUpdate(?,?,?,?,?);";

    public static String QUERY_DELETE_SUBCOMPONENTES = "DELETE FROM arquitectdb.subcomponentes WHERE Id_subcomponente = ?";
    //--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_INSERT_CORTES = "INSERT cortes (Descripcion,Corte_Derecho,Corte_Izquierdo)VALUES(?,?,?);";

    public static String QUERY_SUBCOMPONENTES_FORM_CARGAR = "CALL spSubcomponenteCargar(?);";
    //---------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_INSERT_PROYECTO = "INSERT INTO proyecto "
            + "(Id_Subcomponente, "
            + " Id_Unidad_Medida, "
            + " cantidad, "
            + " medidaAdicional,"
            + " medida) "
            + "VALUES (?,?,?,?,?)";

    public static String QUERY_INSERT_PROYECTO_VIDRIO_PANEL = "INSERT INTO proyecto_vp "
            + "(Id_Subcomponente,"
            + "Id_Unidad_Medida, "
            + "Altura, "
            + "Anchura,"
            + "Cantidad,"
            + "medida,"
            + "medidaAdicional) "
            + "VALUES (?,?,?,?,?,?,?)";

    public static String QUERY_INSERT_PROYECT_MAMPARA = "INSERT proyecto_mp(codigo,descripcion,medida)Values(?,?,?)";

    public static String QUERY_GET_PROYECTO = "CALL spSubComponenteAgrupar();";

    public static String QUERY_GET_PROYECTO_VIDRIO_PANEL = "CALL spSubComponenteVidrioPanelAgrupar();";

    public static String QUERY_GET_PROYECTO_MAMPARA = "CALL spSubComponenteMamparaAgrupar();";

// static of system 
    public static String SELECTING = "-- Seleccionar --";
}
