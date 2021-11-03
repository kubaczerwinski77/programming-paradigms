(* Jakub Czerwinski *)

(* Zadanie 2 *)
let curry3 f x y z = f (x, y, z);;
let curry3L = fun f -> fun x -> fun y -> fun z -> f (x, y, z);;

let uncurry3 f (x, y, z) = f x y z;;
let uncurry3L = fun f -> fun (x, y, z) -> f x y z;;

let plus x y z = x + y + z;;
let add (x, y, z) = x + y + z;;

curry3 add 1 2 3;;
curry3L add 1 2 3;;

uncurry3 plus (1, 2, 3);;
uncurry3L plus (1, 2, 3);;

(* Zadanie 3 *)
let mySumProd xs = 
  List.fold_left (fun (right, left) x -> (right + x, left * x)) (0, 1) xs;;

mySumProd [1; 2; 3; 4];;
mySumProd [0; 1; 2; 3];;
mySumProd [-1; -2; -3; -4];;

(* Zadanie 5 *)
(* a) *)
let rec insertionSort pred xs =
  let rec insert pred x xs =
    match xs with 
      [] -> [x]
      | h::t ->
        if pred x h then x::h::t
        else h::insert pred x t
  in
    match xs with
      [] -> []
      | h::t -> insert pred h (insertionSort pred t)
;;

insertionSort (fun x y -> x <= y) [5; 2; 1; 4; 3];;
insertionSort (fun (x, _)(y, _) -> x <= y) [(5, 1); (2, 1); (5, 2); (4, 1); (2, 2)];;
insertionSort (fun (x, _)(y, _) -> x >= y) [(5, 1); (2, 1); (5, 2); (4, 1); (2, 2)];;

(* b) *)
let rec mergeSort pred xs =
  let halve xs =
    let rec halveHelper n ys =
      if n = 0 then ([], ys)
      else match ys with
        [] -> ([], [])
        | h::t ->
          let (l, r) = halveHelper (n - 1) t
          in (h::l, r)
    in halveHelper (List.length xs / 2) xs
  in
    let rec merge pred xs ys =
    match (xs, ys) with
      [], l -> l 
      | l, [] -> l
      | hx::tx, hy::ty ->
        if pred hx hy then hx::merge pred tx ys
        else hy::merge pred xs ty
  in
    match xs with 
      [] -> []
      | [x] -> [x]
      | h::t as list -> 
        let l, r = halve list
        in merge pred (mergeSort pred l) (mergeSort pred r)
;;

mergeSort (fun x y -> x <= y) [5; 2; 1; 4; 3];;
mergeSort (fun (x, _)(y, _) -> x <= y) [(5, 1); (2, 1); (5, 2); (4, 1); (2, 2)];;
mergeSort (fun (x, _)(y, _) -> x >= y) [(5, 1); (2, 1); (5, 2); (4, 1); (2, 2)];;
