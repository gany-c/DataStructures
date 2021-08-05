Hi

Think about a software build system.  To build a specific target, it may be necessary to also build the dependencies of that target.

One of the target’s build dependencies, which seems irrelevant to the actual target fails to build.  I’d like to see the dependency chain to the failing target, 
to see if it’s something that can be eliminated.

The system does not allow circular dependencies.

Write an algorithm that can list all paths from my target to the failing target.

            A
           /   \
          B     C 
        /  \   / \   
       D     E <- F
             |
             G  


What are all paths from A to G?

Answer: [A, B, E, G], [A, C, E, G] or [A, C, F, E, G]

B to E

Answer [B, E]

E, M

class Node:
 data:str 
 children: Node[]

def getPaths(source: Node, target: Node): str[]
    return explore(source, target, "")
  
def explore(current_node, target, pathSoFar)
   if source.data == target.data:
       # if there is only one package, the output may start with a comma
       # may be we can tolerate that
       return [pathSoFar + ", " + target.data]
    else:
       output_paths = []
       if current_node.children: 
         for child in current_node.children:
             child_paths = explore(child, target, pathSoFar + ", " + current_node.data)
             if child_paths:
                output_paths.extend(child_paths)
       return output_paths       
        
"""          
G, M, "E, "
=================
1. A, G, ""

2. B, G, "A, "
2. C, G, "A, "

3. D, G, "A, B, "
3. E, G, "A, B, "

3. G, G, "A, B, E"
 - return A, B, E, G"

"""
