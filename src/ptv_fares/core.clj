(ns ptv-fares.core)

(def days (range 28 366))

(def cost-per-day 5.3)

(defn- full-weeks [paid-days]
  (->> (/ paid-days 7)
       int))

(defn- remaining-days-in-partial-week [total-paid-days]
  (let [paid-days-in-full-weeks (comp (partial * 7) #(full-weeks total-paid-days))]
    (- total-paid-days (paid-days-in-full-weeks))))

(defn used-days [paid-days]
  (let [weekdays-in-full-weeks (comp (partial * 5) #(full-weeks paid-days))
        leftover               (remaining-days-in-partial-week paid-days)
        is-full-week?          (fn [] (zero? (rem paid-days 7)))]
    (cond
      (is-full-week?)             (weekdays-in-full-weeks)
      :else                       (->> (weekdays-in-full-weeks)
                                       (+ leftover)))))
