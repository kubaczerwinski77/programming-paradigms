(* Jakub Czerwinski *)

(* Zadanie 1 *)
type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lrepeat k lxs =
  let rec lhelper (counter, elem, tail) =
    if counter > 1 then LCons(elem, lazy(lhelper(counter - 1, elem, tail)))
    else lrepeat k tail
  in
    match lxs with
      LNil -> LNil
      | LCons(h, lazy t) -> LCons(h, lazy(lhelper(k, h, t)));;

(* pomocnicze do 1 zadania *)
let rec lfrom k =
  LCons(k, lazy(lfrom(k + 1)));;

let rec toLazyList = function
  [] -> LNil
  | h::t -> LCons(h, lazy(toLazyList t));;

let rec ltake = function
  (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(lh, lazy lt)) -> lh::ltake(n - 1, lt);;

ltake(12, lrepeat 3 (toLazyList ['a'; 'b'; 'c'; 'd'])) = ['a'; 'a'; 'a'; 'b'; 'b'; 'b'; 'c'; 'c'; 'c'; 'd'; 'd'; 'd'];;
ltake(15, lrepeat 3 (lfrom 1)) = [1; 1; 1; 2; 2; 2; 3; 3; 3; 4; 4; 4; 5; 5; 5];;
ltake(15, lrepeat 3 (toLazyList [])) = [];;

(* Zadanie 2 *)
let lfib =
  let rec lhelper (prev, next) =
    LCons(prev, lazy(lhelper(next, prev + next)))
  in lhelper(0, 1);;

ltake(10, lfib) = [0; 1; 1; 2; 3; 5; 8; 13; 21; 34];;

(* Zadanie 3 *)
