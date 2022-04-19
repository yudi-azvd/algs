# Algoritmos, curso da Universidade de Princeton

[Algoritmos I](https://www.coursera.org/learn/algorithms-part1/) no Coursera.

Meus estudos em estruturas e algoritmos de dados continuam nesse 
[repositório](https://github.com/yudi-azvd/eda2).


## Dependêcnias

- Gradle (acho mais fácil)
- Maven
- `algs4` (biblioteca do curso)

[Como instalar a biblioteca do curso no Maven](https://github.com/kevin-wayne/algs4/issues/18#issuecomment-449483074)

[Como instalar a biblioteca do curso no seu Sistema Operacional](https://algs4.cs.princeton.edu/code/) (depois dos links dos códigos fontes)

Em resumo, você pode seguir os passos desse [comentário](https://github.com/kevin-wayne/algs4/issues/18#issuecomment-449483074) 
e do comentário abaixo dele.

## Executar programas pelo terminal

### Gradle

Executar testes unitários:

    gradle test

Para rodar um teste específico: Ainda não descobri. Mas algo assim era pra
dar certo:

    gradle test --tests TestiDFSSearch

### Maven
Normal:

    mvn compile exec:java -Dexec.mainClass="AlgorithmsPrincetonCourse.Graph.MySymbolGraph"

Dos testes:

    mvn compile exec:java -Dexec.classpathScope="test" -Dexec.mainClass="AlgorithmsPrincetonCourse.Graph.Exercises._4_1_24_CCMovies"


## Dados de teste
Baixe os dados nos seguintes links e cole-os diretamente como subdiretórios de `resources/`:

```
src/main
└── resources
    └── (cole as pastas de dados aqui)
```

Dados de propósito geral: [algs4-data](https://algs4.cs.princeton.edu/code/algs4-data.zip).


Dados para os _assignments_:
1. [percolation](https://coursera.cs.princeton.edu/algs4/assignments/percolation/percolation.zip)



## Exercícios
[Aqui](/src/test/java/AlgorithmsPrincetonCourse/README.md)
