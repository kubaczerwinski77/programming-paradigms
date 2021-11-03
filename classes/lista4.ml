(* Jakub Czerwinski *)

(* Zadanie 2 *)
let rec f x = f x;;

(* Zadanie 3 *)
type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;
let tt = Node(1, Node(2, Node(4, Empty, Empty), Empty), Node(3, Node(5, Empty, Node(6, Empty, Empty)), Empty));;

let breadthBT tree =
  let rec bfs queue result =
    match queue with
      [] -> result
      | h::t ->
        match h with
          Empty -> bfs t result
          | Node(v, l, r) -> bfs(t @ [l; r])(v::result)
  in List.rev (bfs[tree][])
;;
  
breadthBT tt;;

(* Zadanie 4 *)
let internalPathLen tree =
  let rec internalIter n result depth =
    match n with
      Empty -> result
      | Node(v, l, r) -> internalIter l (internalIter r (result + depth) (depth + 1)) (depth + 1)
  in internalIter tree 0 0;;

internalPathLen tt;;

let externalPathLen tree =
  let rec externalIter n result depth =
    match n with
      Empty -> result + depth
      | Node(v, l, r) -> externalIter l (externalIter r result (depth + 1)) (depth + 1)
  in externalIter tree 0 0;;

externalPathLen tt;;

(* Zadanie 5 *)
type 'a graph = Graph of ('a -> 'a list);;

let g = Graph (
  function
  0 -> [3]
  | 1 -> [0; 2; 4]
  | 2 -> [1]
  | 3 -> []
  | 4 -> [0; 2]
  | n -> failwith("Graph g: node " ^ string_of_int n ^ "doesn't exist") 
);;

let depthSearch (Graph graph) vertex =
  let rec dfs visited result =
    match visited with
      [] -> result
      | h::t ->
        match List.mem h result with
          true -> dfs t result
          | false -> dfs ((graph h) @ t) (h::result)
  in List.rev (dfs [vertex][])
;;

depthSearch g 4;;