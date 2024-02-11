package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import manage.QueryManage;
import utilities.JDBCReusableMethods;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;



public class StepDefinition {

    ResultSet resultSet;
    String query;
    int rowCount;
    PreparedStatement preparedStatement;
    QueryManage queryManage = new QueryManage();
    Faker faker = new Faker();
    int id;
    String name;
    String description;
    String version;
    String updateLog;

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {

        JDBCReusableMethods.getConnection();
        JDBCReusableMethods.getConnection();
    }
    @Given("Query01 hazirlanir ve execute edilir.")
    public void query01_hazirlanir_ve_execute_edilir() throws SQLException {

        query = queryManage.getQuery01();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

        /*
        reusable method kullanmadan da execute işlemi  aşağıdaki gibi uzun uzun yazılabilir.
        JDBCReusableMethods.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery(query);
        */

    }
    @Given("ResultSet01 sonuclari islenir.")
    public void result_set01_sonuclari_islenir() throws SQLException {
            // 1. satırın 1. sutunu "1" mi diye kontrol edicez. biz öyle karar verdik.

        resultSet.next();
        int actualUserID =resultSet.getInt("user_id");
        int expectedUserID = 1;

        assertEquals(expectedUserID,actualUserID);

    }
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        JDBCReusableMethods.closeConnection();

    }


    // --------------QUERY02--------------
    @Given("Query02 hazirlanir ve execute edilir.")
    public void query02_hazirlanir_ve_execute_edilir() throws SQLException {
        query = queryManage.getQuery02();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

    }
    @Given("ResultSet02 sonuclari islenir.")
    public void result_set02_sonuclari_islenir() throws SQLException {

        List<String> isimler = new ArrayList<>();
        while(resultSet.next()) {
            String isim = resultSet.getString("name");
            isimler.add(isim);
            }
        
        List<String> expectedName = new ArrayList<>();
        expectedName.add("5 Minutes");
        expectedName.add("10 Minutes");

        for(int i = 0; i < isimler.size(); i++){
            assertEquals(expectedName.get(i),isimler.get(i));
            System.out.println(i +". index dogrulandi");
        }


    }
/*
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        JDBCReusableMethods.closeConnection();
    }

 */

    // -------------------QUERY03-----------------


    @Given("Query03 hazirlanir ve execute edilir.")
    public void query03_hazirlanir_ve_execute_edilir() throws SQLException {
    query = queryManage.getQuery03();
    resultSet=JDBCReusableMethods.getStatement().executeQuery(query);


    }
    @Given("ResultSet03 sonuclari islenir.")
    public void result_set03_sonuclari_islenir() throws SQLException {
        String expectedName = "Mehmet Genç";
        resultSet.next();
        String actualName = resultSet.getString("firstname")+ " " + resultSet.getString("lastname");

        assertEquals(expectedName,actualName);
        System.out.println(expectedName);
        System.out.println(actualName);
    }

// -------------------Query04----------------


    @Given("Query04 hazirlanir ve execute edilir.")
    public void query04_hazirlanir_ve_execute_edilir() throws SQLException {
      query = queryManage.getQuery04();
      resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

    }
    @Given("ResultSet04 sonuclari islenir.")
    public void result_set04_sonuclari_islenir() throws SQLException {

    while(resultSet.next()){
    String kullanici_id = resultSet.getString("user_id");
    String browserOS = resultSet.getString("browser_os");
        System.out.println("kullanici_id"+ kullanici_id);
        System.out.println("browser_os" + browserOS);
}


    }

// -------------------UPDATE QUERY (STATEMENT İLE) --------------------
// "users" tablosunda sondan bir önceki harfi e olan "username" lerin "mobile" numarasını update ediniz."

    @Given("Update query01 oluşturulur ve execute edilir.")
    public void update_query01_oluşturulur_ve_execute_edilir() throws SQLException {

       query= queryManage.getUpdateQuery05();
       rowCount = JDBCReusableMethods.getStatement().executeUpdate(query);
       // ya da yeni oluşturulan JDBCreusable  method ile aşağıdaki gibi yapılır
        // rowCount = JDBCReusableMethods.updateQuery(query);
    }
    @Given("Sonuclar doğrulanir.")
    public void sonuclar_doğrulanir() {

    int expectedRowCount=18;  // sayarak gördük
    assertEquals(expectedRowCount,rowCount);


    }

// -------------  UPDATE QUERY (PREPARED  STATEMENT) --------------
    @Given("Prepared query02 oluşturulur ve execute edilir.")
    public void prepared_query02_oluşturulur_ve_execute_edilir() throws SQLException {

       query= queryManage.getPreparedQuery05();
       preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
       preparedStatement.setInt(1,444444444);
       preparedStatement.setString(2,"%e_");
       rowCount=preparedStatement.executeUpdate();

    }
    @Given("Prepared query02 Sonuclar doğrulanir.")
    public void prepared_query02_sonuclar_doğrulanir() {


        assertEquals(18,rowCount);
    }

    // -------------  UPDATE QUERY03 (PREPARED  STATEMENT) --------------

    // Catagories tablosuna sadece "id,name,discription" içeren datayı ekleyiniz.Eklendiğini Doğrulayınız.
    @Given("Prepared query03 oluşturulur ve execute edilir.")
    public void prepared_query03_oluşturulur_ve_execute_edilir() throws SQLException {

        // INSERT INTO admin_password_resets (id,email,token,status) VALUES (?,?,?,?);

        query=queryManage.getPreparedQuery06();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,889);
        preparedStatement.setString(2, "zsa@gmail.com");
        preparedStatement.setString(3,"456");
        preparedStatement.setInt(4,1);
        rowCount=preparedStatement.executeUpdate();

    }
    @Given("Prepared query03 Sonuclar doğrulanir.")
    public void prepared_query03_sonuclar_doğrulanir() {

        assertEquals(1,rowCount);

    }

// Scenario: admin notifications tablosundan id=? olan kullanıcının "is_read= 0 " olan bildirimlerini "1" olarak update edip doğrulayın.

    @Given("Prepared query8 oluşturulur ve execute edilir.")
    public void prepared_query8_oluşturulur_ve_execute_edilir() throws SQLException {
    query=queryManage.getPreparedQuery08();
    preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

    preparedStatement.setInt(1,1);
    preparedStatement.setInt(2,888);

    rowCount=preparedStatement.executeUpdate();

    }
    @Given("Prepared query8 Sonuclar doğrulanir.")
    public void prepared_query8_sonuclar_doğrulanir() {

    assertEquals(1,rowCount);

    }

// "update_logs" tablosunda "version=?" ve "id=?" olan datanın "update_log"değerini update edip doğrulayın.

// önce kendi test datamızı oluşturup sonra onu update edelim ..


    @Given("update_logs tablosuna insert query hazirlanir ve calistirilir.")
    public void update_logs_tablosuna_insert_query_hazirlanir_ve_calistirilir() throws SQLException {

       query=queryManage.getPreparedQuery09();
       preparedStatement= JDBCReusableMethods.getConnection().prepareStatement(query);

       id=faker.number().numberBetween(450,550);
       version=faker.options().option("windows 10", "linux", "MacOS Ventura");
       updateLog=faker.lorem().sentence(2);

       preparedStatement.setInt(1,id);
       preparedStatement.setString(2,version);
       preparedStatement.setString(3,updateLog);
       preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));

       rowCount=preparedStatement.executeUpdate();

       int flag=0;
       if (rowCount>0){
           flag++;
       }
               assertEquals(1,flag);

    }
    @Given("update_logs tablosuna insert edilen datanın update log degeri degistirilir.")
    public void update_logs_tablosuna_insert_edilen_datanın_update_log_degeri_degistirilir() throws SQLException {

        query=queryManage.getPreparedQuer09Update();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(query);
        String updateLogYeni = "yenilog";

        preparedStatement.setString(1,updateLogYeni);
        preparedStatement.setString(2,version);
        preparedStatement.setInt(3,id);

        rowCount=0;
        rowCount=preparedStatement.executeUpdate();

        System.out.println("girilen id : "+ id);

    }
    @Given("Update log degerinin degistigi dogrulanir.")
    public void update_log_degerinin_degistigi_dogrulanir() {

        assertEquals(1,rowCount);

    }







































// ----------------- çalışmalarım ------------------------------------
    @Given("Prepared query08 oluşturulur ve execute edilir.")
    public void prepared_query08_oluşturulur_ve_execute_edilir() throws SQLException {
        query = queryManage.getQuery88();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(query);
        id = faker.number().numberBetween(11000,11500);
        name= faker.name().fullName();
        description=faker.lorem().sentence(5);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,description);
        rowCount=preparedStatement.executeUpdate();

        System.out.println(id+" "+name+" "+description);

    }
    @Given("Prepared query08 Sonuclar doğrulanir.")
    public void prepared_query08_sonuclar_doğrulanir() {
       assertEquals(1,rowCount);

    }




}
