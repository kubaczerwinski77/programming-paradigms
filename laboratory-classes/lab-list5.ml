(* Jakub Czerwinski *)

(* lista heterogeniczna *)
type 'a ticket = Covered of (unit -> 'a) | Uncovered of 'a;;

(* Zadanie 1 *)
let rec buyTicket table number =
  match (table, number) with
    | ((Covered h)::t, 1) -> Uncovered(h()) :: t
    | (h::t, n) ->  h :: buyTicket t (n - 1)
    | ([], _) -> [];;

(* Zakladamy ze podana liczba jest z przedzialu [1; table.length] *)
let table = [Covered(fun() -> 1); Covered(fun() -> 2); Covered(fun() -> 3); Covered(fun() -> 4); Covered(fun() -> 5)];;
let tableString = [Covered(fun() -> "Talon"); Covered(fun() -> "na"); Covered(fun() -> "balon"); Covered(fun() -> "!")];;

let t3 = buyTicket table 3;;
let t5 = buyTicket t3 5;;

buyTicket [] 3;;
buyTicket tableString 4;;