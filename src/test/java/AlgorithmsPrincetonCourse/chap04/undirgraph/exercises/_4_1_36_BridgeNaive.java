package AlgorithmsPrincetonCourse.chap04.undirgraph.exercises;

import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.Cycle;
import edu.princeton.cs.algs4.Graph;

/**
 * <code>exercise-4.1.36</code> encontrar pontes no grafo
 * 
 * <pre>
 * no começo, guardar o número de componentes conectadas original.
 * g = copy_of(g)
 * pra aresta de arestas:
 *    g.remove(aresta)
 *    cc_count_novo = CC(g)
 *    se cc_count_novo > cc_count_original:
 *      tem_pontes = true
 *      return;
 *    g.add(aresta)
 * </pre>
 * 
 * <p> Ideias:
 * <li> 1. Se v e w (de G) adjacentes entre si pertencem a um mesmo ciclo, o par
 * v-w não é uma ponte => uma ponte não faz parte de um ciclo.
 * 
 * <li> 2. Se v-w é uma ponte, existe apenas um único caminho de v para w e vice-versa.
 * Se não é uma ponte, existe mais de um caminho entre v e w.
 * 
 * <li> 3. Desfazer uma ligação entre dois vértices que fazem parte de uma ponte
 * cria uma nova componente conexa.
 */
public class _4_1_36_BridgeNaive {
  private boolean hasBridge;
  
  public _4_1_36_BridgeNaive(Graph g) {
    hasBridge = false;
    
    CC cc = new CC(g);
    Cycle c = new Cycle(g);
    int originalCCCount = cc.count();
  }

  private void dfs() {
    
  }

  public boolean hasBridge() {
    return hasBridge;
  }
}

