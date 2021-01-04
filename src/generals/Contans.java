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

    public static String QUERY_ACABADO = "SELECT Id_Acabado, Descripcion FROM Acabados;";

    public static String QUERY_INSERT_ACABADOS = "INSERT acabados (Codigo_Homologacion, descripcion)VALUES(?,?)";
//--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_UNIDAD_MEDIDA = "SELECT Id_Unidad_Medida, Descripcion FROM Unidades_Medidas;";

    public static String QUERY_INSERT_UNIDAD_MEDIDA = "INSERT unidades_medidas (Descripcion,Convencion)VALUES(?,?);";
    //--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_COMPONENTES = "SELECT Id_Componente,Codigo,Descripcion FROM arquitectdb.componentes;";
    
    public static String QUERY_COMPONENTES_LISTAR = "CALL componentesConsultar('";

    public static String QUERY_COMPONENTES_CARGAR = "SELECT Codigo,Descripcion FROM arquitectdb.componentes WHERE Id_Componente = ?;";

     public static String QUERY_COMPONENTES_DETALLE_CARGAR = "CALL componenteDetalleCargar(?);";
     
    public static String QUERY_INSERT_COMPONENTES = "INSERT arquitectdb.componentes(codigo, descripcion) VALUES (?,?);";

    public static String QUERY_INSERT_COMPONENTE_DETALLE = "INSERT arquitectdb.componentes_detalle (Id_Componente, Id_Subcomponente) VALUES (?,?);";

    public static String QUERY_UPDATE_COMPONENTES = "CALL spComponenteActualizar(?,?,?);";

    public static String QUERY_DELETE_COMPONENTE = "DELETE FROM arquitectdb.componentes WHERE Id_Componente = ?;";

    public static String QUERY_DELETE_COMPONENTE_DETALLE = "DELETE FROM arquitectdb.componentes_detalle WHERE Id_Componente = ?;";

    //--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_CATEGORIAS = "SELECT Id_categoria,Descripcion,Tipo_Formula FROM arquitectdb.categorias;";
    //--------------------------------------------------------------------------------------------------------------------------------
    // querys subComponentes
    public static String QUERY_SUBCOMPONENTES = "CALL spSubComponenteConsultar('";

    public static String QUERY_SUBCOMPONENTES_CALC_CARGAR = "CALL spComponenteCargar(";

    public static String QUERY_SUBCOMPONENTES_CARGAR = "SELECT Codigo_Homologacion Codigo,Descripcion "
            + "                                         FROM arquitectdb.subcomponentes WHERE Id_subcomponente= ";

    public static String QUERY_INSERT_SUBCOMPONENTES = "CALL spSubComponenteRegistrar(?,?,?,?,?,?,?,?);";

    public static String QUERY_UPDATE_SUBCOMPONENTES = "CALL spSubcomponenteUpdate(?,?,?,?,?,?,?,?,?);";
    
     public static String QUERY_DELETE_SUBCOMPONENTES = "DELETE FROM arquitectdb.subcomponentes WHERE Id_subcomponente = ?";
    //--------------------------------------------------------------------------------------------------------------------------------
    public static String QUERY_INSERT_CORTES = "INSERT cortes (Descripcion,Corte_Derecho,Corte_Izquierdo)VALUES(?,?,?);";
    
    public static String QUERY_SUBCOMPONENTES_FORM_CARGAR = "SELECT `subcomponentes`.`Id_Acabado`,\n" +
                                                            "`subcomponentes`.`Id_Unidad`,\n" +
                                                            "`subcomponentes`.`Id_Unidad_Calculada`,\n" +
                                                            "`subcomponentes`.`Codigo_Homologacion`,\n" +
                                                            "`subcomponentes`.`Descripcion`,\n" +
                                                            "`subcomponentes`.`Cantidad_defaultd`,\n" +
                                                            "`subcomponentes`.`Aplica_decremento`,\n" +
                                                            "`subcomponentes`.`Cantidad_Adicional`\n" +
                                                            "FROM `arquitectdb`.`subcomponentes`;\n" +
                                                            "WHERE Id_Componente = ?;";

// static of system 
    public static String SELECTING = "-- Seleccionar --";
}
