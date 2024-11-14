# Usar uma imagem leve do JDK 17
FROM openjdk:17


# Definir o diretório de trabalho dentro do container
WORKDIR /Curso


# Copiar o arquivo .jar gerado para o diretório do container
COPY target/*.jar /Curso/Curso-0.0.1-SNAPSHOT.jar
EXPOSE 8585


# Comando para executar a aplicação com Java 17
CMD ["java", "-jar", "Curso-0.0.1-SNAPSHOT.jar"]