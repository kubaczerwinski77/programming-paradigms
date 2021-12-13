(* Jakub Czerwinski *)

(* Zadanie 1 *)
module StackMachine =
struct
  type t = { mutable l: float list }
  type instruction = Rst | LoadF of float | LoadI of int | Cpy | Add | Sub | Mul | Div
  exception DivisionByZero of string
  exception NotEnoughtElemOnStack of string
  exception EmptyStack of string

  let push(e, s) = s.l <- e :: s.l

  let top s =
    match s.l with
      h::_ -> h
      | [] -> raise(EmptyStack "module StackMachine: top")

  let pop s =
    match s.l with
      h::t -> s.l <- t
      | [] -> ()

  let isEmpty s = s.l = []

  let init() = { l = [] };;

  let result s = top s;; 

  let handleOperation inst s =
    match (inst, s) with
      | (Rst, s) -> s.l <- []
      | (Cpy, s) ->
          if isEmpty s then raise(EmptyStack "Stack is empty!")
          else 
            let elem = top s in
            push(elem, s)
      | (LoadF(f), s) -> push(f, s)
      | (LoadI(i), s) -> push(float_of_int i, s)
      | (Add, s) ->
          if match s.l with
            | h1 :: h2 :: l -> true
            | _ -> false
          then
            let e1 = top s
            in
            let e2 = pop s; top s
            in
            pop s;
            push(e1 +. e2, s)
          else raise(NotEnoughtElemOnStack "module StackMachine: handleOperation(Add)")
      | (Sub, s) ->
          if match s.l with
            | h1 :: h2 :: l -> true
            | _ -> false
          then
            let e1 = top s
            in
            let e2 = pop s; top s
            in
            pop s;
            push(e1 -. e2, s)
          else raise(NotEnoughtElemOnStack "module StackMachine: handleOperation(Sub)")
      | (Mul, s) ->
          if match s.l with
            | h1 :: h2 :: l -> true
            | _ -> false
          then
            let e1 = top s;
            in
            let e2 = pop s; top s
            in
            pop s;
            push(e1 *. e2, s)
          else raise(NotEnoughtElemOnStack "module StackMachine: handleOperation(Mul)")
      | (Div, s) ->
          if match s.l with
            | h1 :: h2 :: l -> true
            | _ -> false
          then
            let e1 = top s;
            in
            let e2 = pop s; top s
            in
              if e2 = 0. then raise(DivisionByZero "module StackMachine: handleOperation(DivBy0)")
              else 
                pop s;
                push(e1 /. e2, s)
          else raise(NotEnoughtElemOnStack "module StackMachine: handleOperation(Div)")

    let rec execute s opList =
    match opList with
      h :: t -> handleOperation h s;
                execute s t
      | [] -> ();;
  
end;;

(* Test z listy *)
(* let s = StackMachine.init();;
StackMachine.handleOperation (LoadI 98) s;;
StackMachine.handleOperation (LoadI 12) s;;
StackMachine.handleOperation (LoadI 45) s;;
StackMachine.handleOperation Add s;;
StackMachine.handleOperation Mul s;;
StackMachine.result s;; *)

(* Test z listy - mniej niz dwa arguemnty na stosie*)
(* let s = StackMachine.init();;
StackMachine.handleOperation (LoadI 98) s;;
StackMachine.handleOperation (LoadI 12) s;;
StackMachine.handleOperation (LoadI 45) s;;
StackMachine.handleOperation Add s;;
StackMachine.handleOperation Mul s;;
StackMachine.handleOperation Mul s;;
StackMachine.result s;; *)

(* Test z listy - dzielenie przez 0*)
(* let s = StackMachine.init();;
StackMachine.handleOperation (LoadI 0) s;;
StackMachine.handleOperation (LoadI 1) s;;
StackMachine.handleOperation Div s;;
StackMachine.result s;;
s;; *)

(* Test execute - wiem dlaczego dziala *)
(* let s = StackMachine.init();;
StackMachine.execute s [LoadI 98; LoadI 12; LoadI 45; Add; Mul];;
StackMachine.result s;; *)

(* Test Rst *)
let s = StackMachine.init();;
StackMachine.handleOperation (LoadF 98.) s;;
StackMachine.result s;;
s;;
StackMachine.handleOperation Rst s;;
s;;

module type COPROCESSOR =
sig
  type t
  type instruction =
        Rst
      | LoadF of float
      | LoadI of int
      | Cpy
      | Add
      | Sub
      | Mul
      | Div
  exception DivisionByZero of string
  exception NotEnoughtElemOnStack of string
  exception EmptyStack of string
  val init : unit -> t
  val result : t -> float
  val execute : t -> instruction list -> unit
end;;

module Coprocesor = ( StackMachine : COPROCESSOR );;

let c = Coprocesor.init();;