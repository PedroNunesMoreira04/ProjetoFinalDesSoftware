# Projeto Final Desenvolvimento de Software

Sistema de Gestão Escolar Java - Projeto Final Desenvolvimento de Software
Visão Geral
Este projeto é um sistema de gestão escolar desenvolvido em Java seguindo o padrão
MVC. Ele permite gerenciar escolas, alunos, professores, diretores e disciplinas, com
persistência de dados em arquivo.
Estrutura do Projeto
Pacotes Principais
1. models - Contém as classes de domínio:
- Escola - Entidade central que agrega todos os dados
- Pessoa - Classe abstrata base
- Aluno, Professor, Diretor - Especializações de Pessoa
- Funcionario - Classe abstrata intermediária
2. controllers - Lógica de controle:
- BaseController - Operações básicas do sistema
- Menu - Gerenciamento dos fluxos de interação
3. view - Interface com usuário:
- Main - Ponto de entrada do sistema
Funcionalidades Principais
Gestão de Escolas
- Criar novas escolas
- Listar escolas existentes
- Selecionar escola para operações
Operações por Escola
- Gestão de Pessoas:
- Adicionar/remover alunos e professores
- Definir/alterar diretor
- Listar todos os cadastrados
- Gestão de Disciplinas:
- Adicionar/remover disciplinas
- Matricular alunos em disciplinas
- Listar disciplinas disponíveis
- Relatórios:
- Informações básicas da escola
- Quantitativos de alunos, professores e disciplinas
Fluxo de Dados
1. Persistência:
- Os dados são salvos automaticamente no arquivo escolas.dat ao sair
- São carregados automaticamente ao iniciar o sistema
2. Validações:
- Verificação de duplicatas (escolas, pessoas)
- Checagem de pré-requisitos (disciplinas existentes)
Como Usar
1. Menu Principal:
|| Sistema de Escolas ||
1 - Escolher escola
2 - Listar escolas
3 - Criar nova escola
4 - Sair
2. Menu da Escola (14 opções):
- Operações específicas para a escola selecionada
1 - Informações básicas
2 - Listar professores
3 - Listar alunos
4 - Adicionar disciplina
5 - Remover disciplina
6 - Adicionar professor
7 - Remover professor
8 - Adicionar aluno
9 - Remover aluno
10 - Adicionar disciplina para aluno
11 - Remover disciplina para aluno
12 - Mudar diretor da escola
13 - Voltar ao menu anterior(Sistema de Escolas)
