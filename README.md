# Análise de Vendas

Este projeto é uma aplicação Java para análise de dados de vendas a partir de um arquivo CSV. A aplicação lê os dados do arquivo, processa-os e exibe o total vendido por cada vendedor.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes principais:

- `CsvReader`: Classe responsável por ler os dados de vendas de um arquivo CSV e retornar uma lista de objetos `Sale`.
- `Sale`: Classe modelo que representa uma venda, contendo atributos como mês, ano, vendedor, itens e total.
- `Program`: Classe principal que executa a aplicação, processa os dados de vendas e exibe os resultados.

## Funcionalidades

1. **Leitura de Arquivo CSV**:
   - A classe `CsvReader` lê um arquivo CSV e converte cada linha em um objeto `Sale`.
   - Os dados são armazenados em uma lista de objetos `Sale`.

2. **Processamento de Dados**:
   - A classe `Program` utiliza Streams e lambdas para processar os dados de vendas.
   - Gera um conjunto de nomes únicos de vendedores.
   - Calcula o total vendido por cada vendedor.

3. **Exibição de Resultados**:
   - A aplicação exibe o total vendido por cada vendedor no console.

## Como Executar

1. Clone o repositório para sua máquina local:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd seu-repositorio
   ```

3. Compile o projeto:
   ```bash
   javac -d bin src/com/desafio/**/*.java
   ```

4. Execute a aplicação:
   ```bash
   java -cp bin com.desafio.main.Program
   ```

5. Insira o caminho completo do arquivo CSV quando solicitado.

## Exemplo de Arquivo CSV

O arquivo CSV deve ter o seguinte formato:

```csv
month,year,seller,items,total
1,2020,Logan,10,500.0
2,2020,Emma,5,300.0
3,2020,Logan,8,400.0
...
```

## Contribuição

Se você deseja contribuir com este projeto, siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie uma nova branch:
   ```bash
   git checkout -b minha-nova-feature
   ```
3. Faça suas alterações e commit:
   ```bash
   git commit -m 'Adiciona nova feature'
   ```
4. Envie para o repositório remoto:
   ```bash
   git push origin minha-nova-feature
   ```
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
