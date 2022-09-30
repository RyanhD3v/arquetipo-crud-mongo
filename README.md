# arquetipo-crud-mongo
Arquetipo para una conexión con certificado JKS a un Mongo en la nube u On-premiss

# Instrucciones

- Cambia el application.properties
- En caso de ocupar Certificados JKS agregalos al directorio de documentdb
- puedes dockerizar para probar(antes compila y asegurate que en la carpeta target tenga el mismo nombre el jar que en el Dockerfile)
    -docker build -t nombreImagen:tag .
    -docker run -it -p 8081:8081 --network="host"  microservice_name_imagen:tag
