; https://projecteuler.net/problem=19
; Counting Sundays

; Problem 19
; You are given the following information, but you may prefer to do
; some research for yourself.

; 1 Jan 1900 was a Monday.
; Thirty days has September,
; April, June and November.
; All the rest have thirty-one,
; Saving February alone,
; Which has twenty-eight, rain or shine.
; And on leap years, twenty-nine.
; A leap year occurs on any year evenly divisible by 4,
; but not on a century unless it is divisible by 400.

; How many Sundays fell on the first of the month during the twentieth
; century (1 Jan 1901 to 31 Dec 2000)?

(use 'clojure.test)
(import java.time.DayOfWeek)
(import java.time.LocalDate)

(defn euler19
  "it returns how many Sundays fell on the first of the month during given
   two dates."
  ([] (euler19 "1901-01-01" "2000-12-31"))
  ([d1 d2]
    (letfn [(day-of-month [d] (.getDayOfMonth d))
            (sunday? [d] (= DayOfWeek/SUNDAY (.getDayOfWeek d)))
            (days-range [start end]
             "it returns a list of LocalDate from start (inclusive) to end
              (inclusive)."
              (let [inclusive-end (.plusDays (LocalDate/parse end) 1)]
                (take-while
                  #(.isBefore % inclusive-end)
                  (iterate #(.plusDays % 1) (LocalDate/parse start)))))]
      (count
        (filter #(and (sunday? %) (= 1 (day-of-month %)))
          (days-range d1 d2))))))


(is (= 171 (euler19)))
