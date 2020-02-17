let rec gcd a b =
        if b = 0 then a else gcd b (a mod b);;
val gcd : int -> int -> int = <fun>

Printf.printf "%d da \n" (gcd 55 200);;