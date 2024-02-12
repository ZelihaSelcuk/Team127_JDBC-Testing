Feature: UPDATE (update delete insert query leri)

Background: Database baglantisi
* Database baglantisi kurulur.

@query05
Scenario: "users" tablosunda sondan bir önceki harfi e olan "username" lerin "mobile" numarasını update ediniz.

  * Update query01 oluşturulur ve execute edilir.
  * Sonuclar doğrulanir.
  * Database baglantisi kapatilir.
@query06
Scenario: "users" tablosunda sondan bir önceki harfi e olan "username" lerin "mobile" numarasını update ediniz.

  * Prepared query02 oluşturulur ve execute edilir.
  * Prepared query02 Sonuclar doğrulanir.
  * Database baglantisi kapatilir.

@query07
Scenario: admin_password_reset tablosunda id, email, token,status, created_at veri girişi yapınız.

  * Prepared query03 oluşturulur ve execute edilir.
  * Prepared query03 Sonuclar doğrulanir.
  * Database baglantisi kapatilir.

@query08
Scenario: admin notifications tablosundan id=? olan kullanıcının "is_read= 0 " olan bildirimlerini "1" olarak update edip doğrulayın.

  * Prepared query8 oluşturulur ve execute edilir.
  * Prepared query8 Sonuclar doğrulanir.
  * Database baglantisi kapatilir.

@query09
Scenario: "update_logs" tablosunda "version=?" ve "id=?" olan datanın "update_log"değerini update edip doğrulayın.

  * update_logs tablosuna insert query hazirlanir ve calistirilir.
  * update_logs tablosuna insert edilen datanın update log degeri degistirilir.
  * Update log degerinin degistigi dogrulanir.
  * Database baglantisi kapatilir.

@qyery10
Scenario: Update_logs tablosunda "id=?" degerine gore bir datayı siliniz ve silindigini dogrulayiniz.

  * update_logs tablosuna insert query hazirlanir ve calistirilir.
  * update_logs tablosuna insert edilen data silinir.
  * Satirin silindigi dogrulanir.
  * Database baglantisi kapatilir.


@query11
Scenario: "support_attacments"  tablosunda "support_message_id=?" değerine gore
            bir dosyayi siliniz ve silindiğini doğrulayiniz.

  # önce insert sonra delete yapariz.
  # insert isleminde daha dinamik olmasi icin faker class ina deger urettiririz.
  # insert ettigimiz faker degerlerine sahip datayi yine faker degerlerini alarak delete ederiz.

  * support_attacments tablosuna insert query hazirlanir ve calistirilir.
  * support_attacments tablosuna insert edilen data silinir.
  * satirin silindigi dogrulanir.
  * Database baglantisi kapatilir.