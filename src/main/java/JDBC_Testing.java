import javax.xml.transform.Result;
import java.sql.*;

public class JDBC_Testing {

/*
herhangi bir jdbc çalışması için yapmam gereken ilk iş
aşağıdaki bilgileri database yöneticisinden istemek


    type: jdbc:mysql
    host/ip: 45.87.83.5
    port: 3306
    database_name: u168183796_qaloantec
    username: u168183796_qaloantecuser
    password: 0&vG1A/MuWN

    url= type :// host ip /database_name
    url = jdbc:mysql://45.87.83.5/u168183796_qaloantec  // biz oluşturduk yukaıdaki bilgilerden
    username: u168183796_qaloantecuser
    password: 0&vG1A/MuWN

*/


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1. adım doğru sürücüyü yükle

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. adım veritabanı ile iletişimi başlat

        Connection connection = DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qaloantec", "u168183796_qaloantecuser", "0&vG1A/MuWN");

        // 3. adım SQL Query leri oluştur ve execute et

        String query = "select * from u168183796_qaloantec.users";

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // Statement olusturmak icin mutlaka bir connection olmasi gerekli.
        // create edilen statement bir query calistirilacaksa atama yapilmadan kullanilabilir.
        // Ancak defalarca kullanilmak isteniyorsa atama yapilip kullanilabilir.


        // 4. ADIM: QUERY EXECUTE ET



      /*
      statement.executeQuery(query);

      connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery(query);

        Yukaridaki iki ifade de aynidir.
       */

        ResultSet resultSet = statement.executeQuery(query);

        // 5. ADIM: SONUCLARI ISLE


        resultSet.next();  // iterator'i ilk satira koymus olduk
        System.out.println(resultSet.getString("firstname"));
        // Mehmet

        resultSet.next();  // 2. satir
        System.out.println(resultSet.getString("firstname"));
        // Test

        resultSet.next(); // 3. satir
        System.out.println(resultSet.getString("lastname"));
        // Genc

        System.out.println(resultSet.getString("email"));
        // mcenkk@gmail.com

        resultSet.absolute(10); // 10. satir
        System.out.println(resultSet.getString("firstname"));
        // Ahmet

        resultSet.first();
        System.out.println(resultSet.getString("email"));
        // elff931@gmail.com

        resultSet.first();
        System.out.println(resultSet.getString("lastname"));

        resultSet.first();
        System.out.println(resultSet.getString("email"));




    }



    }




