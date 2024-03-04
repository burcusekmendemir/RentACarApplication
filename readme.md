# KURULUMLAR VE PROJE TEKNOLOJ�LER�

## Docker �zerinde postgreSQL kurulumu

```
   docker run  --name postgreSQL -e POSTGRES_PASSWORD=root -p 5432:5432 -d postgres
```

## Docker �zerinde mongoDB �al��t�rmak

```bash
    docker run --name java13MongoDB -d -e "MONGO_INITDB_ROOT_USERNAME=admin" -e "MONGO_INITDB_ROOT_PASSWORD=root" -p 27017:27017 mongo:jammy 
```

     Yetkilendirme ��lemleri:
       1- MONGOSH'a t�klayarak a��yorsunuz.
       2- A��lan k�s�mda test> �eklinde bir yer g�receksiniz, �ncelikle test DB'den kendi DB'nize ge�mek i�in
          use [DB_ad�] yaz�p enter'a bas�n�z.
          �rn:
           use UserProfile
           switched to db UserProfile
           UserProfile > �eklinde bir g�r�nt� elde edeceksiniz.
       3- Burada kullan�c� oluturmak i�in gerekli komutlar� giriyoruz.
            db.createUser({
            user: "bilgeUser",
            pwd: "bilgeUser*",
            roles: ["readWrite","dbAdmin"]
            })
           db k�sm� da yaz�lmal� girerken

```
     db.createUser({ user: "bilgeUser", pwd: "bilgeUser*", roles: ["readWrite","dbAdmin"]})
```
