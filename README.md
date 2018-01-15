# Configuration Manager Case Study

# Kullanılan Teknolojiler

Java 8

Spring SpringBoot 1.5.9

MongoDb 3.6.1

EhCache

Logback

Junit

JQuery

Bootstarp

Maven

Uygulamalar çalıştırılmadan önce MongoDb çalışır durumda olmalıdır.

# ConfigurationManagerWeb
Proje SpringBoot üzerine kurulmuştur,Uygulama başlatıldığında MongoDb üzerinde "configs" tablosu olup olmadığını kontrol eder. Yoksa oluşturup örnek kayıtları insert eder. Uygulama ayağa kalktığında

localhost:8080/config adresinden kayıtlar listelenir ve üzerinde filtreleme yapılabilir.

# ConfigurationManagerLib
Uygulama için hazırlanmış library'dir.Aşağıdaki gibi çalıştırılabilir.

ConfigurationManager cm = new ConfigurationManager("mongodb://localhost:27017", "SERVICE-A", 20);
cm.getValue("SiteManager")





