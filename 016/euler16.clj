; https://projecteuler.net/problem=16
; Power digit sum

; Problem 16
; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

; What is the sum of the digits of the number 2^1000?

(use 'clojure.test)

(defn euler16
  "it returns the sum of the digits of the number 2^n."
  ([] (euler16 1000))
  ([n]
    (letfn [(expt [b n] (.pow 2M n))
            (digits [k] (map #(Integer. (str %)) (seq (.toString k))))]
      (reduce + (digits (expt 2 n))))))


(is (= 26 (euler16 15)))
(is (= 1366 (euler16)))
