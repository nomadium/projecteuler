; https://projecteuler.net/problem=9
; Special Pythagorean triplet

; Problem 9
; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

; a^2 + b^2 = c^2
; For example, 32 + 42 = 9 + 16 = 25 = 52.

; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.

(use 'clojure.test)

(defn euler9
  "it returns the product abc of the unique Pythagorean triplet for which
   a + b + c = 1000."
  ([]
    (letfn [(special-triplet? [t]
              (= 1000 (+ (:a t) (:b t) (:c t))))]
      (let [pythagorean-triplets
              ; to-do: fix: it should not be necessary to put a limit in the
              ; range. however, I chose 1000 as limit because something seems
              ; to require to evaluate the infinite range eagerly.
              (for [x (range 1000)
                    y (range 1000)
                    :when (> x y)]
                {:a (- (* x x) (* y y))
                 :b (* 2 x y)
                 :c (+ (* x x) (* y y))})
            special-pythagorean-triplet
              (first (filter special-triplet? pythagorean-triplets))]

        (* (:a special-pythagorean-triplet)
           (:b special-pythagorean-triplet)
           (:c special-pythagorean-triplet))))))

(is (= 31875000 (euler9)))
