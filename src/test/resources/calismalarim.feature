Feature: UPDATE (update delete insert query leri)

  Background: Database baglantisi
    * Database baglantisi kurulur.

@query88
Scenario: Catagories tablosuna sadece "id,name,discription" içeren datayı ekleyiniz.Eklendiğini Doğrulayınız.

* Prepared query08 oluşturulur ve execute edilir.
* Prepared query08 Sonuclar doğrulanir.
* Database baglantisi kapatilir.