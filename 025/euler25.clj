; https://projecteuler.net/problem=25
; 1000-digit Fibonacci number

; Problem 25
; The Fibonacci sequence is defined by the recurrence relation:

; Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
; Hence the first 12 terms will be:

; F1 = 1
; F2 = 1
; F3 = 2
; F4 = 3
; F5 = 5
; F6 = 8
; F7 = 13
; F8 = 21
; F9 = 34
; F10 = 55
; F11 = 89
; F12 = 144
; The 12th term, F12, is the first term to contain three digits.

; What is the index of the first term in the Fibonacci sequence to contain
; 1000 digits?


(use 'clojure.test)

(defn euler25
  "it returns the index of the first term in the Fibonacci sequence to contain
   n digits."
  ([] (euler25 1000))
  ([n]
    (letfn [(fibonacci []
              (letfn [(fib [l] (conj l (+' (first l) (first (rest l)))))]
                (conj (map first (iterate fib (list 1 1))) 1)))
            (digits [k] (map #(Integer. (str %)) (seq (str k))))
            (fibonacci-idx [v] (inc (get v 0)))]
      (fibonacci-idx
        (first
            (filter #(>= (count (digits (get % 1))) n)
                  (map-indexed vector (fibonacci))))))))


(is (= 12 (euler25 3)))
(is (= 4782 (euler25)))
