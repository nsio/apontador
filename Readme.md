## Docker
	- O docker-compose está no diretório raiz, então para executar, ele precisa estar em uma pasta, que contenha o docker-compose.yml, uma pasta locais-api (contendo todos os arquivos do projeto da API) e um diretório locais-front (contendo todos os arquivos do projeto do front). No repositório do git já esta com essa estrura.
	- Importante, vai notar que o meu docker-compose contem os caminhos para para o dockerfile de cada projeto, é necessário que edite o docker-compose para os caminhos que os arquivos estão localizado na estrutura de pastas da sua máquina. É preciso editar o dockerfile do porjeto do front, coloando o caminho correto da aplicação conforma estrutura da sua máquina. O dockerfile do projeto da API, será necessário editar também, caso o jar que você gerar com o mvn package estja em um caminho difereten de /target/

## API
	- Recursos:
		POST: http://localhost:8080/locais-api/locais
			- Exemplo de playload:
			{
				"descricao":"aaaaa",
				"telefone":"99999999",
				"endereco":{
					"cep":"000000",
					"bairro":"Bairro",
					"cidade":"Cidade",
					"endereco":"Rua Nova",
					"complemento":"Casa",
					"numero":1
				}
			}

		GET: http://localhost:8080/locais-api/locais/{chavePesquisa}?page=0&size=2
			- Retorna a lista de locais para pesquisa feita, paginada