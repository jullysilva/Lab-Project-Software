# Lab-Project-Software

## Neste laboratório, vamos projetar um Sistema de Matrículas para uma Universidade.
### Descrição do Sistema:
Uma universidade pretende informatizar seu sistema de matrículas. A secretaria da universidade gera o currículo para cada semestre e mantém as informações sobre as disciplinas, professores e alunos.

Cada curso tem um nome, um determinado número de créditos e é constituído por diversas disciplinas.

Os alunos podem se matricular em 4 disciplinas como 1ª opção (obrigatórias) e em mais 2 outras alternativas (optativas).

Há períodos para efetuar matrículas, durante os quais um aluno pode acessar o sistema para se matricular em disciplinas e/ou para cancelar matrículas feitas anteriormente.

Uma disciplina só fica ativa, isto é, só vai ocorrer no semestre seguinte se, no final do período de matrículas tiver, pelo menos, 3 alunos inscritos (matriculados). Caso contrário, a disciplina será cancelada. O número máximo de alunos inscritos a uma disciplina é de 60 e quando este número é atingido, as inscrições (matrículas) para essa disciplina são encerradas.

Após um aluno se inscrever para um semestre, o sistema de cobranças é notificado pelo sistema de matrículas, de modo que o aluno possa ser cobrado pelas disciplinas daquele semestre.

Os professores podem acessar o sistema para saber quais são os alunos que estão matriculados em cada disciplina.

Todos os usuários do sistema têm senhas que são utilizadas para validação do respectivo login.

## Apresentação Final:

Ao final da última sprint (Sprint 03), os alunos deverão apresentar o protótipo produzido, comparando-os com os modelos descritos inicialmente, bem como apresentando as modificações inseridas para o funcionamento adequado do software (conforme a especificação anterior). O sistema deverá ser desenvolvido em Java, atendendo aos requisitos apresentados e cumprindo a modelagem produzida nas sprints iniciais do projeto. O repositório GitHub deve estar atualizado, com todas as versões produzidas dos modelos UML e o código final desenvolvido. A avaliação final do projeto levará em consideração os seguintes aspectos:

- Qualidade do sistema produzido (adequação aos requisitos apresentados);
- Alinhamento entre modelo (de classes e de arquitetura) e código;
- Atualizações dos modelos conforme necessidade do projeto.


## Processo de Desenvolvimento:
__Lab01S01:__ Modelo de Análise: Diagrama de Caso de Uso referente ao sistema + Descrição em Histórias de Usuário em Markdown (.md), no README do Repositório, com arquivo enviado no Canvas. (4 pontos)

__Lab01S02:__ Correção dos Diagramas desenvolvidos + Projeto Estrutural: Diagrama de Classes referente ao sistema + Criação do Projeto Java, contendo: classes, atributos e stub dos métodos modelados (4 pontos);

__Lab01S03:__ Correção dos Diagramas desenvolvidos + Implementação do protótipo do sistema (principais funcionalidades usáveis, com interface e persistência) (7 pontos). Observação: a interface pode ser em linha de comando e a persistência em arquivos.

__Prazo final:__ 31/09 
__Apresentação:__ 31/09
__Valor total:__ 15 pontos 

#### Atenção: semanalmente, todos os grupos deverão apresentar o andamento das entregas durante a aula. A não participação do grupo implicará na perda automática de 50% dos pontos da sprint.
