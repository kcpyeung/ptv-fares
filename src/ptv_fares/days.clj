(ns ptv-fares.days)

(defn- full-weeks [paid-days]
  (->> (/ paid-days 7)
       int))

(defn- remaining-days-in-partial-week [total-paid-days]
  (let [paid-days-in-full-weeks (comp (partial * 7) #(full-weeks total-paid-days))]
    (- total-paid-days (paid-days-in-full-weeks))))

(defn used-days [paid-days]
  (let [weekdays                   (fn [days]
                                     (->> (full-weeks days)
                                          (* 5)))
        leftover                   (remaining-days-in-partial-week paid-days)
        ends-on-saturday?          (fn [] (zero? (rem (inc paid-days) 7)))
        ends-on-sunday?            (fn [] (zero? (rem paid-days 7)))]
    (cond
      (ends-on-saturday?)           (weekdays (inc paid-days))
      (ends-on-sunday?)             (weekdays paid-days)
      :else                         (->> (weekdays paid-days)
                                         (+ leftover)))))
