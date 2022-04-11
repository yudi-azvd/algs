# Skipping merge (2.2.8)

Se o array já está ordenado, a chamada `merge()` é sempre pulada porque `a[mid] <= a[mid+1]` é sempre verdade. Essa comparação ocorre N vezes.