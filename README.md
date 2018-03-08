# Java-Projesi

## Mimari
Projenin Sınıf diyagramı Visual Paradigm ile reverse edilerek elde edilmiştir. Büyük boyutu için [buraya](https://raw.githubusercontent.com/feldrim/Java-Projesi/Proje/Class%20Diagram.jpg) tıklayın.

![UML Diyagramı](https://github.com/feldrim/Java-Projesi/blob/Proje/Class%20Diagram.jpg)

## İsterler

- [X] Her bir emir 1'den başlayan sıra numarasına sahip olacaktır. Emir numaraları verilme sırasına göredir.
- [X] Emir veren komutanın apolet numarası, emrin verildiği tarih ve emrin uygulanacağı tarih tutulmaktadır.
- [X] Emir tekrarlanabilir. En fazla 5 tekrar mümkün olacaktır. Bunun için veriliş tarihi aynı, uygulama tarihi ardışık 5 gün olacak emirler yaratılacaktır.
- [X] Emrin uygulama tarihi, veriliş tarihinden en fazla 10 gün sonra olabilir, geride olma şansı yoktur.
- [X] Emir veren komutanın sistemde kayıtlı olup olmadığı kontrol edilecektir.
- [X] 2 tür emir vardır: TemizlikEmri, SporEmri. TemizlikEmri bölge adı, temizlik türü (mıntıka, kış temizliği, peyzaj) ve katılacak kişi sayısını; SporEmri hareket türü ve tekrar sayısını içerecektir.
- [X] Sistemde 2 komutan türü vardır: A ve B. Bir A bir gün içerisinde en fazla 2, tüm A'lar bir günde en fazla 5 emir verebilir. B'nin verdiği emir, bir önceki ile aynı tür olamaz.
- [X] Kullanıcıdan asgari olarak günün tarihi istenecek, komutan ekleme, emir ekleme ve gün sonu raporu alma seçenekleri sunulacaktır.
- [X] Bugünün emirlerinin listelenmesi, emir numarası girilen emirlerin uygulanması da sunulacaktır. Uygulama, emrin özelliklerini ekrana UYGULANDI ibaresi ile birlikte yazdırmak biçiminde gerçekleşecektir.
- [X] Gün sonu ile o gün tamamlanan emirler, o gün verilen emirler, o gün verilenlerden tamamlananların bilgisi verilecek ve sonraki güne geçilecektir.
- [X] Komutan sayısı 20, emir sayısı 100 ile sınırlandırılmıştır. Yeni komutan ve emir eklenmek istendiğinde hata mesajı verilecektir.
- [X] Emir ve komutan dizileri ata sınıfta tanımlanacaktır.
- [X] Hareket türü string biçiminde olacaktır (Kaçınılmaz olarak).
- [X] Emir uygulama işi çokbiçimli olacaktır.

## Not:

Bug ve geliştirmeler issue içinde yer alacak.
