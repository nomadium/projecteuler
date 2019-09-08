; https://projecteuler.net/problem=5
; Smallest multiple

; Problem 5
; 2520 is the smallest number that can be divided by each of the numbers
; from 1 to 10 without any remainder.

; What is the smallest positive number that is evenly divisible by all of
; the numbers from 1 to 20?

(use 'clojure.test)

(defn euler5
  "it returns the smallest positive number that is evenly divisible by
   all the numbers from 1 to the given number."
  ([] (euler5 20))
  ([n]
    (letfn [(evenly-divisible-by-all-from-1-to? [m]
              (every? zero? (map #(mod m %) (range 1 n))))]
      (let [all-positive-numbers (filter pos? (range))]
        ; to-do: it must be a more efficient way of doing this
        ; "Elapsed time: 243297.01325 msecs"
        (first (filter evenly-divisible-by-all-from-1-to?
                       all-positive-numbers))))))

(is (= 2520 (euler5 10)))
(is (= 232792560 (euler5)))
