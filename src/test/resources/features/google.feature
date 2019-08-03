#language: pt
#Author: Thiago Benites
@google
Funcionalidade: Testes basicos no google
  Como um usuário
  Eu quero realizar uma busca
  De modo que obtenha resultados

  Contexto: 
    Dado que acesso a url "http://google.com"

  @chrome
  Esquema do Cenario: CT01_busca_google
    Dado que digito o valor "<pesquisa>"
    Quando realizo a busca
    Entao apresenta a lista de resultados

    Cenarios: 
      | pesquisa |
      | Arnaldo  |