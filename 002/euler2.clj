; https://projecteuler.net/problem=2
; Even Fibonacci numbers

; Problem 2
; Each new term in the Fibonacci sequence is generated by adding the previous
; two terms. By starting with 1 and 2, the first 10 terms will be:

; 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

; By considering the terms in the Fibonacci sequence whose values do not
; exceed four million, find the sum of the even-valued terms.

(use 'clojure.test)

(defn euler2
  ([] (euler2 4000000))
  ([n]
    (defn fibonacci [n]
      (defn fib [l] (conj l (+ (first l) (first (rest l)))))
      (conj (take-while (fn [x] (< x n))
                        (map first (iterate fib '(1 1))))
            1))
    (reduce + (filter even? (fibonacci n)))))

(is (= 4613732 (euler2)))
