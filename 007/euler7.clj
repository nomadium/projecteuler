; https://projecteuler.net/problem=7
; 10001st prime

; Problem 7
; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
; we can see that the 6th prime is 13.

; What is the 10 001st prime number?

(use 'clojure.test)

(defn euler7
  "it returns the n-th prime number"
  ([] (euler7 10001))
  ([n]
    (letfn [(prime? [k]
              (and (>= k 2) (every? pos? (map #(mod k %) (range 2 k)))))]
      (last (take n
                  (filter prime? (range)))))))

(is (= 13 (euler7 6)))
(is (= 104743 (euler7)))
