exercise-2.4.2

> Criticize the following idea: To implement find the maximum in constant time,
> why not use a stack or a queue, but keep track of the maximum value inserted 
> so far, then return that value for find the maximum?

Se estamos falando de uma implementação restrita de filas e pilhas, não
é possível acessar posições aleatórias dessas estruturas, o que impede a
operação `findMax` em tempo constante. `findMax` deveria então, levar tempo
linear.

Além disso, a operação `delMax` fica prejudicada por que a filas e pilhas têm 
ordem específica de remoção de itens.