# Scripts para "deploy"

## Como usar
Certifique-se de estar com o terminal aberto no diretório 
raíz do projeto. Para executar o script `deploy-queues`, 
por exemplo, execute no terminal:

```sh
./shellscripts/deploy-queues
```

Pelo menos em ambiente Linux eles funcionam.

## Motivação
Para submeter as tarefas na plataforma do Coursera,
as classes deviam satisfazer certos requisitos propostos
pelos professores do curso. Requisitos como: as classes 
devem estar no pacote padrão, não devem ser utilizadas 
anotações como `@SupressWarnings` etc.

Esses scripts foram criados para automatizar o processo 
de cumprir esses requisitos e comprimir os arquivos em 
um `.zip` final.

Não sou nenhum profissional em bashscript/shellscript, 
então escrever esses scripts foi um processo de pesquisar 
no Google o que tinha que ser feito e testar logo em seguida.
Provavelmente existem maneiras melhores de fazer isso.