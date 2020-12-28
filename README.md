# Algoritmos, curso da Universidade de Princeton
[Algoritmos I](https://www.coursera.org/learn/algorithms-part1/) no Coursera.


## Instalação `algs4`
[Como instalar a biblioteca do curso no Maven](https://github.com/kevin-wayne/algs4/issues/18#issuecomment-449483074)

[Como instalar a biblioteca do curso no seu Sistema Operacional](https://algs4.cs.princeton.edu/code/) (depois dos links dos códigos fontes)

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

<!-- 
https://github.com/reneargento/algorithms-sedgewick-wayne

## Exercícios do livro
Minhas resoluções foram feitas em `.java` ou em `.txt` 
- explicar como encontrar esse arquivos em
-- linux: https://stackoverflow.com/questions/16956810/how-do-i-find-all-files-containing-specific-text-on-linux, ´grep --include=\*.{java,txt}  -rnw './src/test/java' -e 'exercise-2.2.6'´
-- windows
-- vscode: ctrl shift f
usar esse link
-->

### Gerenciador de dependências
Esse projeto foi feito usando Maven como build tool com Visual Studio Code, mas acho que acabei matando uma mosca com um lançador de mísseis.

Acredito que teria sido melhor usar a opção `no build tools` pra criar um projeto Java no VS Code. Se alguém souber como migrar de maven pra _no build tools_, por favor, me fala. 