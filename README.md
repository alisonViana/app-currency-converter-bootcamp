# Currency Converter

Olá, este é o repositório do meu aplicativo Currency Converter, projeto desenvolvido para o Bootcamp Carrefour Android Developer oferecido pela 
[Digital Innovation One](https://web.dio.me/) em parceria com o Carrefour!

O aplicativo permite realizar a conversão das principais moedas do mundo com a cotação atual de câmbio, incluindo criptomoedas, 
permitindo ao usuário armazenar essas informações e criar seu histórico pessoal dos valores. 

O Currency Converter está baseado nos princípios de MVVM e Clean Architecture, além de utilizar a biblioteca Koin para realizar a injeção de dependência, 
o que torna o código mais organizado e traz um maior nível de desacoplamento, principalmente da UI com as regras de negócio, 
além da maior facilidade de manutenção e implementação de novas funções, com as camadas de Data Layer, Domain Layer e UI Layer bem definidas.

O app utiliza o consumo da [AwesomeAPI](https://docs.awesomeapi.com.br/api-de-moedas) para obter os valores atualizados de câmbio e faz uso da biblioteca Room, 
que fornece uma abstração sobre o SQLite, aproveitando toda a sua capacidade para a persistência de dados.
