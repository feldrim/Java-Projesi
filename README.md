# Java-Projesi
Java ve NYP dersi projesi

1. Her bir emir 1'den başlayan sıra numarasına sahip olacaktır. Emir numaraları verilme sırasına göredir.
2. Emir veren komutanın apolet numarası, emrin verildiği tarih ve emrin uygulanacağı tarih tutulmaktadır.
3. Emir tekrarlanabilir. En fazla 5 tekrar mümkün olacaktır. Bunun için veriliş tarihi aynı, uygulama tarihi ardışık 5 gün olacak emirler yaratılacaktır.
4. Emrin uygulama tarihi, veriliş tarihinden en fazla 10 gün sonra olabilir, geri de olma şansı yoktur.
5. Emir veren komutanın sistemde kayıtlı olup olmadığı kontrol edilecektir.
6. 2 tür emir vardır: TemizlikEmri, SporEmri. TemizlikEmri bölge adı, temizlik türü (mıntıka, kış temizliği, peyzaj) ve katılacak kişi sayısını; SporEmri hareket türü ve tekrar sayısını içerecektir.
7. Sistemde 2 komutan türü vardır: A ve B. Bir A bir gün içerisinde en fazla 2, tüm A'lar bir günde en fazla 5 emir verebilir. B'nin verdiği emir, bir önceki ile aynı tür olamaz.
8. Kullanıcıdan asgari olarak günün tarihi istenecek, komutan ekleme, emir ekleme ve gün sonu raporu alma seçenekleri sunulacaktır.
9. Bugünün emirlerinin listelenmesi, emir numarası girilen emirlerin uygulanması da sunulacaktır. Uygulama, emrin özelliklerini ekrana UYGULANDI ibaresi ile birlikte yazdırmak biçiminde gerçekleşecektir.
10. Gün sonu ile o gün tamamlanan emirler, o gün verilen emirler, o gün verilenlerden tamamlananların bilgisi verilecek ve sonraki güne geçilecektir.
11. Komutan sayısı 20, emir sayısı 100 ile sınırlandırılmıştır. Yeni komutan ve emir eklenmek istendiğinde hata mesajı verilecektir.
12. Emir ve komutan dizileri ata sınıfta tanımlanacaktır.
13. Hareket türü string biçiminde olacaktır (Kaçınılmaz olarak).
14. Emir uygulama işi çokbiçimli olacaktır.

Ek:
1. Array yerine vector kullanılacaktır.
2. Komutan ve Emir dizileri ayrı bir sınıf içinde yazılacak, ekleme ve sorgulama gibi işlemler burada yapılacaktır.
3. Geçerli tarih kontrolü Tarih nesnesi içinde yapılacaktır.
4. Exception check konusuna bakılarak hata durumları exception check ile ele alınacaktır.
