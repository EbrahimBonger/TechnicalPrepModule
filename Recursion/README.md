How to approach problems to solve in recursive manner:
    
    Bottom-up: Start with knowing how to solve the problem for a simple case, 
               like a list with one element. Then figure 
               out how to solve the problem for two, and three elements, and so on.
    Top-Down: Think about how you can devide the problem for case N into subproblems.
        Note: Becareful of overlaping between the cases.
    Half-Half: Devide the data set into half when you encounter problem like Sorted Binary Search, and recurse.
Recursive vs. Iterative solutions:
     
    Recursive algorithms can be very space insufficient. Each recursive call adds a new layer to the stack.
    All recursive algorithm can be implemented iteratevely , sometimes with lesss complexity.
    Note: Before diving into a recursive code, ask yourself how hard it would be implement it iteratively, and 
          discuss the tradeoffs with your interviewer.
          
               