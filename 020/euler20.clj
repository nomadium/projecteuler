; https://projecteuler.net/problem=20
; Factorial digit sum

; Problem 20
; n! means n × (n − 1) × ... × 3 × 2 × 1

; For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
; and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

; Find the sum of the digits in the number 100!


(use 'clojure.test)

(defn euler20
  "it returns the sum of the digits in the number n!"
  ([] (euler20 100))
  ([n]
    (letfn [(digits [k] (map #(Integer. (str %)) (seq (str k))))
            (factorial [k] (reduce *' (range 1 (inc k))))]

      (reduce + (digits (factorial n))))))


(is (= 27 (euler20 10)))
(is (= 648 (euler20)))
