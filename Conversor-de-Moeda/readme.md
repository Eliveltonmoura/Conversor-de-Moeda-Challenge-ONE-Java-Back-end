# 💱 Conversor de Moedas

Um aplicativo Java para consultar taxas de câmbio em tempo real usando a ExchangeRate-API. Permite visualizar taxas de conversão e realizar conversões entre diferentes moedas.

## ✨ Funcionalidades

- ✅ Consulta de taxas de câmbio em tempo real
- ✅ Suporte para mais de 160 moedas diferentes
- ✅ Conversão de valores entre moedas
- ✅ Interface interativa via terminal
- ✅ Tratamento robusto de erros
- ✅ Formatação amigável dos resultados

## 📋 Pré-requisitos

- Java 17 ou superior
- Maven 3.6+ (ou IDE com suporte a Maven)
- Conexão com internet para acessar a API
- Chave de API gratuita da [ExchangeRate-API](https://www.exchangerate-api.com/)

## 🚀 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/conversor-moedas.git
cd conversor-moedas
```

### 2. Configure a API Key

Edite o arquivo `ConsultarMoeda.java` e substitua a chave de API:

```java
private static final String API_KEY = "SUA_CHAVE_AQUI";
```

Para obter uma chave gratuita:
1. Acesse [ExchangeRate-API](https://www.exchangerate-api.com/)
2. Cadastre-se gratuitamente
3. Copie sua chave de API

### 3. Compile o projeto

#### Usando Maven:
```bash
mvn clean compile
```

#### Usando IDE (Eclipse/IntelliJ):
- Importe como projeto Maven
- Espere as dependências serem baixadas
- Execute a classe `Principal.java`

## 🏗️ Estrutura do Projeto

```
conversor-moedas/
├── src/main/java/
│   ├── Principal.java          # Classe principal com interface do usuário
│   ├── ConsultarMoeda.java     # Classe para consultar a API
│   └── Moeda.java              # Record para representar os dados
├── pom.xml                     # Configuração do Maven
└── README.md                   # Este arquivo
```

## 📦 Dependências

- **Gson 2.10.1**: Para parsing de JSON
- **Java HTTP Client**: Incluído no Java 11+

## 🎯 Como Usar

### Executando o programa:

```bash
mvn exec:java -Dexec.mainClass="Principal"
```

Ou execute pela sua IDE.

### Fluxo de uso:

1. O programa iniciará exibindo um menu de boas-vindas
2. Digite o código da moeda base (ex: USD, EUR, BRL)
3. Visualize as taxas de conversão disponíveis
4. Escolha fazer uma conversão específica
5. Digite o valor e a moeda de destino
6. Veja o resultado da conversão

### Exemplo de uso:

```
Digite o código da moeda base (ex: USD, EUR, BRL): 
USD

RESULTADO DA CONSULTA:
Moeda base: USD
Status: success

Taxas de conversão disponíveis:
USD: 1.0000
EUR: 0.9200
BRL: 4.9500
GBP: 0.7900
JPY: 148.5000

Deseja fazer uma conversão específica? (S/N)
S

Digite o código da moeda de destino (ex: EUR, JPY): 
BRL
Digite o valor para converter: 
100

RESULTADO DA CONVERSÃO:
100.00 USD = 495.00 BRL
Taxa: 1 USD = 4.9500 BRL
```

## 📚 Códigos de Moeda Suportados

Alguns exemplos de códigos suportados:

| Código | Moeda | País |
|--------|-------|------|
| USD | Dólar Americano | Estados Unidos |
| EUR | Euro | União Europeia |
| BRL | Real | Brasil |
| GBP | Libra Esterlina | Reino Unido |
| JPY | Iene | Japão |
| CNY | Yuan | China |
| CAD | Dólar Canadense | Canadá |
| AUD | Dólar Australiano | Austrália |

[Lista completa de moedas suportadas](https://www.exchangerate-api.com/docs/supported-currencies)

## 🛠️ Desenvolvimento

### Adicionando novas funcionalidades:

1. **Salvar histórico em arquivo**:
```java
// Exemplo de implementação futura
gerador.salvaJson(novaMoeda);
```

2. **Consultar múltiplas moedas**:
```java
// Implementar batch requests
```

3. **Interface gráfica**:
```java
// Adicionar JavaFX ou Swing
```

### Extendendo a classe Moeda:

Para adicionar mais moedas específicas, edite a classe `Moeda`:

```java
public Double getBRL() {
    return getTaxa("BRL");
}

public Double getEUR() {
    return getTaxa("EUR");
}

// Adicione novos métodos conforme necessário
```

## ⚠️ Limitações e Considerações

- **Limite de requisições**: A versão gratuita permite 1.500 requisições/mês
- **Atualização**: Taxas são atualizadas a cada 24 horas
- **Disponibilidade**: Requer conexão com internet
- **Precisão**: Para uso informacional apenas

## 🐛 Solução de Problemas

### Erro comum: "Não consegui buscar as taxas"

1. Verifique sua conexão com a internet
2. Confirme se a chave de API está correta
3. Valide o código da moeda (deve ter 3 letras)
4. Verifique se a API está funcionando:
   ```bash
   curl "https://v6.exchangerate-api.com/v6/SUA_CHAVE/latest/USD"
   ```

### Erro: "Moeda não encontrada"

- Use códigos de moeda válidos (ex: USD, não "Dólar")
- Verifique se a moeda está na [lista suportada](https://www.exchangerate-api.com/docs/supported-currencies)

## 🤝 Contribuindo

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para detalhes.

## 🙏 Agradecimentos

- [ExchangeRate-API](https://www.exchangerate-api.com/) por fornecer a API gratuita
- [Google Gson](https://github.com/google/gson) pela biblioteca JSON

## 📞 Suporte

Para dúvidas ou problemas:

1. Abra uma [issue](https://github.com/seu-usuario/conversor-moedas/issues)
2. Verifique a [documentação da API](https://www.exchangerate-api.com/docs/)
3. Consulte os exemplos de uso acima

---

Desenvolvido com ❤️ para a comunidade de desenvolvedores Java