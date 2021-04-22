# Conversion Units

Uma aplicação que converte unidades para o Sistema Internacional, e calcula um fator de conversão.

### Rodando a aplicação

Criar o arquivo .jar:

$> mvn clean package

Agora, para criar a imagem Docker utilizar o comando:

$> docker build --tag=conversionunits:latest .

Por fim, é possivel rodar o conteiner da imagem:

$> docker run -p8080:8080 conversionunits:latest

Pronto, a aplicação estará rodando no http://localhost:8080/units/si?units=({variables})

Será possível testar ao colocar em {variables} o valor degree/minute, por exemplo:

// http://localhost:8080/units/si?units=(degree/minute)

{
  "unit_name": "(rad/s)",
  "multiplication_factor": 0.00029088820866572163
}
