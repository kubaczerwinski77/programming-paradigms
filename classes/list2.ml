(* Jakub Czerwinski *)

(* Zadanie 2 *)
let rec fib n =
  if n < 0 then raise (Failure"Negative argument")
  else (
    if n = 0 then 0
    else (
      if n <= 2 then 1
      else fib(n - 1) + fib(n - 2)
    )
  );;
  

(* fib (-3);; *)
fib 0 = 0;;
fib 3 = 2;;
fib 8 = 21;;
(* fib 42;; *)

let fibTail n = 
  if n < 0 then raise (Failure"Negative argument")
  else (
    if n = 0 then 0
    else (
      let rec fibIter (n, a, b) =
        if n <= 2 then b
        else fibIter (n - 1, b, a + b)
      in fibIter(n, 1, 1)
    )
  );;

fibTail 0 = 0;;
fibTail 5 = 5;;
fibTail 42 = 267914296;;

(* Zadanie 3 *)
let root3 a = 
  let rec root3Iter(a, x, eps) =
    if abs_float(x *. x *. x -. a) <= eps *. abs_float(a) then x
    else root3Iter(a, x +. ((a /. (x *. x)) -. x) /. 3., eps)
  in 
    if a > 1. then root3Iter(a, a /. 3., 1.0e-15)
    else root3Iter(a, a, 1.0e-15);;

root3 64. = 4.;;
root3 (-64.) = -4.;;
root3 1. = 1.;;
root3 0. = 0.;;
abs_float(root3(43.) -. 3.503398060386724170614333) <= 1.0e-15 *. abs_float(43.);;

(* Zadanie 4 *)
(* let [_; _; x; _; _] = [-2; -1; 0; 1; 2];;
let [(_, _); (x, _)] = [(1, 2); (0, 1)];;
x;; *)

(* Zadanie 5 *)
let rec initSegment (xs, ys) =
  match (xs, ys) with
    ([], _) -> true
    | (_, []) -> false
    | (hx :: tx, hy :: ty) -> 
      if hx = hy then initSegment(tx, ty)
      else false;;

initSegment([1; 2; 3], [1; 2; 3; 4; 5]) = true;;
initSegment([1; 2; 3], [1; 2]) = false;;
initSegment([], [1; 2; 3]) = true;;
initSegment([1; 2; 3], []) = false;;

(* Zadanie 6a *)
let rec replaceNth (xs, n, x) =
  if n < 0 then raise (Failure"Negative argument")
  else
    match (xs, n, x) with
        ([], _, _) -> raise (Failure"Invalid argument")
      | (h :: t, 0, _) -> x :: t
      | (h :: t, _, _) -> h :: replaceNth(t, n - 1, x);;

replaceNth(['o';'l';'a'; 'm'; 'a'; 'k'; 'o'; 't'; 'a'], 1, 's') = ['o';'s';'a'; 'm'; 'a'; 'k'; 'o'; 't'; 'a'];;
replaceNth([0; 0; 0], 2, 5) = [0; 0; 5];;
(* replaceNth([], 3, 3);; *)
(* replaceNth([1; 2], 5, 3);; *)