(* Jakub Czerwinski *)

(* Zadanie 1 *)
let revNComp f n arg =
    let rec revNCompIter f n arg =
        if n <= 0 then []
        else if n = 1 then [arg]
        else arg :: revNCompIter f (n - 1) (f arg)
    in List.rev (revNCompIter f n arg);;

revNComp (fun x -> 2 * x) 10 2;;
revNComp (fun x -> x ^ x) 3 "Kuba";;
revNComp (fun x -> x * x) 0 1;;
revNComp (fun x -> x * 3) 1 5;;

(* Zadanie 2 *)
let area (a, b) f n =
  let rec createList n toN =
    if n <= toN then n::createList(n +. 1.) toN else []
  in
    let arr = List.map (fun x -> x *. ((b -. a) /. float_of_int n)) (createList 1. (float_of_int n)) in 
    let arr2 = List.map (fun x -> f x) arr in
    let arr3 = List.map (fun x -> x *. ((b -. a) /. float_of_int n)) arr2 in
    (List.fold_left (+.) 0.) arr3
;;

area (0., 1.) (fun x-> x) 100000;;
area (0., 2.) (fun x-> x) 100000;;
area (0., 3.1415) (fun x -> sin(x)) 100000;;