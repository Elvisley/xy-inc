# Instruções para execução

1 - Você deve ter instalado o Java 1.8 acima
[*Clique aqui para baixar o Java.*]( http://www.oracle.com/technetwork/pt/java/javase/downloads/jre8-downloads-2133155.html)

2 - Você deve ter instalado o maven 3.0 na sua maquina
[*Clique aqui para baixar o maven.*](https://maven.apache.org/install.html)

3 - Após instalar as duas dependências acima, acesse o diretorio do projeto  pelo terminal e execute o comando 

```
mvn install

```

4 - Após a instalação dos pacotes do maven , acesse o diretorio do projeto  pelo terminal e execute o comando abaixo

```
mvn spring-boot:run	
```

## Executando os teste
 
Acesse o diretorio do projeto pelo terminal e execute o comando abaixo 
 
```
mvn test
```

## Executar os métodos utilizando Postman

Em anexo está o arquivo POI.postman_collection, usado para executar todos os métodos da aplicação direto pelo Postman.

[*Clique aqui para baixar o Postman.*](https://www.getpostman.com/)

[*Clique aqui para baixar o arquivo de importação do Postman*](https://raw.githubusercontent.com/Elvisley/xy-inc/master/POI.postman_collection)


## Executando o projeto pelo Jar

1 - Acesse o diretório do projeto pelo terminal e em seguida digite os seguintes comandos:

 ```
cd target
```

```
java -jar PontosReferencia-0.0.1-SNAPSHOT.jar
```

Neste momento o servidor interno do spring será iniciado e as requisições já poderão ser realizadas no endereço: http://localhost:8080/api/v1/poi
