# Scripts para "deploy"
Existiam alguns passos para serem feitos manualmente toda vez 
que eu fazia alguma alteração na tarefa e queria logo em 
seguida submetê-la na plataforma. Esses scripts foram criados 
para automatizar esse processo.

## Como usar
Certifique-se de estar com o terminal aberto no diretório 
raíz do projeto. Para executar o script `zip-queues`, 
por exemplo, execute no terminal:

```sh
./sh/zip-queues
```

Só testei esses scripts no Ubuntu, mas devem funcionar em 
qualquer ambiente Unix e até mesmo no [WSL](https://docs.microsoft.com/en-us/windows/wsl/) do Windows 10.

## Possíveis melhorias
- [ ] Incluir no script uma parte que já submete o `.zip` 
para a plataforma.

- [ ] Incluir no script uma parte que copia o conteúdo do resultado do autograder

### Aviso
Não sou nenhum profissional em bashscript/shellscript, 
então escrever esses scripts foi um processo de pesquisar 
no Google o que tinha que ser feito e testar logo em seguida.
Provavelmente existem maneiras melhores de fazer isso.