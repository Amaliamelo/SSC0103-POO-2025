import heapq
import sys

def dijkstra(graph, start_node):
    """
    Implementa o algoritmo de Dijkstra para encontrar o menor caminho
    de um nó inicial para todos os outros nós em um grafo.

    Args:
        graph (dict): O grafo representado como um dicionário.
                      Ex: { 'A': {'B': 50, 'C': 30}, ... }
        start_node (str): O nó inicial para o cálculo do menor caminho.

    Returns:
        tuple: Um tupla contendo dois dicionários:
               - distances (dict): Menor distância do nó inicial para cada nó.
               - predecessors (dict): Predecessor de cada nó no menor caminho.
    """
    distances = {node: float('infinity') for node in graph}
    distances[start_node] = 0
    predecessors = {node: None for node in graph}
    priority_queue = [(0, start_node)]  # (distance, node)

    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)

        if current_distance > distances[current_node]:
            continue

        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight

            if distance < distances[neighbor]:
                distances[neighbor] = distance
                predecessors[neighbor] = current_node
                heapq.heappush(priority_queue, (distance, neighbor))

    return distances, predecessors

def reconstruct_path(predecessors, start_node, end_node):
    """
    Reconstrói o caminho mais curto usando o dicionário de predecessores.

    Args:
        predecessors (dict): Dicionário de predecessores retornado por Dijkstra.
        start_node (str): O nó de início do caminho.
        end_node (str): O nó de destino do caminho.

    Returns:
        list: Uma lista de nós que representa o caminho mais curto.
              Retorna uma lista vazia se não houver caminho.
    """
    path = []
    current = end_node
    while current is not None and current != start_node:
        path.insert(0, current)
        current = predecessors[current]
    
    if current is None and end_node != start_node:
        return []

    if current == start_node or (not path and start_node == end_node):
        path.insert(0, start_node)
    
    if path and path[0] == start_node and path[-1] == end_node:
        return path
    
    return []


def parse_input_from_stdin():
    """
    Lê a entrada para construir o grafo do stdin (teclado/pipe).
    Retorna o grafo como um dicionário e a ordem de aparição dos nós
    principais na entrada.

    Returns:
        tuple: (dict: O grafo, list: Ordem dos nós principais)
    """
    graph = {}
    current_node = None
    node_order = [] 
    
    for line in sys.stdin:
        line = line.strip()
        if not line:
            continue

        # Tentativa de dividir por tabulação primeiro (para "São_Carlos\t207")
        parts_tab = line.split('\t')

        if len(parts_tab) > 1 and current_node is not None: # É uma linha de vizinho com tabulação
            # O primeiro elemento pode ser o nome do nó ou vazio se a linha começa com tab
            # O segundo elemento conterá o nome do vizinho e o peso
            
            # Ajuste para lidar com linha que começa com tab, ex: "\tSão_Carlos\t207"
            if not parts_tab[0] and len(parts_tab) >= 2: # Se começa com tab, primeiro elemento é vazio
                # Remove o primeiro elemento vazio e une o resto para reprocessar
                parts_to_process = parts_tab[1:]
                # Tenta dividir por tab (se houver outra) ou espaço
                if len(parts_to_process) == 2: # Formato "Vizinho\tPeso"
                    neighbor = parts_to_process[0]
                    try:
                        weight = float(parts_to_process[1])
                    except ValueError:
                        continue
                elif len(parts_to_process) == 1: # Pode ser "Vizinho Peso" sem tab interna
                    space_parts = parts_to_process[0].split(' ')
                    if len(space_parts) == 2:
                        neighbor = space_parts[0]
                        try:
                            weight = float(space_parts[1])
                        except ValueError:
                            continue
                    else:
                        continue # Mal formatado
                else:
                    continue # Mal formatado

            elif len(parts_tab) == 2: # Caso "NomeVizinho\tPeso" (sem tab inicial)
                neighbor = parts_tab[0]
                try:
                    weight = float(parts_tab[1])
                except ValueError:
                    continue
            else:
                continue # Mal formatado para tabulação

            if current_node and neighbor and isinstance(weight, float): # Garantir que tudo foi parsed
                if current_node not in graph:
                    graph[current_node] = {} 
                graph[current_node][neighbor] = weight

        else: # Linha é o nome de um nó principal OU uma linha de vizinho com espaços
            # Tentativa de dividir por espaço para casos como "Ribeirão_Preto 211"
            parts_space = line.split(' ')
            
            if len(parts_space) == 1: # É um nó principal como "S.J.Rio_Preto"
                current_node = parts_space[0]
                if current_node not in graph:
                    graph[current_node] = {}
                    node_order.append(current_node)
            elif len(parts_space) == 2 and current_node is not None: # É um vizinho com espaço como "Ribeirão_Preto 211"
                neighbor = parts_space[0]
                try:
                    weight = float(parts_space[1])
                except ValueError:
                    continue
                
                if current_node: # Garantir que temos um nó principal definido
                    if current_node not in graph:
                        graph[current_node] = {}
                    graph[current_node][neighbor] = weight
            else:
                continue # Linha não corresponde a nenhum padrão esperado
                
    return graph, node_order


def format_output(start_node, distances, predecessors, all_nodes_for_sorting_targets):
    """
    Formata a saída para o problema.

    Args:
        start_node (str): O nó inicial de onde os caminhos foram calculados.
        distances (dict): Dicionário de distâncias.
        predecessors (dict): Dicionário de predecessores.
        all_nodes_for_sorting_targets (list): Uma lista de todos os nós no grafo para ordenar os destinos.
    """
    output_lines = []
    
    # Ordena os nós de destino alfabeticamente, excluindo o próprio nó de partida
    sorted_target_nodes = [node for node in all_nodes_for_sorting_targets if node != start_node]

    for target_node in sorted_target_nodes:
        distance = distances.get(target_node, float('infinity'))
        path = reconstruct_path(predecessors, start_node, target_node)

        output_lines.append(f"{start_node} para {target_node}")
        if distance == float('infinity'):
            output_lines.append(f"\tDistancia: INFINITO")
            output_lines.append(f"\tCaminho: Não encontrado")
        else:
            # Formata a distância com vírgula em vez de ponto
            output_lines.append(f"\tDistancia: {distance:.1f}".replace('.', ','))
            if path:
                path_str_segments = path[1:] # Exclui o nó de partida para a exibição
                if path_str_segments: # Se há mais de um nó no caminho (além do de partida)
                    path_str = " --> ".join(path_str_segments)
                    output_lines.append(f"\tCaminho:  --> {path_str}")
                else: # Caminho para si mesmo (não deve acontecer com o filtro de `target_node != start_node`)
                    output_lines.append(f"\tCaminho:  --> {path[0]}")
            else: # Se reconstruct_path retornou []
                output_lines.append(f"\tCaminho: Não encontrado")
    return "\n".join(output_lines)


if __name__ == "__main__":
    # 1. Parsing da entrada para construir o grafo e obter a ordem dos nós
    graph_from_user, initial_node_order = parse_input_from_stdin()

    if not graph_from_user:
        sys.exit(1)

    # Pegamos todos os nós para usar na ordenação dos destinos
    all_nodes_in_graph = list(graph_from_user.keys())

    # 2. Calcular e exibir os caminhos para cada nó inicial na ordem da entrada
    final_output = []
    for start_node_iter in initial_node_order: # Usamos a ordem da entrada aqui!
        if start_node_iter not in graph_from_user:
            continue

        distances, predecessors = dijkstra(graph_from_user, start_node_iter)
        
        block_output = format_output(start_node_iter, distances, predecessors, all_nodes_in_graph)
        
        if block_output:
            final_output.append(block_output)
            # Adiciona o separador, exceto após o último bloco
            if start_node_iter != initial_node_order[-1]:
                final_output.append("-" * 45)

    final_output.append("-" * 45)
    print("\n".join(final_output))