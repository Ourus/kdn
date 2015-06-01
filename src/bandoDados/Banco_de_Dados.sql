-- ------------------------------------------ --
--      Base de dados CEET- Vasco Coutinho    --
-- ------------------------------------------ --
create database if not exists  ceet;
use ceet;
-- Tabelas idependentes 

create table if not exists departamento
(
    codDepartamento int unsigned not null auto_increment,
    nomeDepartamento varchar(20),
    descricao varchar (200),
    primary key (codDepartamento)
);

create table if not exists pessoa
(
    codPessoa int unsigned not null auto_increment,
    foto blob,
    nome varchar (80) not null,
    dataNascimento date,
    sexo enum ('M','F'),
    cpf char (14) not null,
    rg varchar (15),
    orgaoEmissor varchar (18),
    dataExpedicao date,
    naturalide varchar (20),
    uf char (2),
    nomeMae varchar (80),
    nomePai varchar (80),
    corRaca enum ('Branca','Preta','Parda','Amarela','Indigena'),
    compResidencia enum ('true','false'),
    compFoto enum ('true','false'),
    primary key (codPessoa)
);

-- ---------------------------------------------- --
--          Tabelas para suporte de Pessoa        --
-- ---------------------------------------------- --

create table if not exists endereco 
(
    codEndereco int unsigned not null auto_increment,
    codPessoa int unsigned not null,
    rua varchar(80),
    cidade varchar(45) not null,
    uf char (2) not null,
    bairro varchar (20) not null,
    cep varchar (9) not null,
    complemento varchar(40) ,
    primary key (codEndereco),
    foreign key (codPessoa) references pessoa (codPessoa)on delete cascade 
);

create table if not exists contato
 (
    codContato int unsigned not null auto_increment,
    codPessoa int unsigned not null,
    tipo varchar(10) not null,
    contato varchar (70),
    primary key (codContato),
    foreign key (codPessoa) references pessoa (codPessoa) on delete cascade 
 );

-- Tabelas dependente de Pessoa e departamento 

create table if not exists funcionarios 
(
    codFuncionario int unsigned not null,
    cargo varchar(20) not null,
    salario float,
    cargaHoraria float,
    codDepartamento int unsigned,
    senha varchar(100),
    primary key (codFuncionario),
    foreign key (codFuncionario) references pessoa (codPessoa) on delete cascade,
    foreign key (codDepartamento) references departamento(codDepartamento)
);
/* A Tabelea de professor tem que ser revista 
pois e possivel ligar a tabela formação a tabela 
funcionario*/

create table if not exists professor
(
    codProfessor int unsigned not null,
    codDepartamento int unsigned not null,
    primary key (codProfessor),
    foreign key (codProfessor) references funcionarios (codFuncionario) on delete cascade,
    foreign key (codDepartamento) references departamento (codDepartamento)
);

create table if not exists aluno
(
    codAluno int unsigned not null,
    matricula varchar(9) not null,
    certidaoNascimento enum('true','false'),
    compEscolaridade enum('true','false'),
    historicoEscolar enum('true','false'),
    comprovanteResidencia enum('true','false'),
    status varchar (45) not null,
    observacao varchar (500),
    compDeclaracao enum ('true','false'),
    primary key (codAluno),
    foreign key (codAluno) references pessoa (codPessoa) on delete cascade  
   
);
-- ---------------------------------------------- --
--    Tabelas para suporte a Aluno e Professor    --
-- ---------------------------------------------- --

create table if not exists escolaridade
(
    codEscolaridade int unsigned not null auto_increment,    
    codAluno int unsigned not null,
    serie varchar (6),
    nomeEscola varchar (80) not null,
    municipio varchar (30) ,
    dependenciaAdministrativa varchar(200),
    anoLetivo varchar (9),
    eja enum('true','false'),
    primary key (codEscolaridade),
    foreign key (codAluno) references aluno (codAluno) on delete cascade
  );
create table if not exists desempenho
(
    codDesempenho int unsigned not null auto_increment,
    codAluno int unsigned not null, 
    desempenho varchar(45),
    numeroFaltas int, 
    trimestre varchar(10),
    primary key (codDesempenho),
    foreign key (codAluno) references aluno (codAluno) on delete cascade
  );

create table if not exists formacao 
(
    codProfessor int unsigned not null, 
    codFormacao int unsigned not null auto_increment,
    tipo varchar(10) not null , 
    curso varchar (30) not null,
    instituicao varchar (80),
    situacao varchar (20) not null,
    anoConclucao date not null,
    anoInicio date not null, 
    primary key (codFormacao),
    foreign key (codProfessor) references professor (codProfessor)on delete cascade 

);

-- Tabelas de Curso e disciplinas 

create table if not exists curso
(
    codCurso int unsigned not null auto_increment,
    nome varchar(45) not null,
    numeroIdMEC varchar(45) not null,
    primary key (codCurso)
);


create table if not exists disciplina
(
    codDisciplina int unsigned not null auto_increment,
    codCurso int unsigned ,
    nome varchar (45) not null,
    cargaHoraria int not null,
    foreign key (codCurso) references curso (codCurso),
    primary key (codDisciplina)

);

-- ---------------------------------------------- --
--    Tabelas para suporte a Curso e Disciplina   --
-- ---------------------------------------------- --

create table if not exists ementa
(
    codEmenta int unsigned not null,
    periodoLetivo varchar(20) not null,
    primary key (codEmenta),
    foreign key (codEmenta) references disciplina(codDisciplina) on delete cascade
    
);

create table if not exists basesTecnologicas
(
    codBasesTecnologicas int unsigned not null auto_increment,
    codEmenta int unsigned not null,
    bases varchar (45) not null,
    primary key (codBasesTecnologicas),
    foreign key (codEmenta) references ementa (codEmenta)on delete cascade

);
create table if not exists habilidade 
(
    codHabilidade int unsigned not null auto_increment,
    codEmenta int unsigned not null,
    habilidade varchar(45),
    primary key (codHabilidade),
    foreign key (codEmenta) references ementa (codEmenta) on delete cascade
);
create table if not exists competencia
(
    codCompetencia int unsigned not null auto_increment,
    codEmenta int unsigned not null, 
    Compentencia varchar (45) not null, 
    primary key (codCompetencia),
    foreign key (codEmenta) references ementa(codEmenta) on delete cascade
);
-- ---------------------------------------------- --
--    Tabelas para suporte a tabela Ementa        --
-- ---------------------------------------------- --

create table if not exists bibliografia (
    codBibliografia int unsigned not null auto_increment,
    titulo varchar(80) not null,
    autor varchar(80) not null,
    edicao varchar(20),
    local varchar(40),
    editora varchar(30),
    ano varchar (5),
    primary key (codBibliografia)
);

create table if not exists ementaBibliografia (
    codEmenta int unsigned not null,
    codBibliografia int unsigned not null,
    foreign key (codEmenta) references ementa (codEmenta),
    foreign key (codBibliografia) references bibliografia (codBibliografia)
    );
    
create table if not exists turma (
    codTurma int unsigned not null auto_increment,
    codCurso int unsigned not null,
    nome varchar (10) not null,
    turno enum('Matutino','Vespertino','Noturno','Integral'),
    dataInicio date,
    dataFim date,
    status varchar(20),
    foreign key (codCurso) references curso(codCurso),
    primary key (codTurma)

);

create table if not exists matricula (
    codMatricula int unsigned not null auto_increment,
    codTurma int unsigned not null,
    codAluno int unsigned not null,
    dataMatricula date,
    anoLetivo varchar(5),
    modulo int(2),
    status varchar(10),
    primary key (codMatricula),
    foreign key (codTurma) references turma (codTurma),
    foreign key (codAluno) references aluno (codAluno) on delete cascade
);
-- ---------------------------------------------- --
--    Tabelas para suporte a tabela Aulas         --
-- ---------------------------------------------- --
create table if not exists hora (
    codHora int unsigned auto_increment,
    hora int,
    primary key (codHora)
);
create table if not exists dia (
    codDia int unsigned auto_increment,
    dia varchar(15),
    primary key (codDia)
);

create table if not exists diaHora (
    codDiaHora int unsigned not null auto_increment,
    codDia int unsigned,
    codHora int unsigned,
    primary key (codDiaHora),
    foreign key (codDia) references dia (codDia) on delete cascade,
    foreign key (codHora) references hora (codHora) on delete cascade
);

create table if not exists labs (
    codLab int unsigned not null auto_increment,
    nome varchar (45),
    numero int,
    primary key (codLab)
);

-- Tabela Aulas 
create table if not exists aula (
    codAula int unsigned not null auto_increment,
    codProfessor int unsigned not null,
    codTurma int unsigned not null,
    codDisciplina int unsigned not null,
    codLab int unsigned not null,
    codDiaHora int unsigned not null,
    dataAula date,
    primary key (codAula),
    foreign key (codProfessor) references professor(codProfessor),
    foreign key (codTurma) references turma(codTurma),
    foreign key (codDisciplina) references disciplina(codDisciplina),
    foreign key (codLab) references labs (codLab),
    foreign key (codDiaHora) references diaHora(codDiaHora)
);
