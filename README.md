## HASTANE OTOMASYONU
>Bu projenin temel amacı, bir hastanede gerçekleşen temel hasta kabul işlemlerinin (hasta kaydı, hasta sorgulama, taburcu işlemleri vb.) dijital ortamda yönetilmesini sağlayan masaüstü bir yazılım geliştirmektir.

## PROJE TANITIMI
https://drive.google.com/file/d/1L_tcF0WqPHFuGBLhrw_jGNlehvmoOVXW/view?usp=sharing
## İÇİNDEKİLER 
- [ÖZELLİKLER](#ÖZELLİKLER)  
- [KURULUM](#KURULUM)  
- [KULLANIM](#KULLANIM)  
- [PROJE SAHİBİ](#PROJE-SAHİBİ)
- [LİSANS](#LİSANS)
## ÖZELLİKLER
- Hasta kayıt ve silme işlemleri
- Hastaların listelenmesi ve detaylı görüntülenmesi
- Kullanıcı giriş sistemi ve yetki kontrolü 
- MySQL veri tabanı bağlantısı için dinamik yapılandırma
- Kullanıcı dostu Swing tabanlı grafik arayüz
## KURULUM
1. Java 8 veya üstü yüklü olduğundan emin olun.
2. MySQL veri tabanını kurun ve aşağıdaki tablo yapısını oluşturun:
```
  CREATE DATABASE hastaneotomasyonu;
    USE hastaneotomasyonu;

    CREATE TABLE adminler (
      id INT AUTO_INCREMENT PRIMARY KEY,
      kullanici_adi VARCHAR(50),
      sifre VARCHAR(50)
    );


INSERT INTO adminler (kullanici_adi, sifre) VALUES ('admin', '1234');

CREATE TABLE hastalar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ad_soyad VARCHAR(100),
    tc_no VARCHAR(11),
    sikayet VARCHAR(255),
    oda_no VARCHAR(10),
    yatis_tarihi DATE
);
```
3. `VeriTabaniBaglantisi.java` dosyanızda veri tabanı bilgilerinizi girin:
```
   DB_URL = "jdbc:mysql://localhost:3306/hastaneotomasyonu";
```
# KULLANIM
1. Projeyi başlatmak için `GirisEkrani.java` sınıfını çalıştırın.
2. Kullanıcı adı ve şifre ile giriş yapın.
3. Yetkinize bağlı olarak hasta kayıt edebilir , silebilir ve listeleyebilirsiniz.
4. Menü üzerinden yapmak istediğiniz işlemi seçin.
# PROJE SAHİBİ
Bu proje Nesne Tabanlı Programlama dersi için bir uygulama şeklinde yapılmıştır.
-   Eylül Melike Baysal
-   Kerem Kasimoğlu
-   Kudret Efil
-   Havva Gülsüm Genç
# LİSANS
Bu proje [MIT Lisansı](LICENSE) kapsamında açık kaynak olarak sunulmuştur.  
Dilediğiniz gibi kullanabilir, değiştirebilir ve paylaşabilirsiniz — ancak orijinal geliştiriciyi belirtmeniz gerekir.

