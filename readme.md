# KURULUMLAR VE PROJE TEKNOLOJÝLERÝ

## Docker üzerinde postgreSQL kurulumu

```
   docker run  --name postgreSQL -e POSTGRES_PASSWORD=root -p 5432:5432 -d postgres
```

## Docker üzerinde mongoDB çalýþtýrmak

```bash
    docker run --name java13MongoDB -d -e "MONGO_INITDB_ROOT_USERNAME=admin" -e "MONGO_INITDB_ROOT_PASSWORD=root" -p 27017:27017 mongo:jammy 
```

     Yetkilendirme Ýþlemleri:
       1- MONGOSH'a týklayarak açýyorsunuz.
       2- Açýlan kýsýmda test> þeklinde bir yer göreceksiniz, öncelikle test DB'den kendi DB'nize geçmek için
          use [DB_adý] yazýp enter'a basýnýz.
          Örn:
           use UserProfile
           switched to db UserProfile
           UserProfile > þeklinde bir görüntü elde edeceksiniz.
       3- Burada kullanýcý oluturmak için gerekli komutlarý giriyoruz.
            db.createUser({
            user: "bilgeUser",
            pwd: "bilgeUser*",
            roles: ["readWrite","dbAdmin"]
            })
           db kýsmý da yazýlmalý girerken

```
     db.createUser({ user: "bilgeUser", pwd: "bilgeUser*", roles: ["readWrite","dbAdmin"]})
```
