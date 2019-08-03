#language: pt
#Author: Thiago Benites
@google
Funcionalidade: Testes basicos no google
  Como um usuário
  Eu quero realizar uma busca
  De modo que obtenha resultados

  @CT01
  Esquema do Cenario: CT01_busca_google
    Dado que acesso o google pelo "<browser>"
    E que digito o valor "<pesquisa>"
    Quando realizo a busca
    Entao apresenta a lista de resultados

    @smoketest
    Cenarios: 
      | browser | pesquisa |
      | chrome  | Arnaldo  |

    @regression
    Cenarios: 
      | browser | pesquisa |
      | firefox | Thiago   |
      | chrome  | Amanda   |
